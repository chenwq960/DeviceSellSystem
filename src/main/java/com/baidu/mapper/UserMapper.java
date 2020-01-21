package com.baidu.mapper;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.po.UserPO;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    // 通过账号查询用户
    UserPO selectByAccount(String account);

    UserPO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

    List<UserPO> showUser(SearchParam searchParam);

    // 根据部门名称查询部门ID
    int selectUserDepartment(String departmentName);

    // 查看详细的方式
    UserPO showshowDetailed(Integer userId);

}