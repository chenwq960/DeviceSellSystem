package com.baidu.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baidu.dto.Department;

public interface DepartmentMapper {
	int deleteByPrimaryKey(Integer departmentId);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer departmentId);

	List<Department> selectList(@Param("searchKey")String searchKey,@Param("startTime")Date startTime,@Param("endTime")Date endTime);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

}