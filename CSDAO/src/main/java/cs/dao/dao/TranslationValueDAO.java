package cs.dao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.TranslationValue;

import cs.dao.DAO;

public class TranslationValueDAO extends DAO
{
	private List<TranslationValue> listTranslationValue;
	
	public List<TranslationValue> getListTranslationValue() {
		return listTranslationValue;
	}

	/**
	 * Constructor by default
	 */
	public TranslationValueDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.TranslationValueDAO");
		
		 // Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 // Load Data object
	     String SQLQuery = "FROM TranslationValue";
	     Query query = session.createQuery(SQLQuery);
	     listTranslationValue = query.list();
	     
		 tx.commit();
	}
	
	public String load(Integer id,String country)
	{
		 return "Ma translation";
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