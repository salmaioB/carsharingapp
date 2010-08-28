package cs.appandroid.activities;

import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.model.Offer;
import cs.model.Route;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AddOfferSummary extends Activity
{
	private TextView userNameTextView;
	private TextView offerDateAndTimeTextView;
	private TextView offerOpinionTextView;
	private TextView numberOfPassengersSummaryStepTextView;
	private TextView routeSummaryTextView;
	private TextView pricePerPassengerSummaryTextView;
	
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
	    offerDateAndTimeTextView.setText("blabla");
		
		// Display the offer opinion
		offerOpinionTextView     		      = (TextView)findViewById(R.id.offer_opinion_textview);		
		offerOpinionTextView.setText("Pas encore d'avis (to develop)");
		
		// Display number of passengers
		numberOfPassengersSummaryStepTextView = (TextView)findViewById(R.id.number_of_passengers_summary_step_textview);		
		numberOfPassengersSummaryStepTextView.setText(offer.getNumberOfPlaceInitial() + "pl. restantes");
		
		// Display the itinerary
		routeSummaryTextView				  = (TextView)findViewById(R.id.route_summary_textview);
		routeSummaryTextView.setText(route.getStartingCity() + " -> " + route.getFinishingCity());
		
		// Display the price per passenger
		pricePerPassengerSummaryTextView	  = (TextView)findViewById(R.id.price_per_passenger_summary_textview);
		pricePerPassengerSummaryTextView.setText("Prix par pers.: " + offer.getPricePerPassenger().toString());
	}
}
