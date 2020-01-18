package com.baidu.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.form.DeviceParam;
import com.baidu.form.SearchParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.DeviceMapper;
import com.baidu.po.DevicePO;
import com.baidu.service.CacheSequenceService.Entity;

@Service
public class DeviceServiceImp implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private CacheSequenceService sequenceService;

    @Override
    public List<DevicePO> searchDeviceList(SearchParam searchParam) {
        return deviceMapper.selectDeviceList(searchParam);
    }

    @Override
    public void create(DeviceParam deviceParam) {
        DevicePO devicePO = new DevicePO();

        // 使用Spring工具类进行字段拷贝
        BeanUtils.copyProperties(deviceParam, devicePO);

        // 添加数据处理
        devicePO.setDeviceId(null);
        devicePO.setCreateTime(new Date());
        devicePO.setUpdateTime(new Date());
        devicePO.setCreateUser(CurrentContext.getUser().getUserId());
        devicePO.setUpdateUser(CurrentContext.getUser().getUserId());
        devicePO.setIsDelete(false);

        // 设备序列号生成
        String sequenceKey = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
        devicePO.setDeviceCode("DO-" + sequenceKey + "-" + sequenceService.getSequenceCode(Entity.DEVICE, sequenceKey));

        deviceMapper.insert(devicePO);
    }

    @Override
    public void delete(Integer deviceId) {
        DevicePO devicePO = deviceMapper.selectByPrimaryKey(deviceId);

        devicePO.setIsDelete(true);
        devicePO.setUpdateTime(new Date());
        devicePO.setUpdateUser(CurrentContext.getUser().getUserId());
        deviceMapper.updateByPrimaryKey(devicePO);
    }

    @Override
    public void update(DeviceParam deviceParam) {
        DevicePO devicePO = deviceMapper.selectByPrimaryKey(deviceParam.getDeviceId());

        devicePO.setDeviceName(deviceParam.getDeviceName());
        devicePO.setDeviceModel(deviceParam.getDeviceModel());

        devicePO.setUpdateTime(new Date());
        devicePO.setUpdateUser(CurrentContext.getUser().getUserId());
        deviceMapper.updateByPrimaryKey(devicePO);
    }

}
