package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.DAO;
import cs.dao.util.HibernateUtil;
import cs.model.OffersToRoute;

public class OffersToRoutesDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public OffersToRoutesDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.OffersToRoutesDAO");
	}
	
	public OffersToRoute load(Integer id)
	{
		 // Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 // Load data object
		 OffersToRoute offersToRoute = (OffersToRoute)session.load(OffersToRoute.class, id);
		 
		 tx.commit();

		 return offersToRoute;
	}
	
	public Boolean save(OffersToRoute offersToRoute)
	{
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(offersToRoute);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}
