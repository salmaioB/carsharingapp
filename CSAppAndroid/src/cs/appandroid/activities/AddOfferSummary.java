package cs.appandroid.activities;

import cs.appandroid.activitiesgroup.AddOfferGroup;
import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.model.Offer;
import cs.model.Route;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AddOfferSummary extends Activity implements OnClickListener
{
	private TextView userNameTextView;
	private TextView offerDateAndTimeTextView;
	private TextView offerOpinionTextView;
	private TextView numberOfPassengersSummaryStepTextView;
	private TextView routeSummaryTextView;
	private TextView pricePerPassengerSummaryTextView;
	private Button displayAddedOfferButton;
	
	private View offerView;
	
	private Offer offer;
	private Route route;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    // Init the objects
	    offer = new Offer();
	    route = new Route();
	    
	    // Retrieve the "new offer" infos
		Bundle addOfferSecondStepExtras = getIntent().getExtras();
		
		if(addOfferSecondStepExtras.containsKey("offer"))
			offer = (Offer)addOfferSecondStepExtras.getSerializable("offer");
		
		if(addOfferSecondStepExtras.containsKey("route"))
			route = (Route)addOfferSecondStepExtras.getSerializable("route");
	    
	    displayAddOfferSummary();
	}
	
	public void displayAddOfferSummary()
	{
		setContentView(R.layout.addoffersummary);
		
		userNameTextView = (TextView)findViewById(R.id.user_name_textview);
		
		// Retrieve the id customer account
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		
		CustomerAccountsWS customerAccountsWS = new CustomerAccountsWS();
		CustomerAccount customerAccount = customerAccountsWS.getCustomerAccount(idCustomerAccount);
		
		// Display the user name
		String userFullName = customerAccount.getFirstName() + " " + customerAccount.getLastName();
		userNameTextView.setText(userFullName);
		
		offerDateAndTimeTextView 			  = (TextView)findViewById(R.id.offer_date_and_time_textview);
	    //offerDateAndTimeTextView.setText("blabla");
		
		// Display the offer opinion
		offerOpinionTextView     		      = (TextView)findViewById(R.id.offer_opinion_textview);		
		offerOpinionTextView.setText("Pas encore d'avis");
		
		// Display number of passengers
		numberOfPassengersSummaryStepTextView = (TextView)findViewById(R.id.number_of_passengers_summary_step_textview);		
		numberOfPassengersSummaryStepTextView.setText(offer.getNumberOfPlaceInitial() + "pl. restantes");
		
		// Display the itinerary
		routeSummaryTextView				  = (TextView)findViewById(R.id.route_summary_textview);
		routeSummaryTextView.setText(route.getStartingCity() + " -> " + route.getFinishingCity());
		
		// Display the price per passenger
		pricePerPassengerSummaryTextView	  = (TextView)findViewById(R.id.price_per_passenger_summary_textview);
		pricePerPassengerSummaryTextView.setText("Prix par pers.: " + offer.getPricePerPassenger().toString());
	
//		displayAddedOfferButton				  = (Button)findViewById(R.id.display_added_offer_button);
//		displayAddedOfferButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
//		if(v == displayAddedOfferButton)
//		{
//			Intent intentOfferView = new Intent(this, OfferView.class);
//
//			intentOfferView.putExtra("offerWithCustomerAccount", offerWithCustomerAccount);
//			intentOfferView.putExtra("myOffers", true);
//			
//			// Start the root activity within the group and get its view  
//	        offerView = AddOfferGroup.addOfferGroup.getLocalActivityManager().startActivity("Offer view",
//	        												                              intentOfferView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//	        												                              .getDecorView();
//	        
//	        // Replace the view of this ActivityGroup  
//	        AddOfferGroup.addOfferGroup.replaceView(offerView);
//		}
	}
}
