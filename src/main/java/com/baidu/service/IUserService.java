package com.baidu.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.baidu.form.UserParam;
import com.baidu.po.UserPO;

public interface IUserService {

    List<UserPO> showUser();

    UserPO queryDetailByAccount(String account);

    // 人员的增加信息
    void create(UserParam userParam) throws UnsupportedEncodingException, IllegalStateException, IOException;

    // 查看详细的方法
    UserPO showDetailed(String userId);

    // 删除用户
    void delete(Integer userId);
}
