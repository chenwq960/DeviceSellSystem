package com.baidu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.form.DeviceParam;
import com.baidu.form.SearchParam;
import com.baidu.po.DevicePO;
import com.baidu.service.IDeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 设备相关接口
 * 
 * @author songyz
 * @createTime 2020-01-17 17:52:49
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    private static Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @Autowired
    private IDeviceService deviceService;

    /**
     * 查询社保列表
     * 
     * @param searchParam
     * @param modelAndView
     * @return
     */
    @RequestMapping("/list")
    public String list(SearchParam searchParam, ModelMap modelMap) {
        PageHelper.startPage(searchParam.getPageNum(), searchParam.getPageSize());
        List<DevicePO> deviceList = deviceService.searchDeviceList(searchParam);
        PageInfo<DevicePO> pageInfo = new PageInfo<>(deviceList);
        modelMap.put("list", deviceList);
        modelMap.put("pageInfo", pageInfo);
        modelMap.put("searchParam", searchParam);
        return "device/list";
    };

    // 查询所有的设备转发到设备销售中
    @ResponseBody
    @RequestMapping("/selectDevice")
    public List<DevicePO> selectDevice() {
        List<DevicePO> deviceList = deviceService.searchDeviceList(null);
        return deviceList;
    }

    /**
     * 增加设备
     * 
     * @param deviceParam
     * @return
     */
    @ResponseBody
    @RequestMapping("/create")
    public boolean create(DeviceParam deviceParam) {
        try {
            deviceService.create(deviceParam);
            return true;
        }
        catch (Exception ext) {
            logger.error("添加设备发生异常，param:{},exc:{}", deviceParam, ext);
            return false;
        }
    }

    /**
     * 逻辑删除设备
     * 
     * @param deviceId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer deviceId) {
        try {
            deviceService.delete(deviceId);
            return true;
        }
        catch (Exception ext) {
            logger.error("修改设备发生异常，param:{},exc:{}", deviceId, ext);
            return false;
        }
    }

    /**
     * 修改设备数据
     * 
     * @param deviceParam
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public boolean update(DeviceParam deviceParam) {
        try {
            deviceService.update(deviceParam);
            return true;
        }
        catch (Exception ext) {
            logger.error("修改设备发生异常，param:{},exc:{}", deviceParam, ext);
            return false;
        }
    }
}
