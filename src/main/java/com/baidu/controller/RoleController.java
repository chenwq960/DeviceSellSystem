package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.interceptor.CurrentContext;
import com.baidu.po.RolePO;
import com.baidu.po.UserPO;
import com.baidu.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    // 角色表的查询方式
    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView roleFind(//
            @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @RequestParam(value = "searchKey", required = false) String searchKey,
            @RequestParam(value = "startTime",required = false)String startTime,
            @RequestParam(value = "endTime",required = false)String endTime) {
        PageHelper.startPage(pageNum, 5);
        List<RolePO> roleList = roleService.queryList(searchKey,startTime,endTime);
        PageInfo<RolePO> pi = new PageInfo<RolePO>(roleList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("role", roleList);
        mav.addObject("modelName", searchKey);
        mav.addObject("limitmodel", pi);
        mav.addObject("startTime", startTime);
        mav.addObject("endTime", endTime);
        mav.setViewName("role/list");
        return mav;
    }

    // 角色增加的方法
    @ResponseBody
    @RequestMapping("/create")
    public boolean createRole(String roleName, HttpSession session) {
        UserPO user = CurrentContext.getUser();

        try {
            roleService.createRole(roleName, user.getUserId());
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // 角色的修改方法
    @ResponseBody
    @RequestMapping("/update")
    public boolean updateRole(RolePO rolePO, HttpSession session) {
        int userId = UserPO.class.cast(session.getAttribute("currentUser")).getUserId();
        roleService.updateRole(rolePO, userId);
        return true;
    }

    // 角色表格删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteRole(int roleId) {
        roleService.deleteRole(roleId);
        return true;
    }

    // 角色回显的方法
    @ResponseBody
    @RequestMapping("/detail")
    public RolePO rolehx(int roleId) {
        return roleService.roleDetail(roleId);
    }
}
