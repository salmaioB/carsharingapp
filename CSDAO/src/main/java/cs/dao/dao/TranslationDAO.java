package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Translation;

import cs.dao.DAO;

public class TranslationDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public TranslationDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.TranslationDAO");
	}
	public Translation load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Translation of = (Translation) session.load( Translation.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Translation of)
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