package cs.appandroid.activities;

import cs.appandroid.view.OfferRowView;
import cs.model.CustomerAccount;
import cs.model.Offer;
import cs.model.OfferWithCustomerAccount;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;


public class OfferMessagesView extends Activity
{
	private Offer offer;
	private CustomerAccount customerAccount;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    // Retrieve offer data
        Bundle offerViewExtras = getIntent().getExtras();
        
        if(offerViewExtras.containsKey("offer"))
        	offer = (Offer)offerViewExtras.getSerializable("offer");
        
        if(offerViewExtras.containsKey("customerAccount"))
        	customerAccount = (CustomerAccount)offerViewExtras.getSerializable("customerAccount");
        
        OfferWithCustomerAccount offerWithCustomerAccount = new OfferWithCustomerAccount();
        offerWithCustomerAccount.setOffer(offer);
        offerWithCustomerAccount.setCustomerAccount(customerAccount);
        
        Log.v("idOffer: ", offerWithCustomerAccount.getOffer().getId().toString());
        
        LinearLayout offerMessagesViewLayout = new LinearLayout(this);
        offerMessagesViewLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        offerMessagesViewLayout.setOrientation(LinearLayout.VERTICAL);
	    
	    // Display the route TextView
	    TextView theRouteTextView = new TextView(this);
	    theRouteTextView.setText("Le trajet");
	    theRouteTextView.setGravity(Gravity.LEFT);
	    
	    offerMessagesViewLayout.addView(theRouteTextView);
	    
	    // Display the selected offer
	    LayoutInflater offerViewlayoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View offerMessagesView = offerViewlayoutInflater.inflate(R.layout.offerrow, null);
        
        OfferRowView.displayOfferRow(offerMessagesView, offerWithCustomerAccount, null, null);
        
        offerMessagesViewLayout.addView(offerMessagesView);
        
        setContentView(offerMessagesViewLayout);
	}
}
