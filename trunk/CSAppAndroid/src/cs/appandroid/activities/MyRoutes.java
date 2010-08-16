package cs.appandroid.activities;

import java.util.ArrayList;
import java.util.List;

import cs.appandroid.components.CustomerOfferListAdapter;
import cs.model.Offer;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

public class MyRoutes extends ListActivity
{
	private List<Offer> customerOffers;
	
	private TextView noRoutesTextView;
	private CustomerOfferListAdapter customerOfferListAdapter;
	
	private Runnable displayMyRoutesProcess;
	private ProgressDialog displayMyRoutesProgressDialog;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    displayMyRoutesScreen();
	    
	    customerOffers = new ArrayList<Offer>();
	    
	    customerOfferListAdapter = new CustomerOfferListAdapter(this, R.layout.customerofferrow, customerOffers);
        setListAdapter(customerOfferListAdapter);
	    
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
		
		displayMyRoutesProgressDialog = ProgressDialog.show(MyRoutes.this, "Please wait", "Récupération de vos offres...", true);
	}
	
	public void displayMyRoutesScreen()
	{
		setContentView(R.layout.myroutes);
		
		noRoutesTextView = (TextView)findViewById(R.id.no_routes_textview);
	}
	
	/**
	 * Retrieve the customer offers
	 */
	public void getCustomerRoutes()
	{
//		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
//		
//		OffersWS offerWS = new OffersWS();
		//List<Offer> customerOffers = offerWS.getCustomerOffers(idCustomerAccount);
		
		//return customerOffers;
		
		customerOffers = null;
		
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
                customerOfferListAdapter.notifyDataSetChanged();
                for(int i=0; i<customerOffers.size(); i++)
                	customerOfferListAdapter.add(customerOffers.get(i));
            }
            displayMyRoutesProgressDialog.dismiss();
            customerOfferListAdapter.notifyDataSetChanged();
        }
    };
}
