package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.Role;
import com.baidu.dto.User;
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
			@RequestParam(value = "searchKey", required = false) String searchKey) {
		PageHelper.startPage(pageNum, 5);
		List<Role> role = roleService.queryList(searchKey);
		PageInfo<Role> pi = new PageInfo<Role>(role);
		ModelAndView mav = new ModelAndView();
		mav.addObject("role", role);
		mav.addObject("modelName", searchKey);
		mav.addObject("limitmodel", pi);
		mav.setViewName("role/list");
		return mav;
	}

	// 角色增加的方法
	@ResponseBody
	@RequestMapping("/create")
	public boolean createRole(String roleName, HttpSession session) {
		int userId = User.class.cast(session.getAttribute("currentUser")).getUserId();
		try {
			 roleService.createRole(roleName, userId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 角色的修改方法
	@ResponseBody
	@RequestMapping("/update")
	public boolean updateRole(Role role, HttpSession session) {
		int userId = User.class.cast(session.getAttribute("currentUser")).getUserId();
		roleService.updateRole(role, userId);
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
	public Role rolehx(int roleId) {
		return roleService.roleDetail(roleId);
	}
}
