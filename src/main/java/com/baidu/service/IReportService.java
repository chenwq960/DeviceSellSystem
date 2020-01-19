package com.baidu.service;

import java.util.Date;
import java.util.Map;

public interface IReportService {

    // 查询各个角色人员占比
    Map<String, Integer> queryRoleUserData();
    
    Map<String, Integer> queryDepartmentApply();
     //人员创建时间趋势图
    Map<String, Date> selectUserCreateTime();

}
