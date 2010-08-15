package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Opinion;

import cs.dao.DAO;

public class OpinionDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public OpinionDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.OpinionDAO");
	}
	
	public Opinion load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Opinion of = (Opinion) session.load( Opinion.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Opinion of)
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