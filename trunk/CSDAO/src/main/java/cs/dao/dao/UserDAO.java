package cs.dao.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.User;

/**
 * Management User and DataBase
 * @author olife
 */
public class UserDAO {
	
	private SessionFactory mySessionFactory;
	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}
	public void setMySessionFactory(SessionFactory mySessionFactory) {
		this.mySessionFactory = mySessionFactory;
	}

	/**
	 * Constructor by default
	 */
	public UserDAO(){
		System.out.println("construct UserDAO");
	}
 public User load(Integer id) throws HibernateException {
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 User use = (User) session.load( User.class, id );
		 
		 tx.commit();

		 return use;
	}
	 public Boolean save(User pers) throws HibernateException {
		 
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
   
		 session.beginTransaction();

		 session.save(pers);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
}
