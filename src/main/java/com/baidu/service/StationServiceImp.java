package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.StationPOMapper;
import com.baidu.po.RegionPO;
import com.baidu.po.StationPO;

@Service
public class StationServiceImp implements IStationService {
    @Autowired
    private StationPOMapper mapper;

    @Override
    public List<StationPO> getStationList() {
        return mapper.selectAll();
    }

    // 增加销售网点的
    @Override
    public void create(StationPO station) {
        station.setCreateTime(new Date());
        station.setUpdateTime(new Date());
        station.setCreateUser(CurrentContext.getUser().getUserId());
        station.setUpdateUser(CurrentContext.getUser().getUserId());
        station.setLongitude((double) 1);
        station.setLatitude((double) 1);
        @SuppressWarnings("unused")
        int insertSelective = mapper.insertSelective(station);
    }

    @Override
    public void delete(Integer stationId) {
        @SuppressWarnings("unused")
        int deleteByPrimaryKey = mapper.deleteByPrimaryKey(stationId);

    }

    // 修改的方法
    @Override
    public StationPO update(Integer stationId) {
        StationPO selectByPrimaryKey = mapper.selectByPrimaryKey(stationId);
        return selectByPrimaryKey;
    }

    @Override
    public List<RegionPO> selectByparentRegionId(Integer regionId) {
        return mapper.selectByparentStationId(regionId);
    }

}
