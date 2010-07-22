package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.CustomerAccountsDAO;
import cs.dao.dao.UserDAO;
import cs.model.CustomerAccounts;
import cs.model.User;

public class CustomerAccountsEngineAction
{
	private CustomerAccountsDAO caBean;
	
	public CustomerAccountsEngineAction()
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
