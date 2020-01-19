package com.baidu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.form.SaleDeviceParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.SaleDevicePOMapper;
import com.baidu.po.SaleDevicePO;

@Service
public class SaleDeviceServiceImp implements ISaleDeviceService {
    @Autowired
    private SaleDevicePOMapper saleDeviceMapper;

    @Override
    public List<SaleDevicePO> list() {
        return saleDeviceMapper.selectList();
    }

    @Override
    public SaleDevicePO getSaleDeviceById(Integer recordId) {
        SaleDevicePO selectByPrimaryKey = saleDeviceMapper.selectByPrimaryKey(recordId);
        return selectByPrimaryKey;

    }

    // 修改的方法
    @Override
    public void update(SaleDeviceParam saleDeviceParam) throws ParseException {
        SaleDevicePO saleDevice = new SaleDevicePO();

        BeanUtils.copyProperties(saleDeviceParam, saleDevice);

        // 设置创建参数
        saleDevice.setSaleTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(saleDeviceParam.getSaleTime()));

        saleDevice.setUpdateUser(CurrentContext.getUser().getUserId());
        saleDevice.setUpdateTime(new Date());
        saleDevice.setIsDelete(false);

        saleDeviceMapper.updateByPrimaryKeySelective(saleDevice);
    }

    // 删除
    @Override
    public void delete(Integer stationId) {
        saleDeviceMapper.deleteByPrimaryKey(stationId);

    }

    @Override
    public void create(SaleDeviceParam saleDeviceParam) throws ParseException {

        SaleDevicePO saleDevice = new SaleDevicePO();

        BeanUtils.copyProperties(saleDeviceParam, saleDevice);

        // 设置创建参数
        saleDevice.setRecordId(null);
        saleDevice.setSaleTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(saleDeviceParam.getSaleTime()));

        saleDevice.setCreateUser(CurrentContext.getUser().getUserId());
        saleDevice.setUpdateUser(CurrentContext.getUser().getUserId());
        saleDevice.setCreateTime(new Date());
        saleDevice.setUpdateTime(new Date());
        saleDevice.setIsDelete(false);

        saleDeviceMapper.insertSelective(saleDevice);
    }
}
