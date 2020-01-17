package com.baidu.service;

import java.util.List;

import com.baidu.po.RolePO;

public interface IRoleService {

	void createRole(String role, int createUser);

	void updateRole(RolePO rolePO, int updateUser);

	List<RolePO> queryList(String searchKey,String startTime,String endTime);

	void deleteRole(int roleId);

	RolePO roleDetail(int roleId);
	
}
