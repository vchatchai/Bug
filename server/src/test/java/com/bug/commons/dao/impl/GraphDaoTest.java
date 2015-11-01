//package com.bug.commons.dao.impl;
//
//import java.io.IOException;
//
//import org.apache.commons.configuration.ConfigurationException;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.bug.config.Configuration;
//import com.bug.module.hcm.dao.EmployeeDao;
//import com.bug.shared.hcm.Employee;
//import com.thinkaurelius.titan.core.TitanFactory;
//import com.thinkaurelius.titan.core.TitanGraph;
//
///**
// * @author chatchai
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:com/bug/config/applicationContext.xml" })
//public class GraphDaoTest {
//
//	TitanGraph titanGraph;
//
//	@Autowired
//	private EmployeeDao employeeDao;
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//
//	}
//
//	private static TitanGraph getConnection() throws IOException, ConfigurationException {
//		TitanGraph titanGraph = TitanFactory.open(Configuration.getTitanConfiguration());
//		return titanGraph;
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//		
//		titanGraph = getConnection();
//
//
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@After
//	public void tearDown() throws Exception {
//		titanGraph.tx().commit();
//		titanGraph.close();
//	}
//
//	/**
//	 * Test method for
//	 * {@link com.bug.commons.dao.impl.GraphDao#createVertex(com.thinkaurelius.titan.core.TitanGraph, java.lang.Object)}
//	 * .
//	 * @throws Exception 
//	 */
//	@Ignore
//	@Test
//	public void testCreateVertex() throws Exception {
//		
//		System.out.println("testCreateVertex Start");
//		Employee employee = new Employee();
//		employee.setId("35");
//		employee.setName("Chatchai");
//		employee.setSurname("Vichai");
//		
//		Employee employee2 = new Employee();
//		employee.setId("34");
//		employee.setName("Chatchai");
//		employee.setSurname("Vichai");
//
//		Employee e = employeeDao.createVertex(titanGraph, employee);
//		employeeDao.deleteVertexById(titanGraph, e);
//		System.out.println("Employee:"  + e.getId());
//		System.out.println("testCreateVertex End");
//		
//		employee.setHistory(employee2);
//		
//		Employee e2 = employeeDao.createVertex(titanGraph, employee);
//		
//		
//		
//	}
//	
//	
//	
//	
//
//	/**
//	 * Test method for
//	 * {@link com.bug.commons.dao.impl.GraphDao#relatedVertexParameter(java.lang.Object)}
//	 * .
//	 */
//	@Test
//	@Ignore
//	public void testRelatedVertexParameter() {
//		// fail("Not yet implemented");
////		if(true){
////			sdftsf
////		}
//	}
//
//	/**
//	 * Test method for
//	 * {@link com.bug.commons.dao.impl.GraphDao#getVertexById(com.thinkaurelius.titan.core.TitanGraph, java.lang.Object)}
//	 * .
//	 * @throws Exception 
//	 */
//	@Ignore
//	@Test
//	public void testGetVertexById()
//			throws Exception {
//		System.out.println("testGetVertexById1");
//		Employee employee = new Employee();
//		employee.setId("35");
//		employee.setName("Chatchai");
//		employee.setSurname("Vichai");
//
//		Employee e = employeeDao.createVertex(titanGraph, employee);
//		
//		employee = new Employee();
//		employee.setId("35");
//		
//		 e = employeeDao.getVertexById(titanGraph, employee);
//		 System.out.println(e.getName());
//
//		Assert.assertEquals(employee.getId(), e.getId());
//		System.out.println("testGetVertexById1 End.");
//	}
//
// 
//}
