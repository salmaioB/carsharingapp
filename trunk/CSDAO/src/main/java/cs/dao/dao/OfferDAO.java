package cs.dao.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Offer;
import cs.model.OffersToRoute;
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
	     
	     System.out.println(SQLQuery);
	     
	     Query query = session.createSQLQuery(SQLQuery).addEntity(Offer.class);
	     List<Offer> offers = query.list();
		 
	     HibernateUtil.closeSession();
	     
		 return offers;
	}
	
	/**
	 * Function to display the customer offers(routes)
	 */
	public List<Offer> loadCustomerOffers(Integer idCustomerAccount)
	{
		Session session = HibernateUtil.currentSession();
		
		String SQLQuery = "SELECT * " +
		   		          "FROM offers o, routes r, offers_to_routes o_to_r " +
		   		          "WHERE o_to_r._id_offer=o._id_offer " +
		   		          "AND o_to_r._id_route=r._id_route " +
		   		          "AND o._id_driver=" + idCustomerAccount.toString();

		System.out.println(SQLQuery);

		Query query = session.createSQLQuery(SQLQuery).addEntity(Offer.class);
		
		List<Offer> offers = query.list();
		//offers = query.list();
		
		Iterator<Offer> itOffers = offers.iterator();
		while(itOffers.hasNext())
		{
			Offer offer = itOffers.next();
			System.out.println("Price: " + offer.getPricePerPassenger());
		}
		
		List<Route> routes = query.list();
		
		Iterator<Route> itRoutes = routes.iterator();		
		while(itRoutes.hasNext())
		{
			Route route = itRoutes.next();
			System.out.println("Starting city: " + route.getStartingCity());
			System.out.println("Finishing city: " + route.getStartingCity());
		}
		
		HibernateUtil.closeSession();
		
		return null;
	}
	
	/**
	 * Function to save an offer
	 * with his routes
	 */
	public Boolean saveOfferWithRoutes(Offer offer, List<Route> routes)
	{
		// Save an offer
		save(offer);
		
		RouteDAO routeDAO = new RouteDAO();
		
		List<Integer> idRoutes = new ArrayList<Integer>();
		
		Iterator<Route> iteratorRoutes = routes.iterator();
		while(iteratorRoutes.hasNext())
		{
			Route route = iteratorRoutes.next();
		  
			routeDAO.save(route);
			
			idRoutes.add(route.getId());
		}
		
		
		// Save the offer and the route into the correspondence table
		OffersToRoutesDAO offersToRoutesDAO = new OffersToRoutesDAO();
		
		OffersToRoute offersToRoute = new OffersToRoute();
		
		Iterator<Integer> iteratorIdRoutes = idRoutes.iterator();
		while(iteratorIdRoutes.hasNext())
		{
			Integer idRoute = iteratorIdRoutes.next();
			
			offersToRoute.setIdOffer(offer.getId());
			offersToRoute.setIdRoute(idRoute);
			
			offersToRoutesDAO.save(offersToRoute);
		}
		
		return true;
	}
}