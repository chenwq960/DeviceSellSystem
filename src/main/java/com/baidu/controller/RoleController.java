package com.baidu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.form.SearchParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.po.RolePO;
import com.baidu.po.UserPO;
import com.baidu.service.IRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/role")
public class RoleController {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private IRoleService roleService;
    // 角色表的查询方式
    @RequestMapping("/list/page")
    public String roleFind(SearchParam searchParam, ModelMap modelMap) {
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<RolePO> roleList = roleService.queryList(searchParam);
        PageInfo<RolePO> pageInfo = new PageInfo<RolePO>(roleList);
        modelMap.put("role", roleList);
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("searchParam", searchParam);
        return "role/list";
    }
    // 查询所有的事角色 作为销售人员
    @ResponseBody
    @RequestMapping("/list")
    public List<RolePO> roleName() {
        List<RolePO> roleList = roleService.queryList(null);
        return roleList;
    }

    // 角色增加的方法
    @ResponseBody
    @RequestMapping("/create")
    public boolean createRole(String roleName) {
        UserPO user = CurrentContext.getUser();
        try {
            roleService.createRole(roleName, user.getUserId());
            return true;
        }
        catch (Exception ext) {
            logger.error("添加角色发生异常，param:{},exc:{}", roleName, ext);
            return false;
        }
    }

    // 角色的修改方法
    @ResponseBody
    @RequestMapping("/update")
    public boolean updateRole(RolePO rolePO) {
        try {
            roleService.updateRole(rolePO);
            return true;
        }
        catch (Exception e) {
            logger.error("修改角色发生异常，param:{},exc:{}", rolePO, e);
            return false;
        }
    }
    // 角色表格删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteRole(int roleId) {
        try {
            roleService.deleteRole(roleId);
            return true;
        }
        catch (Exception e) {
            logger.error("删除角色发生异常.param:{},exc:{}",roleId,e);
            return false;
        }
    }
    // 角色回显的方法
    @ResponseBody
    @RequestMapping("/detail")
    public RolePO rolehx(int roleId) {
        return roleService.roleDetail(roleId);
    }
}
