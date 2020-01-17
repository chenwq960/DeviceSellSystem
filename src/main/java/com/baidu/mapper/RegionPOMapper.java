package com.baidu.mapper;

import com.baidu.po.RegionPO;

public interface RegionPOMapper {
    int deleteByPrimaryKey(Integer regionId);

    int insert(RegionPO record);

    int insertSelective(RegionPO record);

    RegionPO selectByPrimaryKey(Integer regionId);

    int updateByPrimaryKeySelective(RegionPO record);

    int updateByPrimaryKeyWithBLOBs(RegionPO record);

    int updateByPrimaryKey(RegionPO record);
}