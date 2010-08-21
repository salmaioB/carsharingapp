package cs.engine.spring;

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
import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.action.MessageWithCustomerAccountAction;
import cs.engine.action.OfferEngineAction;
import cs.engine.action.OpinionEngineAction;
import cs.engine.action.TranslationEngineAction;
import cs.engine.action.TranslationValueEngineAction;

public class SpringEngine 
{
	
	private static ListableBeanFactory bf  = new XmlBeanFactory(new ClassPathResource("bean.xml"));
	
	private CustomerAccountEngineAction customerAccountEngineAction;
	private MessageWithCustomerAccountAction messageWithCustomerAccountAction;
	private OfferEngineAction offerEngineAction;
	private OpinionEngineAction opinionEngineAction;
	private TranslationEngineAction translationEngineAction;
	private TranslationValueEngineAction translationValueEngineAction;

	public SpringEngine ()
	{
		
	}

	public static ListableBeanFactory getBf() {
		return bf;
	}


	public static void setBf(ListableBeanFactory bf) {
		SpringEngine.bf = bf;
	}


	public CustomerAccountEngineAction getCustomerAccountEngineAction() {
		return customerAccountEngineAction;
	}


	public void setCustomerAccountEngineAction(
			CustomerAccountEngineAction customerAccountEngineAction) {
		this.customerAccountEngineAction = customerAccountEngineAction;
	}


	public MessageWithCustomerAccountAction getMessageWithCustomerAccountAction() {
		return messageWithCustomerAccountAction;
	}


	public void setMessageWithCustomerAccountAction(
			MessageWithCustomerAccountAction messageWithCustomerAccountAction) {
		this.messageWithCustomerAccountAction = messageWithCustomerAccountAction;
	}


	public OfferEngineAction getOfferEngineAction() {
		return offerEngineAction;
	}


	public void setOfferEngineAction(OfferEngineAction offerEngineAction) {
		this.offerEngineAction = offerEngineAction;
	}


	public OpinionEngineAction getOpinionEngineAction() {
		return opinionEngineAction;
	}


	public void setOpinionEngineAction(OpinionEngineAction opinionEngineAction) {
		this.opinionEngineAction = opinionEngineAction;
	}


	public TranslationEngineAction getTranslationEngineAction() {
		return translationEngineAction;
	}


	public void setTranslationEngineAction(
			TranslationEngineAction translationEngineAction) {
		this.translationEngineAction = translationEngineAction;
	}


	public TranslationValueEngineAction getTranslationValueEngineAction() {
		return translationValueEngineAction;
	}


	public void setTranslationValueEngineAction(
			TranslationValueEngineAction translationValueEngineAction) {
		this.translationValueEngineAction = translationValueEngineAction;
	}


	/**
	 * getteur
	 * @return
	 */
	public static SpringEngine getSpring()
	{
		return (SpringEngine) bf.getBean("SpringEngine");
	}
}
