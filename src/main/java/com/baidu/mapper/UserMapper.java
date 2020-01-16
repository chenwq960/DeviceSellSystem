package com.baidu.mapper;

import java.util.List;

import com.baidu.dto.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	// 通过账号查询用户
	User selectByAccount(String account);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> showUser();
	
//根据部门名称查询部门ID
	int selectUserDepartment(String departmentName);
//查看详细的方式
	User showshowDetailed(String userId);
	
}