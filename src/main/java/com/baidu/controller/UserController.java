package com.baidu.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.form.SearchParam;
import com.baidu.form.UserParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.po.UserPO;
import com.baidu.service.IFileService;
import com.baidu.service.IUserService;
import com.baidu.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 人员相关接口
 * 
 * @author chenwq
 * @createTime 2020-01-16 21:27:24
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;
    @Autowired
    @Qualifier("localFileService")
    private IFileService fileService;

    // 登陆的验证方法
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(String account, String password, HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        ModelAndView mav = new ModelAndView();
        try {
            UserPO user = userService.queryDetailByAccount(account);
            if (Objects.isNull(user)) {
                throw new RuntimeException("当前账号不存在");
            }
            else if (Objects.equals(user.getPassword(), CommonUtil.md5(password)) == false) {
                throw new RuntimeException("密码错误");
            }

            CurrentContext.setUser(user);
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect(request.getContextPath() + "/views/layout/main.jsp");
            return null;
        }
        catch (Exception e) {
            mav.addObject("msg", e.getMessage());
            mav.setViewName("user/login");
        }
        return mav;
    }

    // 查看所有的方法
    @RequestMapping("/list/page")
    public String list(SearchParam searchParam, ModelMap modelMap) {
        // 开启分页
        PageHelper.startPage(searchParam.getPageNum(), 4);
        List<UserPO> userList = userService.showUser(searchParam);
        PageInfo<UserPO> pageInfo = new PageInfo<>(userList);
        modelMap.put("list", userList);
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("searchParam", searchParam);
        return "user/list";
    }

    // 查看详细的方法
    @ResponseBody
    @RequestMapping("/detail")
    public UserPO detailed(Integer userId) {
        UserPO userPO = userService.showDetailed(userId);
        userPO.setIdCardFront(fileService.getHost() + userPO.getIdCardFront());
        return userPO;
    }

    // 增加的方法
    @RequestMapping("/create")
    public String create(UserParam userParam, ModelMap modelMap) {
        try {
            userService.create(userParam);
            return list(new SearchParam(), modelMap);
        }
        catch (Exception e) {
            logger.error("人员表增加的方法发生异常,param{},exc{}", userParam, e);
            modelMap.put("error", e);
            return "error/error";
        }
    }

    // 人员修改的方法
    @RequestMapping("/update")
    public String update(UserParam userParam, ModelMap modelMap) {
        try {
            userService.update(userParam);
            return list(new SearchParam(), modelMap);
        }
        catch (Exception e) {
            logger.error("人员修改的方法发生异常，param{},exc:{}", userParam, e);
            modelMap.put("error", e);
            return "error/error";
        }
    }

    // 删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer userId) {
        try {
            userService.delete(userId);
            return true;
        }
        catch (Exception e) {
            logger.error("人员删除方法发生异常，param{}:exc:{}", userId, e);
            return false;
        }
    }

    @RequestMapping("/idcard/download")
    public void downloadIdCard(Integer userId, HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        UserPO userPO = userService.showDetailed(userId);

        String filePath = fileService.getWorkPath() + userPO.getIdCardFront();
        String fileName = userPO.getRealName() + ".png";
        String fileType = "application/octet-stream";

        String agent = request.getHeader("User-agent");
        if (agent.indexOf("Firefox") != -1) {
            response.addHeader("content-Disposition", "attachment;fileName==?UTF-8?B?"
                    + Base64.getEncoder().encodeToString(fileName.getBytes("utf-8")) + "?=");
        }
        else {
            response.addHeader("content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "utf-8"));
        }

        // 设置文件的类型
        response.setContentType(fileType);
        // 确保弹出下载对话框
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            OutputStream outputStream = response.getOutputStream();

            IOUtils.copy(inputStream, response.getOutputStream());
            outputStream.flush();
        }
        catch (IOException e) {
            logger.error("人员身份证下载异常，userId{} ", userId, e);
        }
    }

}
