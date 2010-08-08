package com.appweb;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.CustomerAccountDAO;
import cs.engine.translation.TranslationEngine;
import cs.model.CustomerAccount;

public class Action extends ActionSupport
{
	private static final long serialVersionUID = 2352769285278947648L;
	private TranslationEngine tr;
	private Map session;
	private Map parameters;
	private CustomerAccount customerAccount;
	
	public Boolean isLoging()
	{
		if(customerAccount == null)
			return false;
		return true;
	}
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
	public Map getParameters() {
		return parameters;
	}
	public String langage;
	
	public String getLangage() {
		if(langage == null ) langage ="";
		return langage;
	}
	public void setLangage(String langage) {
		this.langage = langage;
	}
	public TranslationEngine getTr() {
		return tr;
	}
	public void setTr(TranslationEngine tr) {
		this.tr = tr;
	}

	public Action()
	{
		super();
		//Récupère les variables de sessions et paramètre
		session = ActionContext.getContext().getSession();
		parameters = ActionContext.getContext(). getParameters();

		// Si paramètre existe alors set la nouvelle langue
		if(parameters.get("langage") != null)
			setLangage( ((String[])parameters.get("langage"))[0] );
		
		//Si pas de session déclaré ou si nouveau langugage définit
		if( session.get("language") == null || !getLangage().equals(""))
		{
			if( getLangage().equals("") )
				session.put("langage","fr");
			else
				session.put("langage",getLangage());
		}
		//Initialisation de l'objet de translation avec la langue usuel
		tr = new TranslationEngine();
		String country = (String) session.get("langage");
		tr.setCountry(country);
		
		//SetL'objet
		if(getSession().get("customerId") != null)
		{
			if(getSession().get("customerId") != "")
			{
				CustomerAccountDAO cadao = new CustomerAccountDAO();
				customerAccount = cadao.load((Integer)getSession().get("customerId")); 
			}
	    }
	}
	public Map getSession() {
		return session;
	}
}
