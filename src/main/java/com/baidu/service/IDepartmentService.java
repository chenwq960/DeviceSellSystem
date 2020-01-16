package com.baidu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.po.DepartmentPO;

public interface IDepartmentService {

	List<DepartmentPO> departmentFind(String searchKey, Date startTime, Date endTime);

	int createdepartment(DepartmentPO departmentPO,HttpSession session);

	void departmentdel(Integer id);

	DepartmentPO departmenthx(Integer id);


	int updatedepartment(DepartmentPO departmentPO);

}
