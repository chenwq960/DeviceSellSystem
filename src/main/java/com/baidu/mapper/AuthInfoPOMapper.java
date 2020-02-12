package com.baidu.mapper;

import java.util.Set;

import com.baidu.po.AuthInfoPO;

public interface AuthInfoPOMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(AuthInfoPO record);

    int insertSelective(AuthInfoPO record);

    AuthInfoPO selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(AuthInfoPO record);

    int updateByPrimaryKey(AuthInfoPO record);

    Set<AuthInfoPO> selectUserAuth(Integer userId);
}