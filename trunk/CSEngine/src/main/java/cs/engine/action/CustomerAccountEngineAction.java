package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.CustomerAccountDAO;
import cs.model.CustomerAccount;

public class CustomerAccountEngineAction
{
	private CustomerAccountDAO caBean;
	
	public CustomerAccountEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (CustomerAccountDAO) beanFactory.getBean("CustomerAccountDAO");
	}
	
	public CustomerAccount load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
	public CustomerAccount identification(String login,String password)
	{
		if(caBean != null)
		{
			return caBean.identification(login,password);
		}
		return null;
	}
}
