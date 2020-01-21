package com.baidu.service;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.po.DepartmentPO;

public interface IDepartmentService {

	List<DepartmentPO> departmentFind(SearchParam searchParam);

	int createdepartment(String departmentName);

	void departmentdel(Integer id);

	DepartmentPO departmenthx(Integer id);


	int updatedepartment(DepartmentPO departmentPO);

}
