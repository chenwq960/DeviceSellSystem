package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.Role;
import com.baidu.mapper.RoleMapper;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	// 角色的增加方法
	@Override
	public void createRole(String roleName, int createUser) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setCreateTime(new Date());
		role.setCreateUser(createUser);
		role.setUpdateTime(new Date());
		role.setUpdateUser(createUser);
		role.setIsDelete(false);
		@SuppressWarnings("unused")
		int insert = roleMapper.insert(role);
	}

	@Override
	public void updateRole(Role role, int updateUser) {
		role.setUpdateTime(new Date());
		role.setUpdateUser(updateUser);

		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public List<Role> queryList(String searchKey) {
		return roleMapper.selectList();
	}

	@Override
	public void deleteRole(int roleId) {
		roleMapper.deleteByPrimaryKey(roleId);

	}

	@Override
	public Role roleDetail(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

}
