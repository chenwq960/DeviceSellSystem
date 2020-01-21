package com.baidu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.po.StationPO;
import com.baidu.service.IStationService;
@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private IStationService service;
    private static Logger logger = LoggerFactory.getLogger(StationController.class);

    @RequestMapping("/list/page")
    public String list(ModelMap modelMap) {
        List<StationPO> list = service.getStationList();
        modelMap.put("list", list);
        return "station/list";
    }

    // 查询所有的销售人员
    @ResponseBody
    @RequestMapping("/list")
    public List<StationPO> selectStationUser() {
        List<StationPO> list = service.getStationList();
        return list;
    }

    // 增加的按钮
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(StationPO station) {
        try {
            service.create(station);
            return true;
        }
        catch (Exception e) {
            logger.error("网点的增加方法发生异常，param{},exc:{}",station,e);
            return false;
        }
    }

    // 删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer stationId) {
        try {
            service.delete(stationId);
            return true;
        }
        catch (Exception e) {
            logger.error("网点的删除方法发生异常，param{},exc:{}",stationId,e);
            return false;
        }
    };

    // 回显的方法
    @ResponseBody
    @RequestMapping("/detail")
    public StationPO detail(Integer stationId) {
        StationPO update = service.update(stationId);
        return update;
    };

    @ResponseBody
    @RequestMapping("/update")
    public void changeStation(StationPO station) {
    }
/*
    @RequestMapping("/selectCity")
    @ResponseBody
    public List<RegionPO> selectByparentRegionId(Integer regionId) {
        List<RegionPO> list = service.selectByparentRegionId(regionId);
        return list;
    }
    */

}
