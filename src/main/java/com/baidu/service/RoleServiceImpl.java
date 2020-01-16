package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.RoleMapper;
import com.baidu.po.RolePO;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	// 角色的增加方法
	@Override
	public void createRole(String roleName, int createUser) {
		RolePO rolePO = new RolePO();
		rolePO.setRoleName(roleName);
		rolePO.setCreateTime(new Date());
		rolePO.setCreateUser(createUser);
		rolePO.setUpdateTime(new Date());
		rolePO.setUpdateUser(createUser);
		rolePO.setIsDelete(false);
		@SuppressWarnings("unused")
		int insert = roleMapper.insert(rolePO);
	}

	@Override
	public void updateRole(RolePO rolePO, int updateUser) {
		rolePO.setUpdateTime(new Date());
		rolePO.setUpdateUser(updateUser);

		roleMapper.updateByPrimaryKeySelective(rolePO);
	}

	@Override
	public List<RolePO> queryList(String searchKey) {
		return roleMapper.selectList();
	}

	@Override
	public void deleteRole(int roleId) {
		roleMapper.deleteByPrimaryKey(roleId);

	}

	@Override
	public RolePO roleDetail(int roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}

}
