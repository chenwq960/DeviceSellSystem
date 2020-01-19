package com.baidu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.po.DepartmentPO;

public interface DepartmentMapper {
	int deleteByPrimaryKey(Integer departmentId);

	int insert(DepartmentPO record);

	int insertSelective(DepartmentPO record);

	DepartmentPO selectByPrimaryKey(Integer departmentId);

	List<DepartmentPO> selectList(@Param("seachKey")String seachKey,@Param("startTime")String startTime,@Param("endTime")String endTime);

	int updateByPrimaryKeySelective(DepartmentPO record);

	int updateByPrimaryKey(DepartmentPO record);

}