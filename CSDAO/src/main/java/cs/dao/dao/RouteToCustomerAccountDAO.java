package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.RouteToCustomerAccount;

import cs.dao.DAO;

public class RouteToCustomerAccountDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public RouteToCustomerAccountDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.RouteToCustomerAccountDAO");
	}
	public RouteToCustomerAccount load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 RouteToCustomerAccount of = (RouteToCustomerAccount) session.load( RouteToCustomerAccount.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(RouteToCustomerAccount of)
	{
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(of);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}