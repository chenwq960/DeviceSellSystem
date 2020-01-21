package com.baidu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.form.SearchParam;
import com.baidu.po.DepartmentPO;
import com.baidu.service.IDepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 部门相关Controller
 * 
 * @author Administrator
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    // @Autowired
    @Resource
    private IDepartmentService departmentService;

    // 部门表的查询
    @RequestMapping("/list/page")
    public String departmentList(SearchParam searchParam, ModelMap modelMap) {
        // 开启分页
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        // 调用service层的方法
        List<DepartmentPO> departmentFind = departmentService.departmentFind(searchParam);
        PageInfo<DepartmentPO> pageInfo = new PageInfo<DepartmentPO>(departmentFind);
        modelMap.put("department", departmentFind);
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("searchParam", searchParam);
        return "department/list";
    }

    // 部门表修改提交的方法
    @ResponseBody
    @RequestMapping("/update")
    public boolean updateDepartment(DepartmentPO departmentPO) {

        try {
            departmentService.updatedepartment(departmentPO);
            return true;
        }
        catch (Exception e) {
            logger.error("部门修改发生异常,param:{},exc:{}", departmentPO, e);
            return false;
        }
    }

    // 部门表添加的方法
    @ResponseBody
    @RequestMapping("/create")
    public boolean createdepartment(String departmentName) {
        try {
            departmentService.createdepartment(departmentName);
            return true;
        }
        catch (Exception e) {
            logger.error("部门添加发生异常,param{},exc:{}", departmentName, e);
            return false;
        }
    }

    // 部门表删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean departmentdel(Integer departmentId) {
        try {
            departmentService.departmentdel(departmentId);
            return true;
        }
        catch (Exception e) {
            logger.error("部门删除发生异常,param{},exc:{}", departmentId, e);
            return false;
        }
    }

    // 部门回显的方法
    @ResponseBody
    @RequestMapping("/detail")
    public DepartmentPO departmenthx(Integer departmentId) {
        DepartmentPO departmentPO = departmentService.departmenthx(departmentId);
        return departmentPO;
    }

    // 查找所有的部门，回显的时候准备
    @ResponseBody
    @RequestMapping("/list")
    public List<DepartmentPO> departmentfind() {
        List<DepartmentPO> model = departmentService.departmentFind(null);
        return model;
    }

}
