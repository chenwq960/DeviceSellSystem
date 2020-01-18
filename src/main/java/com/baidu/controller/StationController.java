package com.baidu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.po.RegionPO;
import com.baidu.po.StationPO;
import com.baidu.service.IStationService;

@Controller
@RequestMapping("/station")
public class StationController {
    @Autowired
    private IStationService service;

    @ResponseBody
    @RequestMapping("/list")
    public ModelAndView list() {
        List<StationPO> list = service.getStationList();
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("station/list");
        return mav;
    }

    // 查询所有的销售人员
    @ResponseBody
    @RequestMapping("/selectstaionUser")
    public List<StationPO> selectStationUser() {
        List<StationPO> list = service.getStationList();
        return list;
    }

    // 增加的按钮
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(StationPO station) {
        System.out.println(station);
        try {
            service.create(station);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
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
            return false;
        }
    };

    // 回显的方法
    @ResponseBody
    @RequestMapping("/update")
    public StationPO update(Integer stationId) {
        StationPO update = service.update(stationId);
        return update;
    };

    @ResponseBody
    @RequestMapping("/change")
    public void changeStation(StationPO station) {
        System.out.println(station);
    }

    @RequestMapping("/selectCity")
    @ResponseBody
    public List<RegionPO> selectByparentRegionId(Integer regionId) {
        List<RegionPO> list = service.selectByparentRegionId(regionId);
        System.out.println(list);
        return list;
    }

}
