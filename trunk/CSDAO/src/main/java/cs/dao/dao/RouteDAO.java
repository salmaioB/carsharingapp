package cs.dao.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cs.dao.util.HibernateUtil;
import cs.model.Offer;
import cs.model.Route;

import cs.dao.DAO;

public class RouteDAO extends DAO
{
	/**
	 * Constructor by default
	 */
	public RouteDAO()
	{
		System.out.println("[Spring] load class:cs.dao.dao.RouteDAO");
	}

	public List<Route> loadRoutes(Integer idOffer)
	{
		Session session = HibernateUtil.currentSession();
		
		String SQLQuery = "SELECT * " +
						  " FROM routes, offers_to_routes " +
		   		          " WHERE offers_to_routes._id_offer =  " + idOffer.toString() +
		   		          " AND routes._id_route = offers_to_routes._id_route " +
		   		          " order by route_order asc" ;

		System.out.println(SQLQuery);

		Query query = session.createSQLQuery(SQLQuery).addEntity(Route.class);
		
		List<Route> routes = query.list();	
		
		HibernateUtil.closeSession();
		
		return routes;
	}
	public Route load(Integer id)
	{
		 //Open session
		 Session session = HibernateUtil.currentSession();
		 Transaction tx = session.beginTransaction();
		 session.beginTransaction();

		 //Load Data objec
		 Route of = (Route) session.load( Route.class, id );
		 
		 tx.commit();

		 return of;
	}
	public Boolean save(Route of)
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