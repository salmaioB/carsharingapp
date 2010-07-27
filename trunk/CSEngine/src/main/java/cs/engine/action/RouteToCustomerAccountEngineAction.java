package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.RouteToCustomerAccountDAO;
import cs.model.RouteToCustomerAccount;

public class RouteToCustomerAccountEngineAction
{
	private RouteToCustomerAccountDAO caBean;
	
	public RouteToCustomerAccountEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (RouteToCustomerAccountDAO) beanFactory.getBean("RouteToCustomerAccountDAO");
	}
	public RouteToCustomerAccount load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
