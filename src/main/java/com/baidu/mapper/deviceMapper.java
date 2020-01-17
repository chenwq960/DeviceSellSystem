package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.po.DevicePO;

public interface deviceMapper {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(DevicePO record);

    int insertSelective(DevicePO record);

    DevicePO selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DevicePO record);

    int updateByPrimaryKey(DevicePO record);
    
    List<DevicePO> seachDevice(@Param("seachKey")String seachKey,@Param("startTime")String startTime,@Param("endTime")String endTime);

}