package cs.engine.action;

import java.util.Date;

import cs.dao.dao.CustomerAccountDAO;
import cs.model.CustomerAccount;

public class CustomerAccountEngineAction
{
	private CustomerAccountDAO caBean;
	
	public CustomerAccountDAO getCaBean() {
		return caBean;
	}
	public void setCaBean(CustomerAccountDAO caBean) {
		this.caBean = caBean;
	}

	public CustomerAccountEngineAction()
	{
		//caBean = SpringDAO.getSpring().getCustomerAccountDAO();
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
	
	public Boolean update(CustomerAccount ca)
	{
		if(caBean != null)
		{	
				return caBean.update(ca);
		}else
			System.out.println("ERROR : bean null");
		
		return false;
	}
	
	public Boolean save(CustomerAccount ca)
	{
		if(caBean != null)
		{
			if(chekup(ca))
			{
				ca.setDatetimeRegistration(new Date());
				System.out.println("Save du customerAccountEngine : " + ca.getId() );
				return caBean.save(ca);
			}
			else {
				System.out.println("ERROR :  Passe pas le checkup");
				return false;
			}
				
		}
		else
			System.out.println("ERROR : bean null");
		return false;
	}
	
	public CustomerAccount load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		else
			System.out.println("ERROR : bean null");
		return null;
	}
	
	public CustomerAccount identification(String customerLogin,String customerPassword)
	{
		if(caBean != null)
		{
			return caBean.identification(customerLogin, customerPassword);
		}else
			System.out.println("ERROR : bean null");
		return null;
	}
		
	public void saveCustomerLocation(Integer idCustomerAccount, double longitude, double latitude)
	{
		if(caBean != null)
		{
			caBean.saveCustomerLocation(idCustomerAccount, longitude, latitude);
		}
		else
			System.out.println("ERROR : bean null");
	}
	
	public void saveCustomerGeneralInfos(Integer idCustomerAccount, String lastName, String firstName, String emailAddress, String mobile)
	{
		if(caBean != null)
		{
			caBean.saveCustomerGeneralsInfos(idCustomerAccount, lastName, firstName, emailAddress, mobile);
		}
		else
			System.out.println("ERROR : bean null");
	}
	
	public void saveCustomerPreferences(Integer idCustomerAccount, Integer acceptAnimals, Integer acceptRadio, Integer acceptSmoker, Integer acceptToDiscuss, Integer acceptToMakeADetour)
	{
		if(caBean != null)
		{
			caBean.saveCustomerPreferences(idCustomerAccount, acceptAnimals, acceptRadio, acceptSmoker, acceptToDiscuss, acceptToMakeADetour);
		}
		else
			System.out.println("ERROR : bean null");
	}
	
	public Integer saveCustomerNewPassword(Integer idCustomerAccount, String currentPassword, String newPassword)
	{
		if(caBean != null)
		{
			return caBean.saveCustomerNewPassword(idCustomerAccount, currentPassword, newPassword);
		}
		else
			System.out.println("ERROR : bean null");
		return null;
	}
}
