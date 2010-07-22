package cs.dao.test;

import cs.dao.dao.CustomerAccountsDAO;
import cs.dao.dao.UserDAO;
import cs.model.CustomerAccounts;
import cs.model.User;
import junit.framework.TestCase;

public class TestDAO extends TestCase
{
/*
	public void testloadUserDAO() {
		UserDAO usa = new UserDAO();
		User use = usa.load(1);

		assertNotNull(use);

		System.out.println("Read use" + use.getName());
	}

	
	public void testaddUserDAO() {
		UserDAO usa = new UserDAO();
        User pers = new User();
        pers.setAdresse("adresse");
        pers.setCp("cp");
        pers.setLastname("lastname");
        pers.setName("name");
        pers.setVille("ville");
		Boolean b = usa.save(pers);

		assertTrue(b);

		System.out.println("Enregistré");
	}
	*/
	public void testaddCustomerAccountDAO()
	{
		CustomerAccountsDAO dao = new CustomerAccountsDAO();
		CustomerAccounts ca = new CustomerAccounts();
		ca.setAcceptAnimals(0);
		ca.setAcceptSmoker(0);
		ca.setLogin("login");
		
		Boolean b = dao.save(ca);

		assertTrue(b);
		System.out.println("save customerAccounts");
	}
}
