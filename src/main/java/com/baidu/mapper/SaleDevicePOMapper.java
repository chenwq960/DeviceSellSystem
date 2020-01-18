package com.baidu.mapper;

import java.util.List;

import com.baidu.po.SaleDevicePO;

public interface SaleDevicePOMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(SaleDevicePO record);

    int insertSelective(SaleDevicePO record);

    SaleDevicePO selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(SaleDevicePO record);

    int updateByPrimaryKey(SaleDevicePO record);

    List<SaleDevicePO> selectList();
}