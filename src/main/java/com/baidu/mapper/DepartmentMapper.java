package com.baidu.mapper;

import java.util.List;

import com.baidu.form.SearchParam;
import com.baidu.po.DepartmentPO;

public interface DepartmentMapper {
	int updateSetIdDelete(Integer departmentId);

	int insert(DepartmentPO record);

	int insertSelective(DepartmentPO record);

	DepartmentPO selectByPrimaryKey(Integer departmentId);

	List<DepartmentPO> selectList(SearchParam searchParam);

	int updateByPrimaryKeySelective(DepartmentPO record);

	int updateByPrimaryKey(DepartmentPO record);

}