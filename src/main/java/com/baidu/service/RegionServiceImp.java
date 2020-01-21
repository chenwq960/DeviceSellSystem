package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.RegionPOMapper;
import com.baidu.po.RegionPO;

@Service
public class RegionServiceImp implements IRegionService{
    @Autowired 
    private RegionPOMapper mapper;
    @Override
    public List<RegionPO> selectByparentRegionId(Integer userId) {
        return mapper.selectByparentRegionId(userId);
    }
}
