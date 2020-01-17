package com.baidu.service;

import java.util.List;

import com.baidu.form.DeviceParam;
import com.baidu.form.SearchParam;
import com.baidu.po.DevicePO;

public interface IDeviceService {

    List<DevicePO> searchDeviceList(SearchParam searchParam);

    void create(DeviceParam deviceParam);

    void delete(Integer deviceId);

    void update(DeviceParam deviceParam);
}
