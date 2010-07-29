package cs.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.TranslationValue;

import cs.dao.DAO;

public class TranslationValueDAO extends DAO
{
	private List<TranslationValue> listTranslationValue;
	public Map<Integer, Map<String, String>> getTranslation() {
		return translation;
	}

	private Map<Integer,Map<String,String>> translation;
	
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
	     
	     translation = new HashMap<Integer,Map<String,String>>();
	     
	     for(TranslationValue tr:listTranslationValue )
	     {
	    	 Map<String,String> contains = translation.get(tr.getIdTranslation());
	    	 if(contains == null ) contains = new HashMap<String,String>();
	    	 contains.put(tr.getCountryCode(), tr.getTranslationValue());
	    	 
	    	 translation.put(tr.getIdTranslation(), contains);
	     }
	     
		 tx.commit();
	}
	
	public String load(Integer id,String country)
	{
		 return translation.get(id).get(country);
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