package com.baidu.service;

import java.util.Map;

public interface IReportService {

    // 查询各个角色人员占比
    Map<String, Integer> queryRoleUserData();

}
