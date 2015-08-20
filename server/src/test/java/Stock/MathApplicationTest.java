package Stock;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import junit.framework.TestCase;


@RunWith(EasyMockRunner.class)
public class MathApplicationTest  extends TestCase {
	
	@TestSubject
	public MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calculatorService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("in before class");
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		EasyMock.expect(calculatorService.add(10.0, 20.0)).andReturn(30.0);
		calculatorService.serviceUsed();
		EasyMock.expectLastCall().atLeastOnce();
		
		
		EasyMock.replay(calculatorService);
		
		
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30, 0);
		
		
		EasyMock.verify(calculatorService);
		
	}

}
