package com.bug.module.hcm.dao.impl;

import org.springframework.stereotype.Repository;

import com.bug.commons.dao.BaseDao;
import com.bug.module.hcm.dao.EmployeeDao;
import com.bug.shared.hcm.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends BaseDao<Employee>implements EmployeeDao {

	@Override
	public void save(Employee employee) throws Exception {
		super.save(employee);

	}

}
