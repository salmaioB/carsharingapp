package cs.appandroid.activities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cs.appandroid.components.OfferListAdapter;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.OffersWS;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class DisplayOffers extends ListActivity
{
	private OfferListAdapter offerListAdapter;
	private ProgressDialog offerSearchProgressDialog;
	
	private String startingCity;
	private String finishingCity;
	private List<OfferWithCustomerAccount> offersWithCustomerAccount = null;
	
	private Runnable displayOffersProcess;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.displayoffers);
	    
	    Bundle displayOffersExtras = getIntent().getExtras();
	    
	    if(displayOffersExtras.containsKey("startingCity") && displayOffersExtras.containsKey("finishingCity"))
	    {
	    	startingCity  = displayOffersExtras.getString("startingCity");
	    	finishingCity = displayOffersExtras.getString("finishingCity");
	    }

	    offersWithCustomerAccount = new ArrayList<OfferWithCustomerAccount>();
	    
	    offerListAdapter = new OfferListAdapter(this, R.layout.offerrow, offersWithCustomerAccount, startingCity, finishingCity);	    
	    setListAdapter(offerListAdapter);
        
        displayOffersProcess = new Runnable()
        {	
			@Override
			public void run()
			{
				getOffers();				
			}
		};
		
		Thread thread =  new Thread(null, displayOffersProcess, "DisplayOfferThread");
	    thread.start();
	    
	    offerSearchProgressDialog = ProgressDialog.show(SearchOffersGroup.searchOffersGroup, "Please wait...", "Display offers...");
	}
	
	@Override
    protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
		
		OfferWithCustomerAccount offerWithCustomerAccount = (OfferWithCustomerAccount)getListAdapter().getItem(position);
		
		Intent intentOfferView = new Intent(this, OfferView.class);	
		intentOfferView.putExtra("offerWithCustomerAccount", offerWithCustomerAccount);
		intentOfferView.putExtra("startingCity", startingCity);
		intentOfferView.putExtra("finishingCity", finishingCity);
		
		View offerView = SearchOffersGroup.searchOffersGroup.getLocalActivityManager()
													   		.startActivity("Offer view",
													   		intentOfferView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))  
													   		.getDecorView(); 
		
		SearchOffersGroup.searchOffersGroup.replaceView(offerView);
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
	 * @throws ParseException 
	 */
	private void getOffers()
	{
	    OffersWS offersWS = new OffersWS();
	    try {
			offersWithCustomerAccount = offersWS.getSearchOffers(startingCity, finishingCity, null);
		}
	    catch (ParseException e) {
			e.printStackTrace();
		}
        
        runOnUiThread(returnOfferList);
	}
}
