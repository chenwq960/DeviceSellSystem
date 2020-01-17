package com.baidu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.po.DevicePO;
import com.baidu.service.IDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private IDeviceService service;

    @ResponseBody
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
            @RequestParam(value = "seachKey",required = false)String seachKey,
            @RequestParam(value = "startTime",required = false)String startTime,
            @RequestParam(value = "endTime",required = false)String endTime) {
        PageHelper.startPage(pageNum, 5);
        List<DevicePO> seachDevice = service.seachDevice(seachKey,startTime,endTime);
        PageInfo<DevicePO> pi = new PageInfo<DevicePO>(seachDevice);
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", seachDevice);
        mav.addObject("limitmodel", pi);
        mav.addObject("seachKey", seachKey);
        mav.addObject("endTime", endTime);
        mav.addObject("startTime", startTime);
        mav.setViewName("device/list");
        return mav;
    };

    // 增加设备
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(DevicePO devicePO, HttpSession session) {
        try {
            service.create(devicePO, session);
        }
        catch (Exception e) {
            return false;
        }
        return true;

    }

    // 删除设备的
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer deviceId) {
        try {
            service.delete(deviceId);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    // 修改数据
    @ResponseBody
    @RequestMapping("/update")
    public boolean update(DevicePO devicePO, HttpSession session) {
        try {

            service.update(devicePO, session);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
