package com.baidu.test;

import com.baidu.service.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		UserServiceImpl u = new UserServiceImpl();
		int selectUserDepartment = u.selectUserDepartment("销售部门");
		System.out.println(selectUserDepartment);
	}
}
