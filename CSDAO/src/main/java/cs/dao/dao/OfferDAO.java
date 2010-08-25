package cs.dao.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Offer;
import cs.model.OfferWithCustomerAccount;
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
	public List<OfferWithCustomerAccount> loadSearchOffers(String startingCity, String finishingCity)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "SELECT o._id_offer, r.starting_city, r.finishing_city, c._id_customer_account, c.gender, c.last_name, c.first_name, c.mobile, c.accept_animals, c.accept_radio, c.accept_smoker, c.accept_to_discuss, c.accept_to_make_a_detour, c.datetime_registration, sum(r.price) as price_per_passenger, o.number_of_place_remaining, o.datetime_started " +
                           "FROM offers o, routes r, offers_to_routes o_to_r, customer_accounts c, " + 
                           "(" + 
                           " SELECT o1._id_offer AS _id_offer, MIN(r1.route_order) as route_order_min, MAX(r1.route_order) as route_order_max " + 
                           " FROM offers o1, routes r1, offers_to_routes o_to_r1 " + 
                           " WHERE o1._id_offer = o_to_r1._id_offer " + 
                           " AND o_to_r1._id_route = r1._id_route " + 
                           " AND " +
                           " (" + 
                           "  r1.starting_city = '" + startingCity.toString() + "' " +
                           "  OR r1.finishing_city = '" + finishingCity.toString() + "' " + 
                           " )" + 
                           " GROUP BY o1._id_offer " +
                           ") as routes_min_max " + 
                           "WHERE o._id_offer = routes_min_max._id_offer " +
                           "AND o._id_driver=c._id_customer_account " + 
                           "AND o._id_offer=o_to_r._id_offer " +
                           "AND o_to_r._id_route = r._id_route " +
                           "AND " +
                           "( " +
                           " routes_min_max.route_order_min != routes_min_max.route_order_max " +
                           " OR " +
                           " (" +
                           "  r.starting_city = '" + startingCity.toString() + "' " +
                           "  AND r.finishing_city = '" + finishingCity.toString() + "'" +
                           " )" +
                           ") " +
                           "AND r.route_order >= routes_min_max.route_order_min " +
                           "AND r.route_order <= routes_min_max.route_order_max " +
                           "GROUP BY o._id_offer";
	     
	     System.out.println(SQLQuery);
	     
	     Query query = session.createSQLQuery(SQLQuery).addEntity(OfferWithCustomerAccount.class);
	     List<OfferWithCustomerAccount> offersWithCustomerAccount = query.list();
		 
	     HibernateUtil.closeSession();
	     
		 return offersWithCustomerAccount;
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