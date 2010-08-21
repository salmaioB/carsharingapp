package cs.appandroid.activities;

import java.util.ArrayList;
import java.util.List;

import cs.appandroid.components.OfferListAdapter;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.OffersWS;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class DisplayOffers extends ListActivity
{
	private OfferListAdapter offerListAdapter;
	private ProgressDialog offerSearchProgressDialog;
	
	private List<OfferWithCustomerAccount> offersWithCustomerAccount = null;
	
	private Runnable displayOffersProcess;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.displayoffers);
	    
	    offersWithCustomerAccount = new ArrayList<OfferWithCustomerAccount>();
	    
	    offerListAdapter = new OfferListAdapter(this, R.layout.offerrow, offersWithCustomerAccount);
        setListAdapter(offerListAdapter);
        
        displayOffersProcess = new Runnable()
        {	
			@Override
			public void run()
			{
				getOffers();
			}
		};
		
		Thread thread =  new Thread(null, displayOffersProcess, "SearchOrderThread");
	    thread.start();
	    offerSearchProgressDialog = ProgressDialog.show(DisplayOffers.this, "Please wait...", "Retrieving data ...", true);
	}
	
	private Runnable returnOfferList = new Runnable()
	{
		@Override
        public void run()
		{
            if(offersWithCustomerAccount != null && offersWithCustomerAccount.size() > 0)
            {
                offerListAdapter.notifyDataSetChanged();
                for(int i=0; i<offersWithCustomerAccount.size(); i++)
                	offerListAdapter.add(offersWithCustomerAccount.get(i));
            }
            offerSearchProgressDialog.dismiss();
            offerListAdapter.notifyDataSetChanged();
        }
    };
	
	/**
	 * Retrieve offer list
	 */
	private void getOffers()
	{
		String startingCity  = "Orleans";
		String finishingCity = "Paris";
		
	    OffersWS offersWS = new OffersWS();
	    offersWithCustomerAccount = offersWS.getSearchOffers(startingCity, finishingCity);
                
        runOnUiThread(returnOfferList);
	}
}
