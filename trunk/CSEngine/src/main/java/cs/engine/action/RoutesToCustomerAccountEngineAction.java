package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.RouteToCustomerAccountDAO;
import cs.model.RoutesToCustomerAccount;

public class RoutesToCustomerAccountEngineAction
{
	private RouteToCustomerAccountDAO caBean;
	
	public RoutesToCustomerAccountEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (RouteToCustomerAccountDAO) beanFactory.getBean("RouteToCustomerAccountDAO");
	}
	
	public RoutesToCustomerAccount load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
