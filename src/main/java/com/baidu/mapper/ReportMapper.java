package com.baidu.mapper;

import java.util.List;

import com.baidu.vo.DepartmentApply;
import com.baidu.vo.RoleUserVO;
import com.baidu.vo.UserCreateTime;

public interface ReportMapper {

    List<RoleUserVO> queryRoleUserData();

    List<DepartmentApply> departmentApply();

    List<UserCreateTime> selectUserCreateTime();

}
