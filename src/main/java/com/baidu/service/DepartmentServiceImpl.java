package com.baidu.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.mapper.DepartmentMapper;
import com.baidu.po.DepartmentPO;
import com.baidu.po.UserPO;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    // 部门表的查询方式
    @Override
    public List<DepartmentPO> departmentFind(String searchKey, Date startTime, Date endTime) {
        // TODO 尚未实现模糊查询
        return departmentMapper.selectList(searchKey, startTime, endTime);
    }

    // 部门表的增加方法
    @Override
    public int createdepartment(DepartmentPO departmentPO, HttpSession session) {
        // 当前用户
        int userId = UserPO.class.cast(session.getAttribute("currentUser")).getUserId();
        departmentPO.setUpdateUser(userId);
        departmentPO.setCreateUser(userId);
        departmentPO.setCreateTime(new Date());
        departmentPO.setUpdateTime(new Date());
        departmentPO.setIsDelete(false);
        return departmentMapper.insert(departmentPO);
    }

    // 部门表格删除的方法
    @Override
    public void departmentdel(Integer departmentId) {
        // TODO 进行逻辑删除
        @SuppressWarnings("unused")
        int i = departmentMapper.deleteByPrimaryKey(departmentId);
    }

    // 部门表格回显的方法
    @Override
    public DepartmentPO departmenthx(Integer departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    // 部门表修改的方法
    @Override
    public int updatedepartment(DepartmentPO departmentPO) {
        return departmentMapper.updateByPrimaryKeySelective(departmentPO);
    }

}
