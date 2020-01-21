package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.form.SearchParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.DepartmentMapper;
import com.baidu.po.DepartmentPO;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	// 部门表的查询方式
	@Override
	public List<DepartmentPO> departmentFind(SearchParam searchParam) {
		return departmentMapper.selectList(searchParam);
	}
	// 部门表的增加方法
	@Override
	public int createdepartment(String departmentName) {
	    DepartmentPO departmentPO = new DepartmentPO();
	// 当前用户
		departmentPO.setUpdateUser(CurrentContext.getUser().getUserId());
		departmentPO.setCreateUser(CurrentContext.getUser().getUserId());
		 departmentPO.setDepartmentName(departmentName);
		departmentPO.setCreateTime(new Date());
		departmentPO.setUpdateTime(new Date());
		departmentPO.setIsDelete(false);
		return departmentMapper.insert(departmentPO);
	}
	// 部门表格删除的方法
	@Override
	public void departmentdel(Integer departmentId) {
		departmentMapper.updateSetIdDelete(departmentId);
	}

	// 部门表格回显的方法
	@Override
	public DepartmentPO departmenthx(Integer departmentId) {
		return departmentMapper.selectByPrimaryKey(departmentId);
	}

	// 部门表修改的方法
	@Override
	public int updatedepartment(DepartmentPO departmentPO) {
	    departmentPO.setUpdateTime(new Date());
        departmentPO.setUpdateUser(CurrentContext.getUser().getUserId());
		return departmentMapper.updateByPrimaryKeySelective(departmentPO);
	}

}
