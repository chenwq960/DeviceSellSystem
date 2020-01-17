package com.baidu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.DeviceMapper;
import com.baidu.po.DevicePO;
import com.baidu.po.UserPO;

@Service
public class DeviceServiceImp implements IDeviceService {
    private static int count = 000000;
    @Autowired
    private DeviceMapper mapper;

    public List<DevicePO> seachDevice(String seachKey, String startTime, String endTime) {
        return mapper.seachDevice(seachKey, startTime, endTime);
    }

    @Override
    public void create(DevicePO DevicePO, HttpSession session) {
        DevicePO.setCreateTime(new Date());
        UserPO attribute = (UserPO) session.getAttribute("currentUser");
        DevicePO.setCreateUser(attribute.getUserId());
        DevicePO.setUpdateTime(new Date());
        DevicePO.setUpdateUser(attribute.getUserId());
        SimpleDateFormat datefm = new SimpleDateFormat("yyyy-mm");
        String date = datefm.format(new Date());
        date += "-" + (count++);
        System.out.println("时间为" + date);
        DevicePO.setDeviceCode(date);
        DevicePO.setIsDelete(false);
        System.out.println(count++ + "count的数量为");
        mapper.insert(DevicePO);
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
