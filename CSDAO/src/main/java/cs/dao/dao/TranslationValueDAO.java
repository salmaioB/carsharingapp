package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.TranslationValue;

import cs.dao.DAO;

public class TranslationValueDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public TranslationValueDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.TranslationValueDAO");
	}
	
	public TranslationValue load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 TranslationValue of = (TranslationValue) session.load( TranslationValue.class, id );
		 
		 tx.commit();

		 return of;
	}
	
	public Boolean save(TranslationValue of)
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