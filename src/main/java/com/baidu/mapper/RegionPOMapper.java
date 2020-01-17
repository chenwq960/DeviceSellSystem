package com.baidu.mapper;


import java.util.List;

import com.baidu.po.RegionPO;

public interface RegionPOMapper {
    int deleteByPrimaryKey(Integer regionId);

    int insert(RegionPO record);

    int insertSelective(RegionPO record);

    RegionPO selectByPrimaryKey(Integer regionId);

    int updateByPrimaryKeySelective(RegionPO record);

    int updateByPrimaryKey(RegionPO record);
    
    List<RegionPO> selectByparentRegionId(Integer userId);
}