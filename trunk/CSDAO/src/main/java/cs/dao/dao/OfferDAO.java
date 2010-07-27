package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Offer;
import cs.dao.DAO;

public class OfferDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public OfferDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.OfferDAO");
	}
	public Offer load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Offer of = (Offer) session.load( Offer.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Offer of)
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