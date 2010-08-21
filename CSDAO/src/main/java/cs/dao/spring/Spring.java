package cs.dao.spring;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.dao.dao.OfferDAO;
import cs.dao.dao.OffersToCustomerAccountsDAO;
import cs.dao.dao.OffersToRoutesDAO;
import cs.dao.dao.OpinionDAO;
import cs.dao.dao.RouteDAO;
import cs.dao.dao.RoutesToCustomerAccountDAO;
import cs.dao.dao.TranslationDAO;
import cs.dao.dao.TranslationValueDAO;
import cs.dao.dao.VehiculeDAO;

public class Spring 
{
	
	private static ListableBeanFactory bf  = new XmlBeanFactory(new ClassPathResource("bean.xml"));
	public Spring ()
	{
		
	}
	
	private CustomerAccountDAO customerAccountDAO;
	private OfferDAO offerDAO;
	private OffersToCustomerAccountsDAO offersToCustomerAccountsDAO;
	private OpinionDAO opinionDAO;
	private RouteDAO routeDAO;
	private RoutesToCustomerAccountDAO routesToCustomerAccountDAO;
	private TranslationDAO translationDAO;
	private TranslationValueDAO translationValueDAO;
	private MessageDAO messageDAO;

	public CustomerAccountDAO getCustomerAccountDAO() {
		return customerAccountDAO;
	}

	public void setCustomerAccountDAO(CustomerAccountDAO customerAccountDAO) {
		this.customerAccountDAO = customerAccountDAO;
	}

	public OfferDAO getOfferDAO() {
		return offerDAO;
	}

	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

	public OffersToCustomerAccountsDAO getOffersToCustomerAccountsDAO() {
		return offersToCustomerAccountsDAO;
	}

	public void setOffersToCustomerAccountsDAO(
			OffersToCustomerAccountsDAO offersToCustomerAccountsDAO) {
		this.offersToCustomerAccountsDAO = offersToCustomerAccountsDAO;
	}

	public OpinionDAO getOpinionDAO() {
		return opinionDAO;
	}

	public void setOpinionDAO(OpinionDAO opinionDAO) {
		this.opinionDAO = opinionDAO;
	}

	public RouteDAO getRouteDAO() {
		return routeDAO;
	}

	public void setRouteDAO(RouteDAO routeDAO) {
		this.routeDAO = routeDAO;
	}

	public RoutesToCustomerAccountDAO getRoutesToCustomerAccountDAO() {
		return routesToCustomerAccountDAO;
	}

	public void setRoutesToCustomerAccountDAO(
			RoutesToCustomerAccountDAO routesToCustomerAccountDAO) {
		this.routesToCustomerAccountDAO = routesToCustomerAccountDAO;
	}

	public TranslationDAO getTranslationDAO() {
		return translationDAO;
	}

	public void setTranslationDAO(TranslationDAO translationDAO) {
		this.translationDAO = translationDAO;
	}

	public TranslationValueDAO getTranslationValueDAO() {
		return translationValueDAO;
	}

	public void setTranslationValueDAO(TranslationValueDAO translationValueDAO) {
		this.translationValueDAO = translationValueDAO;
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public OffersToRoutesDAO getOffersToRoutesDAO() {
		return offersToRoutesDAO;
	}

	public void setOffersToRoutesDAO(OffersToRoutesDAO offersToRoutesDAO) {
		this.offersToRoutesDAO = offersToRoutesDAO;
	}

	private OffersToRoutesDAO offersToRoutesDAO;

	/**
	 * getteur
	 * @return
	 */
	public static Spring getSpring()
	{
		return (Spring) bf.getBean("Spring");
	}
}
