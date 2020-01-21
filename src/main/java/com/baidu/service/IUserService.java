package com.baidu.service;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.form.UserParam;
import com.baidu.po.UserPO;

public interface IUserService {

    List<UserPO> showUser(SearchParam searchParam);

    UserPO queryDetailByAccount(String account);

    // 人员的增加信息
    void create(UserParam userParam) throws Exception;

    // 查看详细的方法
    UserPO showDetailed(Integer userId);

    // 删除用户
    void delete(Integer userId);

    void update(UserParam userParam);
}
