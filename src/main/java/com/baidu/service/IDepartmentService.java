package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.po.DepartmentPO;

public interface IDepartmentService {

	List<DepartmentPO> departmentFind(String searchKey,String startTime, String endTime);

	int createdepartment(DepartmentPO departmentPO,HttpSession session);

	void departmentdel(Integer id);

	DepartmentPO departmenthx(Integer id);


	int updatedepartment(DepartmentPO departmentPO);

}
