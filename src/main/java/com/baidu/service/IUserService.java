package com.baidu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baidu.dto.User;
import com.baidu.util.BaiduUtil.IdCardFront;

public interface IUserService {

	List<User> showUser();
	
	User queryDetailByAccount(String account);

	//根据部门名称查询部门的ID
	int selectUserDepartment(String departmentName);

//人员的增加信息
	void create(User user, IdCardFront idCardFrontInfo, String md5, String name, HttpSession session);
//查看详细的方法
	User showDetailed(String userId);
//删除用户
	void delete(Integer userId);
}
