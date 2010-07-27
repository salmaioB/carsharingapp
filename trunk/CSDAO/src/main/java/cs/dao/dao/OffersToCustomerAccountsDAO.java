package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import cs.dao.util.HibernateUtil;
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