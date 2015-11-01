package com.bug.module.hcm.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bug.AppMain;
import com.bug.shared.hcm.Employee;

public class EmployeeDaoTest {

	EmployeeDao employeeDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employeeDao = (EmployeeDao) AppMain.getApplicationContext().getBean("employeeDao");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() throws Exception {
		Employee employee = new Employee();
		employee.setId("1");
		employee.setName("Chatchai");
		employee.setSurname("Vichai");
		employeeDao.save(employee);;
	}

}
