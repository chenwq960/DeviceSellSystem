package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.StationPOMapper;
import com.baidu.po.StationPO;

@Service
public class StationServiceImp implements IStationService{
    @Autowired
    private StationPOMapper mapper;

    @Override
    public List<StationPO> list() {
        return mapper.selectAll();
    }

//增加地区的
    @Override
    public void create(StationPO station) {
        station.setCreateTime(new Date());
        station.setUpdateTime(new Date());
        station.setCreateUser(CurrentContext.getUser().getUserId());
        station.setUpdateUser(CurrentContext.getUser().getUserId());
        station.setLongitude((long)45545546);
        station.setLatitude((long)785415515);
        @SuppressWarnings("unused")
        int insertSelective = mapper.insertSelective(station);
    }

    @Override
    public void delete(Integer stationId) {
        @SuppressWarnings("unused")
        int deleteByPrimaryKey = mapper.deleteByPrimaryKey(stationId);
        
    }
//修改的方法
    @Override
    public StationPO update(Integer stationId) {
        StationPO selectByPrimaryKey = mapper.selectByPrimaryKey(stationId);
        return selectByPrimaryKey;
    }
    

}
