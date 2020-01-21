package com.baidu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.form.SaleDeviceParam;
import com.baidu.form.SearchParam;
import com.baidu.po.SaleDevicePO;
import com.baidu.service.IDeviceService;
import com.baidu.service.ISaleDeviceService;
import com.baidu.service.IStationService;
import com.baidu.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

    @RequestMapping("/list/page")
    public String list(ModelMap modelMap,SearchParam searchParam) {
        PageHelper.startPage(searchParam.getPageNum(),4);
        List<SaleDevicePO> list = saleDeviceService.list(searchParam);
        PageInfo<SaleDevicePO> pageInfo = new PageInfo<>(list);
        modelMap.put("list", list);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("searchParcm", searchParam);
        return "saleDevice/list";
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
            logger.error("销售表创建发生异常，param{},exc:{}",saleDeviceParam,e);
            return false;
        }
    }
    // 修改的方法
    @ResponseBody
    @RequestMapping("/update")
    public boolean update(SaleDeviceParam saleDeviceParam) {
        try {
            saleDeviceService.update(saleDeviceParam);
            return true;
        }
        catch (Exception ext) {
            logger.error("销售表修改发生异常，param:{},exc:{}", saleDeviceParam, ext);
            return false;
        }
    }

    // 删除的方法
    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer stationId) {
        try {
            saleDeviceService.delete(stationId);
            return true;
        }
        catch (Exception e) {
            logger.error("销售表删除发生异常,param:{},exc:{}",stationId,e);
            return false;
        }
    }
    @RequestMapping("/updateDevice")
    public String toUpdatePage(Integer saleDeviceId, ModelMap modelMap) {
        modelMap.put("stationList", stationService.getStationList());
        modelMap.put("deviceList", deviceService.searchDeviceList(null));
        modelMap.put("userList", userService.showUser(null));
        modelMap.put("saleDevice", saleDeviceService.getSaleDeviceById(saleDeviceId));
        return "saleDevice/update";
    }
    
  /*  // 查询所有销售时间
  @ResponseBody
  @RequestMapping("/saleTime")
  public List<SaleDevicePO> saleTime() {
      List<SaleDevicePO> list = saleDeviceService.list(null);
      return list;
  }
     //回显的方法
    @ResponseBody
    @RequestMapping("/returnMessage")
    public SaleDevicePO returnMessage(Integer userId) {
        SaleDevicePO returnMessage = saleDeviceService.getSaleDeviceById(userId);
        return returnMessage;
    }
    */
};
