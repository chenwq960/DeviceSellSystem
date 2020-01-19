package com.baidu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.form.SearchParam;
import com.baidu.po.DepartmentPO;
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

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private IDepartmentService departmentService;

    // 部门表的查询
    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView departmentList(SearchParam searchParam) {
        PageHelper.startPage(searchParam.getPageNum(), 5);
        List<DepartmentPO> departmentFind = departmentService.departmentFind(searchParam);
        PageInfo<DepartmentPO> pi = new PageInfo<DepartmentPO>(departmentFind);
        ModelAndView mav = new ModelAndView();
        mav.addObject("department", departmentFind);
        mav.addObject("limitmodel", pi);
        mav.addObject("searchKey", searchParam.getSeachKey());
        mav.setViewName("department/list");
        return mav;
    }

    // 部门表修改提交的方法
    @RequestMapping("/update")
    @ResponseBody
    public boolean updateDepartment(DepartmentPO departmentPO) {

        try {
            departmentService.updatedepartment(departmentPO);
            return true;
        }
        catch (Exception e) {
            logger.error("部门修改发生异常,param{}", departmentPO);
            return false;
        }
    }

    // 部门表添加的方法
    @RequestMapping("/createdepartment")
    @ResponseBody
    public boolean createdepartment(@Param("departmentName") String departmentName) {
        DepartmentPO departmentPO = new DepartmentPO();
        departmentPO.setDepartmentName(departmentName);
        try {
            departmentService.createdepartment(departmentPO);
            return true;
        }
        catch (Exception e) {
            logger.error("部门表添加的方法,param{}", departmentName);
            return false;
        }
    }

    // 部门表删除的方法
    @RequestMapping("/departmentdel")
    @ResponseBody
    public boolean departmentdel(Integer UserId) {
        try {
            departmentService.departmentdel(UserId);
            return true;
        }
        catch (Exception e) {
            logger.error("部门表删除的方法,param{}", UserId);
            return false;
        }

    }

    // 部门回显的方法
    @RequestMapping("/departmenthx")
    @ResponseBody
    public DepartmentPO departmenthx(Integer departmentId) {
        DepartmentPO departmentPO = departmentService.departmenthx(departmentId);
        return departmentPO;
    }

    // 查找所有的部门，回显的时候准备
    @ResponseBody
    @RequestMapping("/departmentfind")
    public List<DepartmentPO> departmentfind() {
        List<DepartmentPO> model = departmentService.departmentFind(null);
        return model;
    }

}
