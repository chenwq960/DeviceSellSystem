package com.baidu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.form.SearchParam;
import com.baidu.interceptor.CurrentContext;
import com.baidu.mapper.RoleMapper;
import com.baidu.po.RolePO;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    // 角色的增加方法
    @Override
    public void createRole(String roleName, int createUser) {
        RolePO rolePO = new RolePO();
        rolePO.setRoleName(roleName);
        rolePO.setCreateTime(new Date());
        rolePO.setCreateUser(createUser);
        rolePO.setUpdateTime(new Date());
        rolePO.setUpdateUser(createUser);
        rolePO.setIsDelete(false);
        roleMapper.insert(rolePO);
    }

    @Override
    public void updateRole(RolePO rolePO) {
        rolePO.setUpdateTime(new Date());
        rolePO.setUpdateUser(CurrentContext.getUser().getUserId());
        roleMapper.updateByPrimaryKeySelective(rolePO);
    }

    @Override
    public List<RolePO> queryList(SearchParam searchParam) {
        return roleMapper.selectList(searchParam);
    }

    @Override
    public void deleteRole(int roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }
    @Override
    public RolePO roleDetail(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
}
