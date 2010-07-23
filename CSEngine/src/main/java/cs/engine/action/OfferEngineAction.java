package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.OfferDAO;
import cs.model.Offer;

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
}
