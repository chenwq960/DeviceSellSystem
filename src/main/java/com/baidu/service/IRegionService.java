package com.baidu.service;

import java.util.List;

import com.baidu.po.RegionPO;

public interface IRegionService {

    List<RegionPO> selectByparentRegionId(Integer userId);
    
}
