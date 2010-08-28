package com.appweb;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cs.dao.dao.CustomerAccountDAO;
import cs.dao.dao.MessageDAO;
import cs.dao.spring.SpringDAO;
import cs.engine.action.CustomerAccountEngineAction;
import cs.engine.spring.SpringEngine;
import cs.engine.translation.TranslationEngine;
import cs.model.CustomerAccount;
import cs.model.Message;

public class Action extends ActionSupport
{
	private static final long serialVersionUID = 2352769285278947648L;
	private TranslationEngine tr;
	private Map session;
	private Map parameters;
	private CustomerAccount customerAccount;
	private Integer nbMessageNotRead;
	private String language;
	private CustomerAccount customerAccountProfil;
	private Boolean isCurrentCustomer;
	
	public Boolean getIsCurrentCustomer() {
		return isCurrentCustomer;
	}
	public void setIsCurrentCustomer(Boolean isCurrentCustomer) {
		this.isCurrentCustomer = isCurrentCustomer;
	}
	public CustomerAccount getCustomerAccountProfil() {
		return customerAccountProfil;
	}
	public void setCustomerAccountProfil(CustomerAccount customerAccountProfil) {
		this.customerAccountProfil = customerAccountProfil;
	}
	public String getLanguage() {
		if(langage.equals("")) language = "fr";
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNbMessageNotRead() {
		return nbMessageNotRead;
	}
	public void setNbMessageNotRead(Integer nbMessageNotRead) {
		this.nbMessageNotRead = nbMessageNotRead;
	}
	public Boolean isLoging()
	{
		if(getCustomerAccount().getId() == null)
			return false;
		return true;
	}
	public CustomerAccount getCustomerAccount() {
		if(customerAccount==null) 
			customerAccount = new CustomerAccount();
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

	public void initConstructor()
	{
		isCurrentCustomer = true;
		
		//Récupère les variables de sessions et paramètre
		session = ActionContext.getContext().getSession();
		parameters = ActionContext.getContext(). getParameters();

		// Si paramètre existe alors set la nouvelle langue
		if(parameters.get("langage") != null)
			setLangage( ((String[])parameters.get("langage"))[0] );
		
		//Si pas de session déclaré ou si nouveau langugage définit
		if( session.get("language") == null || !getLangage().equals("") )
		{
			//Si variable de session vide
			if( session.get("langage") == null || ((String) session.get("langage")).equals("") )
			{	
				if( getLangage().equals("") )
					session.put("langage","fr");
				else
					session.put("langage",getLangage());
			}
			//Si language choisit
			if(!getLangage().equals(""))
				session.put("langage",getLangage());
		}
		//Initialisation de l'objet de translation avec la langue usuel
		tr = new TranslationEngine();
		String country = (String) session.get("langage");
		language=country;
		tr.setCountry(country);
		
		/*
		System.out.println("username");
		if(parameters.get("username") != null)
		System.out.println( ((String[])parameters.get("username"))[0] );
		*/
		//Si pas de session déclaré ou si nouveau langugage définit
		if( parameters.get("username") != null && parameters.get("password") != null )
		{
			CustomerAccountEngineAction customerAccountEngine = SpringEngine.getSpring().getCustomerAccountEngineAction();
			setCustomerAccount(
					customerAccountEngine.identification(
							((String[])parameters.get("username"))[0] ,
							((String[])parameters.get("password"))[0]  
					)
			);
			System.out.println("getCustomerAccount().getCustomerLogin() : " + getCustomerAccount().getCustomerLogin()  );
			if(getCustomerAccount() != null)
			{
				getSession().put("customerId",getCustomerAccount().getId());
				
		    }
		}
		
		//SetL'objet
		if(getSession().get("customerId") != null)
		{
			if(getSession().get("customerId") != "")
			{
				CustomerAccountDAO cadao = SpringDAO.getSpring().getCustomerAccountDAO();
				customerAccount = cadao.load((Integer)getSession().get("customerId"));
				customerAccount.setDatetimeLastConnection(new Date());
				cadao.save(customerAccount);
				//Set le profil a afficher par defaut
				setCustomerAccountProfil( getCustomerAccount() );
			}
	    }
	
		if(isLoging() )
		{	
			//Gestion des messages
			MessageDAO messageDAO = SpringDAO.getSpring().getMessageDAO();
			setNbMessageNotRead(messageDAO.nbMessageNotRead(getCustomerAccount().getId() ) );
		}
	}
	public Action()
	{
		super();
		initConstructor();
	}
	public Map getSession() {
		return session;
	}
}
