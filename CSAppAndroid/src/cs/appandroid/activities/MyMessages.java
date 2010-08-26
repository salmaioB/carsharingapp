package cs.appandroid.activities;

import java.util.ArrayList;
import java.util.List;

import cs.appandroid.components.MyMessagesListAdapter;
import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;
import cs.webservice.CustomerOffersWithMessageAndCustomerAccountWS;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;


public class MyMessages extends ListActivity
{	
	private MyMessagesListAdapter myMessagesListAdapter;
	private ProgressDialog displayMyMessagesReceivedProgressDialog;
	
	private List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount = null;
	
	private Runnable displayCustomerOffersWithMessageAndCustomerAccountProcess;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
        
		customerOffersWithMessageAndCustomerAccount = new ArrayList<CustomerOfferWithMessageAndCustomerAccount>();
		
		myMessagesListAdapter = new MyMessagesListAdapter(this, R.layout.messagerow, customerOffersWithMessageAndCustomerAccount);	    
	    setListAdapter(myMessagesListAdapter);
		
		displayCustomerOffersWithMessageAndCustomerAccountProcess = new Runnable()
		{
			@Override
			public void run()
			{
				getCustomerOffersWithMessageAndCustomerAccount();
			}
		};
		
		Thread displayMyMessagesReceivedThread =  new Thread(null, displayCustomerOffersWithMessageAndCustomerAccountProcess, "DisplayMyMessagesReceivedThread");
		displayMyMessagesReceivedThread.start();
		
		displayMyMessagesReceivedProgressDialog = ProgressDialog.show(MyMessagesGroup.myMessagesGroup, "Patientez ...", "Récupération de vos messages...");
	}
	
	private Runnable returnCustomerOffersWithMessageAndCustomerAccount = new Runnable()
	{
		@Override
        public void run()
		{
            if(customerOffersWithMessageAndCustomerAccount != null && customerOffersWithMessageAndCustomerAccount.size() > 0)
            {
            	myMessagesListAdapter.notifyDataSetChanged();
                for(int i=0; i<customerOffersWithMessageAndCustomerAccount.size(); i++)
                	myMessagesListAdapter.add(customerOffersWithMessageAndCustomerAccount.get(i));
            }
            
            displayMyMessagesReceivedProgressDialog.dismiss();
            myMessagesListAdapter.notifyDataSetChanged();
        }
    };
	
	public void getCustomerOffersWithMessageAndCustomerAccount()
	{
		CustomerOffersWithMessageAndCustomerAccountWS customerOffersWithMessageAndCustomerAccountWS = new CustomerOffersWithMessageAndCustomerAccountWS();
		
		customerOffersWithMessageAndCustomerAccount = customerOffersWithMessageAndCustomerAccountWS.getCustomerOffersWithMessage(IdentificationController.getUserLoggedId(getBaseContext()));
	
		runOnUiThread(returnCustomerOffersWithMessageAndCustomerAccount);
	}
}