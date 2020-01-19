package com.baidu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.ReportMapper;
import com.baidu.vo.DepartmentApply;
import com.baidu.vo.RoleUserVO;
import com.baidu.vo.UserCreateTime;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public Map<String, Integer> queryRoleUserData() {
        return reportMapper.queryRoleUserData().stream()
                .collect(Collectors.toMap(RoleUserVO::getRoleName, RoleUserVO::getUserCount));
    }

    @Override
    public Map<String, Integer> queryDepartmentApply() {
         List<DepartmentApply> departmentApply = reportMapper.departmentApply();
        return departmentApply.stream().collect(Collectors.toMap(DepartmentApply::getDepartment,DepartmentApply::getUserNum));
    }
    //人员创建时间趋势图
    @Override
    public Map<String, Date> selectUserCreateTime() {
       List<UserCreateTime> selectUserCreateTime = reportMapper.selectUserCreateTime();
       Map<String, Date> collect = selectUserCreateTime.stream().collect(Collectors.toMap(UserCreateTime::getUsername,UserCreateTime::getCreatetime));
       return collect;
    }

}
