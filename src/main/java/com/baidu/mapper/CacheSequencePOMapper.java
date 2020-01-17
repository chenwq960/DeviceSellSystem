package com.baidu.mapper;

import com.baidu.po.CacheSequencePO;

public interface CacheSequencePOMapper {
    int deleteByPrimaryKey(String sequenceEntity);

    int insert(CacheSequencePO record);

    int insertSelective(CacheSequencePO record);

    CacheSequencePO selectByPrimaryKey(String sequenceEntity);

    int updateByPrimaryKeySelective(CacheSequencePO record);

    int updateByPrimaryKey(CacheSequencePO record);
}