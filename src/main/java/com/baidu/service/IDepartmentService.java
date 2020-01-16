package com.baidu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.dto.Department;

public interface IDepartmentService {

	List<Department> departmentFind(String searchKey, Date startTime, Date endTime);

	int createdepartment(Department department,HttpSession session);

	void departmentdel(Integer id);

	Department departmenthx(Integer id);


	int updatedepartment(Department department);

}
