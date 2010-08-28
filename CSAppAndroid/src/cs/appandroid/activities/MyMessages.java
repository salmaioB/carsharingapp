package cs.appandroid.activities;

import java.util.ArrayList;
import java.util.List;

import cs.appandroid.activitiesgroup.MyMessagesGroup;
import cs.appandroid.components.MyMessagesListAdapter;
import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;
import cs.model.Offer;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.CustomerAccountsWS;
import cs.webservice.CustomerOffersWithMessageAndCustomerAccountWS;
import cs.webservice.OffersWS;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


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
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		
		// Retrieve the customer offer with message clicked
		CustomerOfferWithMessageAndCustomerAccount customerOfferClicked = customerOffersWithMessageAndCustomerAccount.get(position);
		Integer idOfferSelected = customerOfferClicked.getOffer().getId();
		
		Log.v("idOffer", idOfferSelected.toString());
		
		// Retrieve the whole offer selected
		OffersWS offersWS = new OffersWS();
		Offer offer = offersWS.getOffer(idOfferSelected);
		
		// Retrieve the whole customer account selected
		CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
		CustomerAccount customerAccount = customerAccountWS.getCustomerAccount(customerOfferClicked.getCustomerAccount().getId());
		
		OfferWithCustomerAccount offerWithCustomerAccount = new OfferWithCustomerAccount();
		offerWithCustomerAccount.setOffer(offer);
		offerWithCustomerAccount.setCustomerAccount(customerAccount);
		
		Intent intentOfferView = new Intent(this, OfferView.class);	
		intentOfferView.putExtra("offerWithCustomerAccount", offerWithCustomerAccount);
		intentOfferView.putExtra("displayMessages", true);
		
		// Start the root activity within the group and get its view  
        View MyOfferView = MyMessagesGroup.myMessagesGroup.getLocalActivityManager().startActivity("My offer view",
        																			intentOfferView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        																			.getDecorView();
        
        // Replace the view of this ActivityGroup
        MyMessagesGroup.myMessagesGroup.replaceView(MyOfferView);
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