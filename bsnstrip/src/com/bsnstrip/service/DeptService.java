package com.bsnstrip.service;

import java.util.List;

import com.bsnstrip.pojo.TDept;

public interface DeptService {
	List<TDept> listDepts();
	
	int deleteDept(Integer deptId);
	
	TDept selectDeptByDeptId(Integer deptId);
	
	List<TDept> selectDeptByDeptname(String deptName);
	
	int insertDept(TDept dept);
	
	int updateDept(TDept dept);
}
