package cs.dao.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.CustomerAccount;
import cs.dao.DAO;

public class CustomerAccountDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public CustomerAccountDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.CustomerAccountDAO");
	}
	
	public CustomerAccount identification(String login, String password)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "FROM CustomerAccount where customerLogin ='"+login+"' And customerPassword ='"+password+"'";
	     
	     Query query = session.createQuery(SQLQuery);
	     List list = query.list();
		 
	     HibernateUtil.closeSession();
	     return (CustomerAccount) list.get(0);
	}
	
	public CustomerAccount load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data object
		 CustomerAccount ca = (CustomerAccount) session.load(CustomerAccount.class, id);
		 
		 tx.commit();

		 return ca;
	}
	
	public Boolean save(CustomerAccount ca)
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