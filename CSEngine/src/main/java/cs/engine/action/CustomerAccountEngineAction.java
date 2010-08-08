package cs.engine.action;

import java.util.Date;

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
	
	public Boolean chekup(CustomerAccount ca)
	{
		if( !ca.getCustomerLogin().equals("") && !ca.getCustomerPassword().equals("")
			&& !ca.getEmailAddress().equals("") && !ca.getFirstName().equals("")
			&& !ca.getLastName().equals("") )
			return true;
		else
			return false;
	}
	public Boolean save(CustomerAccount ca)
	{
		if(caBean != null)
		{
			if(chekup(ca))
			{
				ca.setDatetimeRegistration(new Date());
				ca.setDatetimeLastConnection(new Date());
				return caBean.save(ca);
			}
			else 
				return false;
		}
		return false;
	}
	
	public CustomerAccount load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
	
	public CustomerAccount identification(String customerLogin,String customerPassword)
	{
		if(caBean != null)
		{
			return caBean.identification(customerLogin, customerPassword);
		}
		return null;
	}
		
	public void saveCustomerLocation(Integer idCustomerAccount, double longitude, double latitude)
	{
		if(caBean != null)
		{
			caBean.saveCustomerLocation(idCustomerAccount, longitude, latitude);
		}
	}
}
