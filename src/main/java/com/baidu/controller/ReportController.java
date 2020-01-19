package com.baidu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.service.IReportService;

/**
 * 报表接口类
 * 
 * @author chenwq
 * @createTime 2020-01-18 21:19:19
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @RequestMapping("/roleUser/data")
    public Map<String, Integer> getRoleUserData() {

        return reportService.queryRoleUserData();
    }

}
