package com.bug.module.hcm.service;

import com.bug.shared.hcm.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);

	Employee getEmployee(String id);

}
