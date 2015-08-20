package Stock;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.osjava.sj.SimpleContextFactory;
import org.osjava.sj.memory.MemoryContextFactory;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:test-applicationContext.xml" })



@Ignore
public class PortfolioTest  {
	// Portfolio portfolio;
	// StockService stockService;

	// private final Context context = EasyMock.createNiceMock(Context.class);

	@BeforeClass
	public static void beforeClass() {
		System.out.println("in before class");
	}

	 @BeforeClass
	public static void setUpClass() {

		System.out.println("in before class");
		try {
			 System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
			 MemoryContextFactory.class.getName());
			 System.setProperty("org.osjava.sj.jndi.shared", "true");
			// System.setProperty("org.osjava.sj.root", "/tmp");
			//
			// System.setProperty("org.osjava.jndi.delimiter", "/");
			// System.setProperty("org.osjava.sj.jndi.shared", "true");

			System.out.println(SimpleContextFactory.class.getName());

			// java.naming.factory.initial=org.osjava.sj.SimpleContextFactory
			// =
			// org.osjava.jndi.delimiter=/
			// org.osjava.sj.jndi.shared=true

			InitialContext ic = new InitialContext();
			// DataSource ds = (DataSource) ctxt.lookup("jdbc."+ds_name);
			// rebind for alias if needed
			ic.createSubcontext("java:/comp/env/jdbc");
			ic.bind("java:/comp/env/jdbc/myDS", "Test");

			String ds = (String) ic.lookup("java:/comp/env/jdbc/myDS");
			System.out.println("DS:" + ds);
			// ctxt.rebind("jboss:common_ds", "test");
			// System.out.println("Test" +ctxt.lookup("jboss:common_ds"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUP");
		// portfolio = new Portfolio();
		//
		//
		//
		// stockService = EasyMock.createMock(StockService.class);
		// portfolio.setStockService(stockService);

	}

	@Test
	public void testGetMarketValue() {
		for (Object key : System.getProperties().keySet()) {
			// System.out.println("key:" + key + " value" +
			// System.getProperty((String)key));
		}

		System.out.println("Test" + MemoryContextFactory.class.getName());
		System.out.println(System.getProperty(Context.INITIAL_CONTEXT_FACTORY));
		try {
			// System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
			// MemoryContextFactory.class.getName());

			// System.setProperty("org.osjava.sj.jndi.shared", "true");

			// System.setProperty("org.osjava.sj.jndi.shared", "true");
			// System.setProperty("org.osjava.sj.root",
			// "target/test-classes/config");

			// System.setProperty("org.osjava.jndi.delimiter", "/");
			// System.setProperty("org.osjava.sj.jndi.shared", "true");
			// InitialContext ic = new InitialContext();

			InitialContext ic = new InitialContext();
			String ds = (String) ic.lookup("java:/comp/env/jdbc/myDS");
			//
			// Object o = ic.lookup("jboss:common_ds");
			System.out.println("Init Context:" + ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//

		// System.out.println("INITIAL_CONTEXT_FACTORY:" +
		// System.getProperty(Context.INITIAL_CONTEXT_FACTORY));
		// List<Stock> stocks = new ArrayList<Stock>();
		// Stock googleStock = new Stock("1", "Google", 10);
		// Stock micorStock = new Stock("2", "Microsoft", 100);
		// stocks.add(googleStock);
		// stocks.add(micorStock);
		//
		// portfolio.setStocks(stocks);
		// EasyMock.expect(stockService.getPrice(googleStock)).andReturn(50.00);
		// EasyMock.expect(stockService.getPrice(micorStock)).andReturn(1000.00);
		//
		// EasyMock.replay(stockService);
		//
		// double marketService = portfolio.getMarketValue();
		// assertEquals(marketService, 100500.00, 0);
	}

}
