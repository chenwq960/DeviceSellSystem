package com.baidu.mapper;

import java.util.List;

import com.baidu.po.DevicePO;

public interface DeviceMapper {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(DevicePO record);

    int insertSelective(DevicePO record);

    DevicePO selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DevicePO record);

    int updateByPrimaryKey(DevicePO record);
    
    List<DevicePO> seachDevice();

}