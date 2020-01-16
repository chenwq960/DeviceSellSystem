package com.baidu.mapper;

import java.util.List;

import com.baidu.po.RolePO;

public interface RoleMapper {

	int deleteByPrimaryKey(Integer roleId);

	int insert(RolePO record);

	int insertSelective(RolePO record);

	RolePO selectByPrimaryKey(Integer roleId);

	List<RolePO> selectList();

	int updateByPrimaryKeySelective(RolePO record);

	int updateByPrimaryKey(RolePO record);

}