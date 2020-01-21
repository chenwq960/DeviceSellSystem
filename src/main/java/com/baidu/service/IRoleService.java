package com.baidu.service;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.po.RolePO;

public interface IRoleService {

	void createRole(String role, int createUser);

	void updateRole(RolePO rolePO);

	List<RolePO> queryList(SearchParam searchParam);

	void deleteRole(int roleId);

	RolePO roleDetail(int roleId);
	
}
