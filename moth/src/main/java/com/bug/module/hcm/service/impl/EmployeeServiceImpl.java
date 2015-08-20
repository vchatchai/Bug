package com.bug.module.hcm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.module.hcm.dao.EmployeeDao;
import com.bug.module.hcm.service.EmployeeService;
import com.bug.shared.hcm.Employee;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void createEmployee(Employee employee){
		
	}

	@Override
	public Employee getEmployee(String id) {

		
		Employee employee = employeeDao.getEmployee(id);
		
		return  employee;
	}
	

}
