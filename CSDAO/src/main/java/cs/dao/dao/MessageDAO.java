package cs.dao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Message;
import cs.dao.DAO;

public class MessageDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public MessageDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.MessageDAO");
	}

	public Message load(Integer id)
	{
		//Open session
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.beginTransaction();

		//Load Data object
		Message of = (Message) session.load( Message.class, id );
		 
		tx.commit();

		return of;
	}
	
	public Boolean save(Message of)
	{
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();
		 
		 session.saveOrUpdate(of);

		 tx.commit();		
		 HibernateUtil.closeSession();

		 return true;
	}
	
	public Boolean updateRead(Message of)
	{
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
		 
		 //String hqlQuery = "Update message " +
		  //  " set read = " + of.getRead() +
		  //  " Where _id_message = " + of.getId() ;
		 
		 //System.out.println("hqlQuery : " + hqlQuery);
		 session.save(of);
		 //
	     //Query query =  session.createSQLQuery(hqlQuery);
		 //query.executeUpdate();
		 
		 tx.commit();
		 
		 HibernateUtil.closeSession();

		 return true;
	}
	
	/**
	 * Function count the number of message for a customer
	 */
	public Integer nbMessageNotRead(Integer idCustomerAccount)
	{
		Integer count = 0;
	     Session session = HibernateUtil.currentSession();
	     String sqlQuery = "SELECT * " +
		    			   "FROM messages m " +
		    			   "WHERE m._id_customer_account = " + idCustomerAccount +
		    			   " AND m.is_read = 0 ";
	     
	     String hqlQuery = "FROM Message " +
		    			   "WHERE idCustomerAccount = " + idCustomerAccount +
		    			   " AND isRead = 0 ";
	     
	     System.out.println("nbMessageNotRead");
	     System.out.println(hqlQuery);
	     
	     //Query query = session.createSQLQuery(sqlQuery).addEntity(Message.class);
	     Query query = session.createQuery(hqlQuery);
	     count = query.list().size();

		HibernateUtil.closeSession();
		
		return count;
	}
	
	/**
	 * Function to search message
	 * by id idCustomerAccount
	 */
	public List<Message> loadSearchMessagesReceive(Integer idCustomerAccount)
	{
     Session session = HibernateUtil.currentSession();
     
     String SQLQuery = "FROM Message " +
				       "WHERE idCustomerAccount=" + idCustomerAccount.toString() ;
     
     System.out.println("loadSearchMessagesReceive");
     System.out.println(SQLQuery);
     
     Query query = session.createQuery(SQLQuery);
     List<Message> messages = query.list();
     HibernateUtil.closeSession();
     
	 return messages;
	}
	
	public List<Message> loadSearchMessagesSend(Integer idCustomerTransmitter)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "FROM Message " +
					       "WHERE idCustomerTransmitter=" + idCustomerTransmitter.toString() ;
	     
	     System.out.println("loadSearchMessagesSend");
	     System.out.println(SQLQuery);
	     
	     Query query = session.createQuery(SQLQuery);
	     List<Message> messages = query.list();
	     HibernateUtil.closeSession();
	     
		 return messages;
	}
}