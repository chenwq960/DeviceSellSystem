package com.baidu.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.po.RegionPO;
import com.baidu.service.IRegionService;
@Controller
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private IRegionService service;
    
    @RequestMapping("/create")
    @ResponseBody
    public List<RegionPO> selectByparentRegionId(Integer regionId) {
       List<RegionPO> list = service.selectByparentRegionId(regionId);
       return list;
    }
}
