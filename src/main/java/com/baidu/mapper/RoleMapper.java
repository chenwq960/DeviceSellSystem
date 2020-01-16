package com.baidu.mapper;

import java.util.List;

import com.baidu.dto.Role;

public interface RoleMapper {

	int deleteByPrimaryKey(Integer roleId);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer roleId);

	List<Role> selectList();

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

}