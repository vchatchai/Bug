//package com.phoenix.framework.authentication;
//
//import static org.easymock.EasyMock.createNiceMock;
//import static org.easymock.EasyMock.expect;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.junit.After;
//import org.junit.Test;
//import static org.junit.Assert.*;
//public class ExampleShiroUnitTest extends AbstractShiroTest {
//
//
//    @Test
//    public void testSimple() {
//    	
//    	
//        //1.  Create a mock authenticated Subject instance for the test to run:
//        Subject subjectUnderTest = createNiceMock(Subject.class);
//        expect(subjectUnderTest.isAuthenticated()).andReturn(true);
//
//        //2. Bind the subject to the current thread:
//        setSubject(subjectUnderTest);
//
//        //perform test logic here.  Any call to 
//        //SecurityUtils.getSubject() directly (or nested in the 
//        //call stack) will work properly.
//        
//        Subject subject = SecurityUtils.getSubject();
//        
//
////        assertNotNull(subject);
////        assertTrue(subjectUnderTest.isAuthenticated());
////        assertEquals("trillian", subject.getPrincipal());
//    }
//
//    @After
//    public void tearDownSubject() {
//        //3. Unbind the subject from the current thread:
//        clearSubject();
//    }
//}
