package com.baidu.mapper;

import java.util.List;

import com.baidu.po.RegionPO;
import com.baidu.po.StationPO;

public interface StationPOMapper {
    int deleteByPrimaryKey(Integer stationId);

    int insert(StationPO record);

    int insertSelective(StationPO record);

    StationPO selectByPrimaryKey(Integer stationId);

    int updateByPrimaryKeySelective(StationPO record);

    int updateByPrimaryKey(StationPO record);
    
    List<StationPO> selectAll();
    
  //  /DeviceSellSystem/src/main/resources/xml/RegionPOMapper.xml
    List<RegionPO> selectByparentStationId(Integer regionId);
}