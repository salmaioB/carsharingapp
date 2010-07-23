package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.CustomerAccountsDAO;
import cs.model.CustomerAccounts;

public class CustomerAccountEngineAction
{
	private CustomerAccountsDAO caBean;
	
	public CustomerAccountEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (CustomerAccountsDAO) beanFactory.getBean("CustomerAccountsDAO");
	}
	public CustomerAccounts load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
