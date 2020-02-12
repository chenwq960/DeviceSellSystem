package com.baidu.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baidu.dto.FileDTO;
import com.baidu.form.SearchParam;
import com.baidu.form.UserParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.AuthInfoPOMapper;
import com.baidu.mapper.UserMapper;
import com.baidu.po.AuthInfoPO;
import com.baidu.po.UserPO;
import com.baidu.util.BaiduUtil;
import com.baidu.util.BaiduUtil.IdCardFront;
import com.baidu.util.CommonUtil;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthInfoPOMapper authInfoMapper;
    @Autowired
    @Qualifier("localFileService")
    private IFileService fileService;

    @Override
    public List<UserPO> showUser(SearchParam searchParam) {
        return userMapper.showUser(searchParam);
    }

    @Override
    public UserPO queryDetailByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    // 人员的增加信息
    @Override
    public void create(UserParam userParam) throws IllegalStateException, IOException {
        FileDTO fileDTO = fileService.saveFile(userParam.getIdCardFile().getInputStream(), ".png");
        // 调用百度接口
        IdCardFront idCardFrontInfo = BaiduUtil.getIdCardFrontInfo(fileDTO.getAbsolutePath());
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(userParam, userPO);
        userPO.setPassword(CommonUtil.md5(userParam.getPassword()));
        userPO.setRealName(idCardFrontInfo.getName());
        userPO.setNation(idCardFrontInfo.getNation());
        userPO.setAddress(idCardFrontInfo.getAddress());
        userPO.setIdCard(idCardFrontInfo.getIdCard());
        userPO.setSex((byte) (idCardFrontInfo.getSex() == "男" ? 1 : 2));
        userPO.setIdCardFront(fileDTO.getSubPath());
        userPO.setBirthday(new Date());
        userPO.setCreateUser(CurrentContext.getUser().getUserId());
        userPO.setUpdateUser(CurrentContext.getUser().getUserId());
        userPO.setCreateTime(new Date());
        userPO.setUpdateTime(new Date());
        userPO.setIsDelete(false);

        userMapper.insert(userPO);
    }

    // 查看详细的方法
    @Override
    public UserPO showDetailed(Integer userId) {
        return userMapper.showshowDetailed(userId);
    }

    // 删除用户
    @Override
    public void delete(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    // 修改的方法
    @Override
    public void update(UserParam userParam) {
        FileDTO fileDTO = null;
        try {
            fileDTO = fileService.saveFile(userParam.getIdCardFile().getInputStream(), ".png");
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        // 调用百度接口
        IdCardFront idCardFrontInfo = BaiduUtil.getIdCardFrontInfo(fileDTO.getAbsolutePath());

        UserPO userPO = userMapper.selectByPrimaryKey(userParam.getUserId());

        BeanUtils.copyProperties(userParam, userPO);
        try {
            userPO.setPassword(CommonUtil.md5(userParam.getPassword()));
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userPO.setRealName(idCardFrontInfo.getName());
        userPO.setNation(idCardFrontInfo.getNation());
        userPO.setAddress(idCardFrontInfo.getAddress());
        userPO.setIdCard(idCardFrontInfo.getIdCard());
        userPO.setSex((byte) (idCardFrontInfo.getSex() == "男" ? 1 : 2));
        userPO.setIdCardFront(fileDTO.getSubPath());
        userPO.setBirthday(new Date());
        userPO.setUpdateUser(CurrentContext.getUser().getUserId());
        userPO.setUpdateTime(new Date());
        userPO.setIsDelete(false);
        userMapper.updateByPrimaryKeySelective(userPO);
    }

    @Override
    public Set<AuthInfoPO> queryUserAuth(Integer userId) {
        return authInfoMapper.selectUserAuth(userId);
    }

}
