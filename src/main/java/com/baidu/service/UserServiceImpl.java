package com.baidu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dto.User;
import com.baidu.mapper.UserMapper;
import com.baidu.util.BaiduUtil.IdCardFront;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> showUser() {
		return userMapper.showUser();
	}

	@Override
	public User queryDetailByAccount(String account) {
		return userMapper.selectByAccount(account);
	}

//根据部门名称查询部门ID
	@Override
	public int selectUserDepartment(String departmentName) {
		// TODO Auto-generated method stub
		return userMapper.selectUserDepartment(departmentName);
	}
//人员的增加信息
	@Override
	public void create(User user, IdCardFront idCardFrontInfo, String md5, String name, HttpSession session) {
		user.setIdCardFront(name);
		user.setPassword(md5);
		user.setRealName(idCardFrontInfo.getName());
		user.setNation(idCardFrontInfo.getNation());
		user.setAddress(idCardFrontInfo.getAddress());
		user.setIdCard(idCardFrontInfo.getIdCard());
		user.setSex(idCardFrontInfo.getSex()=="男"?1:2);
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		User attribute = (User) session.getAttribute("currentUser");
		user.setCreateUser(attribute.getUserId());
		user.setUpdateUser(attribute.getUserId());
		user.setRoleId(attribute.getUserId());
		user.setDepartmentId(attribute.getUserId());
		user.setIsDelete(0);
		user.setUpdateTime(new Date());
		@SuppressWarnings("unused")
		int insert = userMapper.insert(user);
	}

//查看详细的方法
	@Override
	public User showDetailed(String userId) {
		return userMapper.showshowDetailed(userId);
	}

//删除用户
	@Override
	public void delete(Integer userId) {
		@SuppressWarnings("unused")
		int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(userId);
	}

}
