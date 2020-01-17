package com.baidu.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.DeviceMapper;
import com.baidu.po.DevicePO;
import com.baidu.po.UserPO;
import com.baidu.service.CacheSequenceService.Entity;

@Service
public class DeviceServiceImp implements IDeviceService {

    @Autowired
    private DeviceMapper mapper;

    @Autowired
    private CacheSequenceService sequenceService;

    public List<DevicePO> seachDevice() {
        return mapper.seachDevice();
    }

    @Override
    public void create(DevicePO devicePO, HttpSession session) {
        devicePO.setCreateTime(new Date());
        UserPO attribute = (UserPO) session.getAttribute("currentUser");
        devicePO.setCreateUser(attribute.getUserId());
        devicePO.setUpdateTime(new Date());
        devicePO.setUpdateUser(attribute.getUserId());

        String sequenceKey = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        devicePO.setDeviceCode("DO-" + sequenceKey + "-" + sequenceService.getSequenceCode(Entity.DEVICE, sequenceKey));
        devicePO.setIsDelete(false);
        mapper.insert(devicePO);
    }

    @Override
    public void delete(Integer deviceId) {
        mapper.deleteByPrimaryKey(deviceId);

    }

    @SuppressWarnings("unused")
    @Override
    public void update(DevicePO DevicePO, HttpSession session) {
        DevicePO.setUpdateTime(new Date());
        UserPO attribute = (UserPO) session.getAttribute("currentUser");
        DevicePO.setUpdateUser(attribute.getUserId());
        int updateByPrimaryKey = mapper.updateByPrimaryKey(DevicePO);
    }

}
