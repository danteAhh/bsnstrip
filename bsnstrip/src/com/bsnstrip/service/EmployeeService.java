package com.bsnstrip.service;

import com.bsnstrip.pojo.TEmployee;

public interface EmployeeService {
	
	TEmployee findEmployeeByEmployeeId(Integer employeeId);
	
	Integer saveEmployee(TEmployee employee);
}
