package cs.engine.action;

import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.spring.Spring;
import cs.model.CustomerAccount;

public class CustomerAccountEngineAction
{
	private CustomerAccountDAO caBean;
	
	public CustomerAccountEngineAction()
	{
		caBean = Spring.getSpring().getCustomerAccountDAO();
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (CustomerAccountDAO) beanFactory.getBean("CustomerAccountDAO");
	}
	
	public Boolean chekup(CustomerAccount ca)
	{
		if( !ca.getCustomerLogin().equals("") && !ca.getCustomerPassword().equals("")
			&& !ca.getEmailAddress().equals("") )
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
	
	public void saveCustomerGeneralInfos(Integer idCustomerAccount, String lastName, String firstName, String emailAddress, String mobile)
	{
		if(caBean != null)
		{
			caBean.saveCustomerGeneralsInfos(idCustomerAccount, lastName, firstName, emailAddress, mobile);
		}
	}
	
	public void saveCustomerPreferences(Integer idCustomerAccount, Integer acceptAnimals, Integer acceptRadio, Integer acceptSmoker, Integer acceptToDiscuss, Integer acceptToMakeADetour)
	{
		if(caBean != null)
		{
			caBean.saveCustomerPreferences(idCustomerAccount, acceptAnimals, acceptRadio, acceptSmoker, acceptToDiscuss, acceptToMakeADetour);
		}	
	}
}
