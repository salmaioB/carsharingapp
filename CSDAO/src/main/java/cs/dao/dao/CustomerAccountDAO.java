package cs.dao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.CustomerAccount;
import cs.dao.DAO;

public class CustomerAccountDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public CustomerAccountDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.CustomerAccountDAO");
	}
	
	public CustomerAccount load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data object
		 CustomerAccount ca = (CustomerAccount) session.load(CustomerAccount.class, id);
		 
		 tx.commit();

		 return ca;
	}
	
	public Boolean save(CustomerAccount ca)
	{
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(ca);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
	
	/**
	 *  Search a customer account
	 *  If one customer account is founded -> OK (the customer is returned)
	 *  Else return NULL
	 */
	public CustomerAccount identification(String customerLogin, String customerPassword)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "SELECT * FROM customer_accounts " + 
	    	               "WHERE customer_login = '" + customerLogin + "' " + 
	    	               "AND customer_password = '" + customerPassword + "'";
	     
	     Query query = session.createSQLQuery(SQLQuery);
	     
	     List customerAccountList = query.list();
		 
	     HibernateUtil.closeSession();

	     if(customerAccountList.size() == 1)
	     { 
	    	 return (CustomerAccount)customerAccountList.get(0);
	     }
	     else
	     {
	    	 return null;
	     }
	}
}