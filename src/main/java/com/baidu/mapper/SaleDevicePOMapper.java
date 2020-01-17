package com.baidu.mapper;

import com.baidu.po.SaleDevicePO;

public interface SaleDevicePOMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SaleDevicePO record);

    int insertSelective(SaleDevicePO record);

    SaleDevicePO selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(SaleDevicePO record);

    int updateByPrimaryKey(SaleDevicePO record);
}