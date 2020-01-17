package com.baidu.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.form.UserParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.UserMapper;
import com.baidu.po.UserPO;
import com.baidu.util.BaiduUtil;
import com.baidu.util.BaiduUtil.IdCardFront;
import com.baidu.util.CommonUtil;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserPO> showUser() {
        return userMapper.showUser();
    }

    @Override
    public UserPO queryDetailByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    // 人员的增加信息
    @Override
    public void create(UserParam userParam) throws IllegalStateException, IOException {

        // 存放位置
        String rootPath = this.getClass().getResource("/").getPath().split("/WEB-INF")[0];
        String subPath = "/image/" + UUID.randomUUID().toString() + ".png";

        new File(rootPath + "/image/").mkdirs();

        userParam.transferIdCardFile(new File(rootPath + subPath));

        // 调用百度接口
        IdCardFront idCardFrontInfo = BaiduUtil.getIdCardFrontInfo(rootPath + subPath);

        UserPO userPO = new UserPO();

        BeanUtils.copyProperties(userParam, userPO);

        userPO.setPassword(CommonUtil.md5(userParam.getPassword()));
        userPO.setRealName(idCardFrontInfo.getName());
        userPO.setNation(idCardFrontInfo.getNation());
        userPO.setAddress(idCardFrontInfo.getAddress());
        userPO.setIdCard(idCardFrontInfo.getIdCard());
        userPO.setSex(idCardFrontInfo.getSex() == "男");
        userPO.setIdCardFront(subPath);
        userPO.setBirthday(new Date());

        userPO.setCreateUser(CurrentContext.getUser().getUserId());
        userPO.setUpdateUser(CurrentContext.getUser().getUserId());
        userPO.setCreateTime(new Date());
        userPO.setUpdateTime(new Date());
        userPO.setIsDelete(false);
        @SuppressWarnings("unused")
        int insert = userMapper.insert(userPO);
    }

    // 查看详细的方法
    @Override
    public UserPO showDetailed(String userId) {
        return userMapper.showshowDetailed(userId);
    }

    // 删除用户
    @Override
    public void delete(Integer userId) {
        @SuppressWarnings("unused")
        int deleteByPrimaryKey = userMapper.deleteByPrimaryKey(userId);
    }

}
