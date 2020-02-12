package com.baidu.mapper;

import com.baidu.po.RoleAuthPO;

public interface RoleAuthPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleAuthPO record);

    int insertSelective(RoleAuthPO record);

    RoleAuthPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleAuthPO record);

    int updateByPrimaryKey(RoleAuthPO record);
}