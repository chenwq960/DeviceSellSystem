package com.baidu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.dto.Department;
import com.baidu.dto.User;
import com.baidu.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门相关Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	// 部门表的查询
	@RequestMapping("/list")
	@ResponseBody
	public ModelAndView departmentList(
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "searchKey", required = false) String searchKey,
			@RequestParam(value = "startTime",required = false)Date startTime,
			@RequestParam(value = "endTime",required = false)Date endTime) {
		PageHelper.startPage(pageNum, 5);
		List<Department> departmentFind = departmentService.departmentFind(searchKey,startTime,endTime);
		PageInfo<Department> pi = new PageInfo<Department>(departmentFind);
		ModelAndView mav = new ModelAndView();
		mav.addObject("department", departmentFind);
		mav.addObject("limitmodel", pi);
		mav.addObject("searchKey", searchKey);
		mav.setViewName("department/list");
		return mav;
	}

	// 部门表修改提交的方法
	@RequestMapping("/update")
	@ResponseBody
	public boolean updateDepartment(Department department, HttpSession session) {
		department.setUpdateTime(new Date());
		int userId = User.class.cast(session.getAttribute("currentUser")).getUserId();
		department.setUpdateUser(userId);
		Object attribute = session.getAttribute("number");
		department.setUpdateUser((Integer) attribute);
		try {
			@SuppressWarnings("unused")
			int i = departmentService.updatedepartment(department);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// 部门表添加的方法
	@RequestMapping("/createdepartment")
	@ResponseBody
	public int createdepartment(@Param("departmentName") String departmentName, HttpSession session) {
		Department department = new Department();
		department.setDepartmentName(departmentName);
		int i = departmentService.createdepartment(department,session);
		return i;
	}

	// 部门表删除的方法
	@RequestMapping("/departmentdel")
	@ResponseBody
	public boolean departmentdel(Integer UserId) {
		try {
			departmentService.departmentdel(UserId);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

	// 部门回显的方法
	@RequestMapping("/departmenthx")
	@ResponseBody
	public Department departmenthx(Integer id) {
		Department department = departmentService.departmenthx(id);
		return department;
	}

	// 查找所有的部门，回显的时候准备
	@RequestMapping("/departmentfind")
	@ResponseBody
	public List<Department> departmentfind() {
		List<Department> model = departmentService.departmentFind(null, null, null);
		System.out.println(model);
		return model;
	}

}
