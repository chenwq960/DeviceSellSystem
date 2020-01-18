package com.baidu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    @RequestMapping("/list")
    public String list(SearchParam searchParam, ModelMap modelMap) {
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());

        List<UserPO> userList = userService.showUser();

        PageInfo<UserPO> pi = new PageInfo<>(userList);
        modelMap.put("list", userList);
        modelMap.put("limitmodel", pi);
        modelMap.put("searchParam", searchParam);

        return "user/list";
    }

    // 查看详细的方法
    @ResponseBody
    @RequestMapping("/detailed")
    public UserPO detailed(String userId) {
        UserPO userPO = userService.showDetailed(userId);
        userPO.setIdCardFront(fileService.getHost() + userPO.getIdCardFront());
        return userPO;
    }

    // 增加的方法
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(UserParam userParam, HttpSession session) {
        try {
            userService.create(userParam);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
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
            return false;
        }
    }
}
