package cs.appandroid.activities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cs.appandroid.components.OfferListAdapter;
import cs.appandroid.controller.IdentificationController;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.OffersWS;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class MyRoutes extends ListActivity
{
	private List<OfferWithCustomerAccount> customerOffers;
	
	//private TextView noRoutesTextView;
	private OfferListAdapter offerListAdapter;
	
	private Runnable displayMyRoutesProcess;
	private ProgressDialog displayMyRoutesProgressDialog;
	
	public static MyRoutes myRoutesGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    displayMyRoutesScreen();
	    
	    customerOffers = new ArrayList<OfferWithCustomerAccount>();
	    
	    offerListAdapter = new OfferListAdapter(this, R.layout.offerrow, customerOffers, null, null);
	    setListAdapter(offerListAdapter);
	    
	    displayMyRoutesProcess = new Runnable()
	    {	
			@Override
			public void run()
			{
				getCustomerRoutes();
			}
		};
		
		Thread displayMyRoutesThread =  new Thread(null, displayMyRoutesProcess, "LoadMyRoutesThread");
		displayMyRoutesThread.start();
		
		displayMyRoutesProgressDialog = ProgressDialog.show(MyRoutesGroup.myRoutesGroup, "Please wait", "Récupération de vos offres...", true);
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		
		OfferWithCustomerAccount offerWithCustomerAccount = (OfferWithCustomerAccount)getListAdapter().getItem(position);
		
		Intent intentOfferView = new Intent(this, OfferView.class);	
		intentOfferView.putExtra("offerWithCustomerAccount", offerWithCustomerAccount);
		
		// Start the root activity within the group and get its view  
        View MyOfferView = MyRoutesGroup.myRoutesGroup.getLocalActivityManager().startActivity("My offer view",
        																		intentOfferView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        																		.getDecorView();  
              
        // Replace the view of this ActivityGroup  
        MyRoutesGroup.myRoutesGroup.replaceView(MyOfferView);
	}
	
	public void displayMyRoutesScreen()
	{
		setContentView(R.layout.myroutes);
		
		//noRoutesTextView = (TextView)findViewById(R.id.no_routes_textview);
	}
	
	/**
	 * Retrieve the customer offers
	 */
	public void getCustomerRoutes()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		
		OffersWS offerWS = new OffersWS();
		
		try {
			customerOffers = offerWS.getSearchOffers(null, null, idCustomerAccount);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		runOnUiThread(returnCustomerOfferList);
	}
	
	/**
	 * Test if the loading customer offers is finish
	 */
	private Runnable returnCustomerOfferList = new Runnable()
	{
		@Override
        public void run()
		{
            if(customerOffers != null && customerOffers.size() > 0)
            {
                offerListAdapter.notifyDataSetChanged();
                for(int i=0; i<customerOffers.size(); i++)
                	offerListAdapter.add(customerOffers.get(i));
            }
            displayMyRoutesProgressDialog.dismiss();
            offerListAdapter.notifyDataSetChanged();
        }
    };
}
