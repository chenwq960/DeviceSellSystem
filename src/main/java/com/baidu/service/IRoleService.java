package com.baidu.service;

import java.util.List;

import com.baidu.dto.Role;

public interface IRoleService {

	void createRole(String role, int createUser);

	void updateRole(Role role, int updateUser);

	List<Role> queryList(String searchKey);

	void deleteRole(int roleId);

	Role roleDetail(int roleId);
	
}
