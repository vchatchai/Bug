package com.bug.module.hcm.dao.impl;

import org.springframework.stereotype.Repository;

import com.bug.commons.dao.impl.GraphDaoAbstract;
import com.bug.module.hcm.dao.EmployeeDao;
import com.bug.shared.hcm.Employee;
import com.thinkaurelius.titan.core.TitanGraph;

@Repository
public class EmployeeDaoImpl extends GraphDaoAbstract<Employee> implements EmployeeDao {

	@Override
	public Employee createVertex(TitanGraph titanGraph, Employee object)
			throws Exception {
		return super.createVertex(titanGraph, object);
	}

	@Override
	public void deleteVertexById(TitanGraph titanGraph, Employee vertex)
			throws Exception {
		super.deleteVertexById(titanGraph, vertex);
	}

	@Override
	public Employee getVertexById(TitanGraph titanGraph, Employee vertex)
			throws Exception {
		return super.getVertexById(titanGraph, vertex);
	}

	@Override
	public Employee getEmployee(String id) {
		Employee employee = new Employee();
		employee.setId("35");
		employee.setName("Chatchai");
		employee.setSurname("Vichai");
		return employee;
	}
	
	

}
