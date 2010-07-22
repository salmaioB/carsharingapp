package cs.dao.test;

import cs.dao.dao.CustomerAccountsDAO;
import cs.model.CustomerAccounts;
import junit.framework.TestCase;

public class TestDAO extends TestCase
{
	public void testaddCustomerAccountDAO()
	{
		CustomerAccountsDAO dao = new CustomerAccountsDAO();
		CustomerAccounts ca = new CustomerAccounts();
		ca.setAcceptAnimals(0);
		ca.setAcceptSmoker(0);
		ca.setCustomerLogin("login");
		
		Boolean b = dao.save(ca);

		assertTrue(b);
		System.out.println("save customerAccounts");
	}
}
