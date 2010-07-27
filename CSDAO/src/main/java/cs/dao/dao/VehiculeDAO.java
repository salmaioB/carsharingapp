package cs.dao.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Vehicule;

import cs.dao.DAO;

public class VehiculeDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public VehiculeDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.VehiculeDAO");
	}
	public Vehicule load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Vehicule of = (Vehicule) session.load( Vehicule.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Vehicule of)
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