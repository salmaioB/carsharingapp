package cs.appandroid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs.model.Offer;
import cs.webservice.OffersWS;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

public class DisplayOffers extends ListActivity
{
	private OfferListAdapter offerListAdapter;
	private ProgressDialog offerSearchProgressDialog;
	
	private List<Offer> offers = null;
	
	private Runnable displayOffersProcess;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.displayoffers);
	    
	    //Bundle bun = getIntent().getExtras();
	    //String test = bun.getString("az");
	    
	    offers = new ArrayList<Offer>();
	    
	    offerListAdapter = new OfferListAdapter(this, R.layout.offerrow, offers);
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
            if(offers != null && offers.size() > 0)
            {
                offerListAdapter.notifyDataSetChanged();
                for(int i=0; i<offers.size(); i++)
                	offerListAdapter.add(offers.get(i));
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
	    OffersWS offersWS = new OffersWS();
        offers = offersWS.getSearchOffers();
                
        runOnUiThread(returnOfferList);
	}
}
