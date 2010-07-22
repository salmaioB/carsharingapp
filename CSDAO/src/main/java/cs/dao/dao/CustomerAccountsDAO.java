package cs.dao.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.CustomerAccounts;

public class CustomerAccountsDAO extends DAO
{
	public CustomerAccounts load(Integer id) throws HibernateException
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 CustomerAccounts ca = (CustomerAccounts) session.load( CustomerAccounts.class, id );
		 
		 tx.commit();

		 return ca;
	}
	public Boolean save(CustomerAccounts ca) throws HibernateException
	{
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(ca);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}