package com.baidu.mapper;

import org.apache.ibatis.annotations.Param;

import com.baidu.po.CacheSequencePO;

public interface CacheSequencePOMapper {
    int deleteByPrimaryKey(Integer sequenceId);

    int insert(CacheSequencePO record);

    int insertSelective(CacheSequencePO record);

    CacheSequencePO selectByPrimaryKey(Integer sequenceId);

    CacheSequencePO selectByEntityAndKey(@Param("entity") String entity, @Param("key") String key);

    int updateByPrimaryKeySelective(CacheSequencePO record);

    int updateByPrimaryKey(CacheSequencePO record);
}