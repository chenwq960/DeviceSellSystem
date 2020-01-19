package com.baidu.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.ReportMapper;
import com.baidu.vo.RoleUserVO;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public Map<String, Integer> queryRoleUserData() {
        return reportMapper.queryRoleUserData().stream()
                .collect(Collectors.toMap(RoleUserVO::getRoleName, RoleUserVO::getUserCount));
    }

}
