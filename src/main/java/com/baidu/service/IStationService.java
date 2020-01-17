package com.baidu.service;

import java.util.List;

import com.baidu.po.RegionPO;
import com.baidu.po.StationPO;

public interface IStationService {

    List<StationPO> list();

    void create(StationPO station);

    void delete(Integer stationId);

    StationPO update(Integer stationId);

    List<RegionPO> selectByparentRegionId(Integer regionId);

}
