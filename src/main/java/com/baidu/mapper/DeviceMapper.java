package com.baidu.mapper;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.po.DevicePO;

public interface DeviceMapper {

    int insert(DevicePO record);

    int insertSelective(DevicePO record);

    DevicePO selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DevicePO record);

    int updateByPrimaryKey(DevicePO record);

    List<DevicePO> selectDeviceList(SearchParam searchParam);

    int updateByIsDelete(Integer deviceId);

}