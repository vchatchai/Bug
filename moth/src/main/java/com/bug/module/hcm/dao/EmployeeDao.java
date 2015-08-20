package com.bug.module.hcm.dao;

import com.bug.shared.hcm.Employee;
import com.thinkaurelius.titan.core.TitanGraph;

public interface EmployeeDao  {

	Employee createVertex(TitanGraph titanGraph, Employee object) throws Exception;

	void deleteVertexById(TitanGraph titanGraph, Employee vertex) throws Exception;

	Employee getVertexById(TitanGraph titanGraph, Employee t) throws Exception;

	Employee getEmployee(String id);

}
