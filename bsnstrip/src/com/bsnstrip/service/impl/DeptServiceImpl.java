package com.bsnstrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TDeptMapper;
import com.bsnstrip.pojo.TDept;
import com.bsnstrip.pojo.TDeptExample;
import com.bsnstrip.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private TDeptMapper deptMapper;

	public List<TDept> listDepts() {
		TDeptExample example = new TDeptExample();
		List<TDept> depts = deptMapper.selectByExample(example);
		return depts;
	}

	public int insertDept(TDept dept) {
		return deptMapper.insertSelective(dept);
	}
	
	public int deleteDept(Integer deptId) {
		return deptMapper.deleteByPrimaryKey(deptId);
	}

	public TDept selectDeptByDeptId(Integer deptId) {
		return deptMapper.selectByPrimaryKey(deptId);
	}

	public List<TDept> selectDeptByDeptname(String deptName) {
		TDeptExample example = new TDeptExample();
		TDeptExample.Criteria criteria = example.createCriteria();
		criteria.andDeptnameEqualTo(deptName);
		List<TDept> depts = deptMapper.selectByExample(example);
		return depts;
	}

	public int updateDept(TDept dept) {
		return deptMapper.updateByPrimaryKey(dept);
	}
}
