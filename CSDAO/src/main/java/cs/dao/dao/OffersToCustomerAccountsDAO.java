package cs.dao.dao;

import org.hibernate.Session;

import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.OffersToCustomerAccounts;
import cs.dao.DAO;

public class OffersToCustomerAccountsDAO extends DAO
{
	public OffersToCustomerAccounts load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 OffersToCustomerAccounts of = (OffersToCustomerAccounts) session.load( OffersToCustomerAccounts.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(OffersToCustomerAccounts of)
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