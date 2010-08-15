package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Route;

import cs.dao.DAO;

public class RouteDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public RouteDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.RouteDAO");
	}
	
	public Route load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Route of = (Route) session.load( Route.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Route of)
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