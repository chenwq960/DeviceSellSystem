package com.baidu.mapper;

import java.util.List;

import com.baidu.dto.device;

public interface deviceMapper {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(device record);

    int insertSelective(device record);

    device selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(device record);

    int updateByPrimaryKey(device record);
    
    List<device> seachDevice();

}