package com.baidu.service;

import java.text.ParseException;
import java.util.List;

import com.baidu.form.SaleDeviceParam;
import com.baidu.form.SearchParam;
import com.baidu.po.SaleDevicePO;

public interface ISaleDeviceService {

    List<SaleDevicePO> list(SearchParam searchParam);

    SaleDevicePO getSaleDeviceById(Integer recordId);

    void create(SaleDeviceParam saleDeviceParam) throws ParseException;

    void update(SaleDeviceParam saleDeviceParam) throws ParseException;

    void delete(Integer stationId);

}
