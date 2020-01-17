package com.baidu.mapper;

import com.baidu.po.StationPO;

public interface StationPOMapper {
    int deleteByPrimaryKey(Integer stationId);

    int insert(StationPO record);

    int insertSelective(StationPO record);

    StationPO selectByPrimaryKey(Integer stationId);

    int updateByPrimaryKeySelective(StationPO record);

    int updateByPrimaryKey(StationPO record);
}