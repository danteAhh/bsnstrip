package com.bsnstrip.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsnstrip.mapper.TEmployeeMapper;
import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TEmployeeExample;
import com.bsnstrip.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private TEmployeeMapper employeeMapper;

	// 通过主键查找员工
	public TEmployee findEmployeeByEmployeeId(Integer employeeId) {

		TEmployeeExample example = new TEmployeeExample();
		TEmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpidEqualTo(employeeId);
		List<TEmployee> employees = employeeMapper.selectByExample(example);

		TEmployee employee = null;
		if (employees != null && employees.size() > 0) {
			employee = employees.get(0);
		}
		return employee;
	}

	public Integer saveEmployee(TEmployee employee) {
		Integer empid = employee.getEmpid();
		if(empid==null) {
			employeeMapper.insertSelective(employee);
		}else {
			employeeMapper.updateByPrimaryKeySelective(employee);
		}
		return employee.getEmpid();
	}

}
