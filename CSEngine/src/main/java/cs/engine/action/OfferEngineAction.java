package cs.engine.action;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;
import cs.model.Route;

public class OfferEngineAction
{
	private OfferDAO caBean;
	
	public OfferEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (OfferDAO) beanFactory.getBean("OfferDAO");
	}
	
	public Offer load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
	
	public Boolean saveOfferWithRoutes(Offer offer, List<Route> routes)
	{
		if(caBean != null)
		{
			return caBean.saveOfferWithRoutes(offer, routes);
		}
		return false;
	}
}
