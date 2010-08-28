package cs.dao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cs.dao.util.HibernateUtil;
import cs.model.CustomerAccount;
import cs.model.OffersToCustomerAccount;
import cs.dao.DAO;

public class OffersToCustomerAccountsDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public OffersToCustomerAccountsDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.OffersToCustomerAccountsDAO");
	}

	public Boolean isOfferPassenger(Integer idOffer,Integer idCustomer)
	{
		Session session = HibernateUtil.currentSession();
	    String sqlQuery = "Select * " +
		    	" FROM  offers_to_customer_accounts " +
			    " WHERE _id_offer = " + idOffer +
		        " And is_offer_creator = 1 " +
		        " And _id_customer_account = " + idCustomer.toString() +
		        " And is_driver = 0";
		    
		System.out.println(sqlQuery);
		     
		Query query = session.createSQLQuery(sqlQuery).addEntity(OffersToCustomerAccount.class);
		
		HibernateUtil.closeSession();

		if(query.list().size() > 0)
			return true;
		return false;
	}
	public CustomerAccount getCreatorOffer(Integer idOffer)
	{
		Session session = HibernateUtil.currentSession();
	    String sqlQuery = "Select * " +
		    	" FROM  customer_accounts, offers_to_customer_accounts " +
			    " WHERE _id_offer = " + idOffer +
		        " And is_offer_creator = 1 " +
		        " And customer_accounts._id_customer_account = offers_to_customer_accounts._id_customer_account";
		    
		System.out.println(sqlQuery);
		     
		Query query = session.createSQLQuery(sqlQuery).addEntity(CustomerAccount.class);
		CustomerAccount ca = (CustomerAccount) query.list().get(0);
		
		HibernateUtil.closeSession();

		return ca;
	}
	public List<CustomerAccount> loadListCustomerParticipateOffer(Integer idOffer,Integer idCustomerAccountCurrent)
	{
		Session session = HibernateUtil.currentSession();
	    String sqlQuery = "SELECT * " +
					      " FROM customer_accounts, offers_to_customer_accounts " +
						  " WHERE _id_offer = " + idOffer +
					      " And customer_accounts._id_customer_account = offers_to_customer_accounts._id_customer_account" +
					      " And customer_accounts._id_customer_account != " + idCustomerAccountCurrent.toString();
		    
		System.out.println(sqlQuery);
		     
		Query query = session.createSQLQuery(sqlQuery).addEntity(CustomerAccount.class);
		
		HibernateUtil.closeSession();
		
		return query.list();
	}
	public Boolean isCreatorOffer(Integer idOffer, Integer idCustomerCreator)
	{
	    Session session = HibernateUtil.currentSession();
	    Integer count = 0;
	    String hqlQuery = "FROM OffersToCustomerAccount " +
		    " WHERE idOffer = " + idOffer +
	        " AND idCustomerAccount = " + idCustomerCreator +
	        " And isOfferCreator = 1 ";
	    
	     System.out.println(hqlQuery);
	     
	     Query query = session.createQuery(hqlQuery);
	     count = query.list().size();
		HibernateUtil.closeSession();
		if(count == 0)
			return false;
		else
			return true;
	}
	public Boolean isParticipate(Integer idOffer, Integer idCustomer)
	{
	    Session session = HibernateUtil.currentSession();
	    Integer count = 0;
	    String hqlQuery = "FROM OffersToCustomerAccount " +
		    " WHERE idOffer = " + idOffer +
	        " AND idCustomerAccount = " + idCustomer;
	    
	     
	     System.out.println(hqlQuery);
	     
	     Query query = session.createQuery(hqlQuery);
	     count = query.list().size();
		HibernateUtil.closeSession();
		if(count == 0)
			return false;
		else
			return true;
	}
	
	public OffersToCustomerAccount load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 OffersToCustomerAccount of = (OffersToCustomerAccount)session.load(OffersToCustomerAccount.class, id);
		 
		 tx.commit();

		 return of;
	}
	
	public Boolean save(OffersToCustomerAccount offerToCustomerAccount)
	{
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(offerToCustomerAccount);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}