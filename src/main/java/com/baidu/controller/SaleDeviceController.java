package com.baidu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.form.SaleDeviceParam;
import com.baidu.po.SaleDevicePO;
import com.baidu.service.IDeviceService;
import com.baidu.service.ISaleDeviceService;
import com.baidu.service.IStationService;
import com.baidu.service.IUserService;

@Controller
@RequestMapping("/saleDevice")
public class SaleDeviceController {

    private static Logger logger = LoggerFactory.getLogger(SaleDeviceController.class);

    @Autowired
    private ISaleDeviceService saleDeviceService;
    @Autowired
    private IStationService stationService;
    @Autowired
    private IDeviceService deviceService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<SaleDevicePO> list = saleDeviceService.list();
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", list);
        mav.setViewName("saleDevice/list");
        return mav;
    }

    // 查询所有销售时间
    @ResponseBody
    @RequestMapping("/saleTime")
    public List<SaleDevicePO> saleTime() {
        List<SaleDevicePO> list = saleDeviceService.list();
        return list;
    }

    // 增加的方法
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(SaleDeviceParam saleDeviceParam) {
        try {
            saleDeviceService.create(saleDeviceParam);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 回显的方法
    @ResponseBody
    @RequestMapping("/returnMessage")
    public SaleDevicePO returnMessage(Integer userId) {
        SaleDevicePO returnMessage = saleDeviceService.getSaleDeviceById(userId);
        return returnMessage;
    }

    // 修改的方法
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(SaleDeviceParam saleDeviceParam) {
        try {
            saleDeviceService.update(saleDeviceParam);
            return true;
        }
        catch (Exception ext) {
            logger.error("修改设备发生异常，param:{},exc:{}", saleDeviceParam, ext);
            return false;
        }
    }

    // 删除的方法
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(Integer stationId) {
        try {
            saleDeviceService.delete(stationId);
            return true;
        }
        catch (Exception e) {
            logger.error("删除发生异常,param:{},exc:{}",stationId,e);
            return false;
        }
    }

    @RequestMapping("/toUpdate")
    public String toUpdatePage(Integer recordId, ModelMap modelMap) {

        modelMap.put("stationList", stationService.getStationList());
        modelMap.put("deviceList", deviceService.searchDeviceList(null));
        modelMap.put("userList", userService.showUser());
        modelMap.put("saleDevice", saleDeviceService.getSaleDeviceById(recordId));

        return "saleDevice/update";
    }

};
