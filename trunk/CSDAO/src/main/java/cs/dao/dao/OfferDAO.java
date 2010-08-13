package cs.dao.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Offer;
import cs.model.Route;
import cs.dao.DAO;

public class OfferDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public OfferDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.OfferDAO");
	}
	
	public Offer load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data object
		 Offer of = (Offer) session.load( Offer.class, id );
		 
		 tx.commit();

		 return of;
	}
	
	public Boolean save(Offer of)
	{
		 Session session = HibernateUtil.currentSession();		   
		 Transaction tx = session.beginTransaction();
  
		 session.beginTransaction();

		 session.save(of);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
	
	/**
	 * Function to search offers
	 * with starting address and finishing address
	 */
	public List<Offer> loadSearchOffers(String startingAddress, String startingCity, String finishingAddress, String finishingCity)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "SELECT * " +
						   "FROM offers o, routes r, offers_to_routes o_to_r " +
					       "WHERE o_to_r._id_offer=o._id_offer " +
					       "AND o_to_r._id_route=r._id_route " +
					       "AND r.starting_address= '" + startingAddress + "' " +
					       "AND r.starting_city= '" + startingCity + "' " +
					       "AND r.finishing_address= '" + finishingAddress + "' " +
					       "AND r.finishing_city= '" + finishingCity + "'";
	     
	//     String SQLQuery = "SELECT * " +
	//	   				   "FROM routes";
	     
	     System.out.println(SQLQuery);
	     
	     Query query = session.createSQLQuery(SQLQuery).addEntity(Offer.class);
	     List<Offer> offers = query.list();
		 
	     HibernateUtil.closeSession();
	     
		 return offers;
	}
	
	/**
	 * Function to save an offer
	 * with his routes
	 */
	public Boolean saveOfferWithRoutes(Offer offer, List<Route> routes)
	{
		// Save an offer
		save(offer);

		return true;	
	}
}