package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.RoutesToCustomerAccount;

import cs.dao.DAO;

public class RoutesToCustomerAccountDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public RoutesToCustomerAccountDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.RouteToCustomerAccountDAO");
	}
	public RoutesToCustomerAccount load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data object
		 RoutesToCustomerAccount of = (RoutesToCustomerAccount)session.load(RoutesToCustomerAccount.class, id);
		 
		 tx.commit();

		 return of;
	}
	
	public Boolean save(RoutesToCustomerAccount routesToCustomerAccount)
	{
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(routesToCustomerAccount);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}