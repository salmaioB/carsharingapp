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
import cs.model.CustomerOfferWithMessageAndCustomerAccount;
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
		 // Open session
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

		 session.saveOrUpdate(of);

		 tx.commit();
		 HibernateUtil.closeSession();

		 return true;
	}
	
	/**
	 * Function to load an offer
	 */
	public Offer getOffer(Integer idOffer)
	{
		Session session = HibernateUtil.currentSession();
		
		String sqlQuery = "SELECT o._id_offer, o.description, o.starting_city, o.finishing_city, o.number_of_place_initial, o.number_of_place_remaining, sum(r.price) as price_per_passenger, o.datetime_started, o.datetime_ended " +
        				  "FROM offers o, routes r, offers_to_routes o_to_r " +
        				  "WHERE o._id_offer=o_to_r._id_offer " +
        				  "AND o_to_r._id_route=r._id_route " +
        		          "AND o._id_offer=" + idOffer.toString() + " " +
        				  "GROUP BY o._id_offer";
		
		System.out.println(sqlQuery);
		
		Query query = session.createSQLQuery(sqlQuery).addEntity(Offer.class);
		List<Offer> offer = query.list();
		
		HibernateUtil.closeSession();
		
		return (Offer)offer.get(0);
	}
	
	/**
	 * Function to search offers
	 * with starting address and finishing address
	 */
	public List<OfferWithCustomerAccount> loadSearchOffersToParticipate(Integer idCustomerAccount)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "SELECT o._id_offer, o.starting_city, o.finishing_city, c._id_customer_account, c.gender, c.last_name, c.first_name, c.mobile, c.accept_animals, c.accept_radio, c.accept_smoker, c.accept_to_discuss, c.accept_to_make_a_detour, c.datetime_registration, sum(r.price) as price_per_passenger, o.number_of_place_remaining, o.datetime_started " +
                           "FROM offers o, routes r, offers_to_routes o_to_r, customer_accounts c, offers_to_customer_accounts o_to_c ";
	     
	     SQLQuery += "WHERE o._id_offer=o_to_r._id_offer " +
         			 "AND o_to_r._id_route=r._id_route " +
	                 "AND o._id_offer=o_to_c._id_offer " + 
    	 			 "AND o_to_c._id_customer_account=c._id_customer_account " +
    	 			 "AND o_to_c.is_offer_creator = 1 ";
	    	 
    	 if(idCustomerAccount != null)
    	 {    
    		 SQLQuery += "AND o_to_c._id_offer IN ( "+
					" SELECT _id_offer " +
					" FROM offers_to_customer_accounts " +
					" WHERE offers_to_customer_accounts._id_customer_account = " + idCustomerAccount.toString() +
					" AND offers_to_customer_accounts.is_offer_creator = 0 " +
					" ) ";
    	 } 
	     SQLQuery += "GROUP BY o._id_offer ";
	     
	     Query query = session.createSQLQuery(SQLQuery).addEntity(OfferWithCustomerAccount.class);
	     List<OfferWithCustomerAccount> offersWithCustomerAccount = query.list();
		 
	     HibernateUtil.closeSession();
	     
		 return offersWithCustomerAccount;
	}
	
	/**
	 * Function to search offers
	 * with starting address and finishing address
	 */
	public List<OfferWithCustomerAccount> loadSearchOffers(String startingCity, String finishingCity, Integer idCustomerAccount)
	{
	     Session session = HibernateUtil.currentSession();
	     
	     String SQLQuery = "SELECT o._id_offer, o.starting_city, o.finishing_city, c._id_customer_account, c.gender, c.last_name, c.first_name, c.mobile, c.accept_animals, c.accept_radio, c.accept_smoker, c.accept_to_discuss, c.accept_to_make_a_detour, c.datetime_registration, sum(r.price) as price_per_passenger, o.number_of_place_remaining, o.datetime_started " +
                           "FROM offers o, routes r, offers_to_routes o_to_r, customer_accounts c, offers_to_customer_accounts o_to_c ";
	     
	     if(startingCity != null && finishingCity!= null)
	     {
	    	 SQLQuery += ", (" + 
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
                         ") as routes_min_max ";
	     }
	     
	     SQLQuery += "WHERE o._id_offer=o_to_r._id_offer " +
         			 "AND o_to_r._id_route=r._id_route " +
	                 "AND o._id_offer=o_to_c._id_offer " + 
    	 			 "AND o_to_c._id_customer_account=c._id_customer_account " +
    	 			 "AND o_to_c.is_offer_creator = 1 ";
	    	 
    	 if(idCustomerAccount != null)
    		 SQLQuery += "AND c._id_customer_account=" + idCustomerAccount.toString() + " ";
	     
	     if(startingCity != null && finishingCity!= null)
	     {
	    	 SQLQuery += "AND o._id_offer=routes_min_max._id_offer " + 
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
				         "AND r.route_order <= routes_min_max.route_order_max ";
	     }
	     
	     SQLQuery += "GROUP BY o._id_offer ";
	     
	     Query query = session.createSQLQuery(SQLQuery).addEntity(OfferWithCustomerAccount.class);
	     List<OfferWithCustomerAccount> offersWithCustomerAccount = query.list();
		 
	     HibernateUtil.closeSession();
	     
		 return offersWithCustomerAccount;
	}
	
	/**
	 * Function to display offer list
	 * which contain customer message send
	 * 
	 * Use on Android
	 */
	public List<CustomerOfferWithMessageAndCustomerAccount> loadOfferWithCustomerMessageReceive(Integer idCustomerAccount)
	{
		Session session = HibernateUtil.currentSession();
		
		String sqlQuery = "SELECT m._id_message, count(*) as number_of_message, o._id_offer, c._id_customer_account, c.gender, c.last_name, c.first_name, o.starting_city, o.finishing_city " +
						  "FROM offers o, customer_accounts c, messages m, " +
						  "(" +
						  " SELECT o1._id_offer " +
						  " FROM offers o1, customer_accounts c1, offers_to_customer_accounts o_to_c1 " +
						  " WHERE c1._id_customer_account=" + idCustomerAccount.toString() + " " +
						  " AND o_to_c1._id_customer_account=c1._id_customer_account " + 
						  " AND o1._id_offer=o_to_c1._id_offer " +
						  " AND o_to_c1.is_offer_creator=1" +
						  ") as myoffers " +
						  "WHERE myoffers._id_offer=o._id_offer " +
						  "AND o._id_offer=m._id_offer " +
						  "AND m._id_customer_transmitter!=" + idCustomerAccount.toString() + " " +
						  "AND m._id_customer_transmitter=c._id_customer_account " +
						  "GROUP BY o._id_offer, m._id_customer_transmitter";
		
		Query query = session.createSQLQuery(sqlQuery).addEntity(CustomerOfferWithMessageAndCustomerAccount.class);
	    List<CustomerOfferWithMessageAndCustomerAccount> customerMessagesWithOffer = query.list();
		
		HibernateUtil.closeSession();
		
		return customerMessagesWithOffer;
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