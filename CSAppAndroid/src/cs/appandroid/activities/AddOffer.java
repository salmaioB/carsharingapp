package cs.appandroid.activities;

import java.util.Calendar;

import cs.appandroid.controller.IdentificationController;
import cs.model.CustomerAccount;
import cs.model.Offer;
import cs.model.Route;
import cs.webservice.CustomerAccountsWS;
import cs.webservice.OfferSaveWS;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddOffer extends Activity implements OnClickListener
{
	// Components define into step 1
	private EditText startingCityEditText;
	private EditText finishingCityEditText;
	private EditText dateRouteEditText;
	private Button dateRouteButton;
	private EditText timeRouteEditText;
	private Button timeRouteButton;
	private Button incrementNumberOfPassengersButton;
	private TextView numberOfPassengersTextView;
	private Button decrementNumberOfPassengersButton;
	private Button goToNextStepButton;
	
	
	// Components define into step 2
	private TextView startingAddressSummaryTextView;
	private TextView finishingAddressSummaryTextView;
	private TextView dateRouteSummaryTextView;
	private TextView numberOfPassengersSummaryTextView;
	private Button decrementPricePerPassengerButton;
	private TextView pricePerPassengerTextView;
	private Button incrementPricePerPassengerButton;
	private Button proposeOfferButton;
	
	// Components define into summary step (after save the offer)
	private TextView userNameTextView;
	private TextView offerDateAndTimeTextView;
	private TextView offerOpinionTextView;
	private TextView numberOfPassengersSummaryStepTextView;
	private TextView routeSummaryTextView;
	private TextView pricePerPassengerSummaryTextView;
	
	private int routeYear;
	private int routeMonth;
	private int routeDay;
	
	private int routeHour;
	private int routeMinute;
	
	private Offer offer;
	private Route route;
	
	private static final int DATE_ROUTE_DIALOG_ID = 0;
	private static final int TIME_ROUTE_DIALOG_ID = 1;
	 
	private Runnable addOfferProcess;
	private ProgressDialog addOfferProgressDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    offer = new Offer();
	    
	    // Default number of passengers
	    offer.setNumberOfPlaceInitial(3);
	    
	    //Default price per passenger
	    offer.setPricePerPassenger(8f);

	    route = new Route();
	    
	    displayAddOfferScreen();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
			
		Bundle params = getIntent().getExtras();
		
		if(params != null)
		{
			 if(params.containsKey("addOfferNextStep"))
				 displayAddOfferNextStepScreen();
			 else if(params.containsKey("addOfferSummaryStep"))
				 displayAddOfferSummaryScreen();
		}
		else displayAddOfferScreen();
	}

	@Override
	public void onClick(View v)
	{
		Bundle initParams = null;
		getIntent().replaceExtras(initParams);
		
		if(v == dateRouteButton)
		{
			// Get the current date
	        Calendar dateCalendar = Calendar.getInstance();
	        routeYear  			  = dateCalendar.get(Calendar.YEAR);
	        routeMonth 			  = dateCalendar.get(Calendar.MONTH);
	        routeDay   			  = dateCalendar.get(Calendar.DAY_OF_MONTH);
	        
	        showDialog(DATE_ROUTE_DIALOG_ID);
		}
		else if(v == timeRouteButton)
		{
			Calendar timeCalendar  = Calendar.getInstance();
			routeHour   		   = timeCalendar.get(Calendar.HOUR_OF_DAY);
			routeMinute 		   = timeCalendar.get(Calendar.MINUTE);
			
			showDialog(TIME_ROUTE_DIALOG_ID);
		}
		else if(v == goToNextStepButton)
		{
			// To display the "add offer" step2 screen
			getIntent().putExtra("addOfferNextStep", true);
			
			route.setStartingCity(startingCityEditText.getText().toString());
			route.setFinishingCity(finishingCityEditText.getText().toString());
			
//			getIntent().putExtra("startingAddress", startingAddressEditText.getText().toString());
//			getIntent().putExtra("finishingAddress", finishingAddressEditText.getText().toString());
			getIntent().putExtra("dateRoute", dateRouteEditText.getText().toString());
			getIntent().putExtra("timeRoute", timeRouteEditText.getText().toString());
			
			onResume();
		}
		else if(v == incrementNumberOfPassengersButton)
		{
			if(offer.getNumberOfPlaceInitial() != 6)
			{
				offer.setNumberOfPlaceInitial(offer.getNumberOfPlaceInitial()+1);
			
				numberOfPassengersTextView.setText(offer.getNumberOfPlaceInitial() + " pl.");
			}
		}
		else if(v == decrementNumberOfPassengersButton)
		{
			if(offer.getNumberOfPlaceInitial() != 1)
			{
				offer.setNumberOfPlaceInitial(offer.getNumberOfPlaceInitial()-1);
				
				numberOfPassengersTextView.setText(offer.getNumberOfPlaceInitial() + " pl.");
			}
		}
		else if(v == incrementPricePerPassengerButton)
		{
			if(offer.getPricePerPassenger() != 1f)
			{
				offer.setPricePerPassenger(offer.getPricePerPassenger()+1);
			    
				pricePerPassengerTextView.setText(offer.getPricePerPassenger() + "€");
			}
		}
		else if(v == decrementPricePerPassengerButton)
		{	
			if(offer.getPricePerPassenger() != 15f)
			{
				offer.setPricePerPassenger(offer.getPricePerPassenger()-1);
			
				pricePerPassengerTextView.setText(offer.getPricePerPassenger() + "€");
			}
		}
		else if(v == proposeOfferButton)
		{	
			addOfferProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					addOfferProcess();
				}
			};
			Thread thread =  new Thread(null, addOfferProcess, "AddOfferThread");
		    thread.start();
		    
		    addOfferProgressDialog = ProgressDialog.show(AddOffer.this, "Please wait...", "Publication de votre offre ...", true);
		}
	}
	
	@Override
	protected Dialog onCreateDialog(int dialogId)
	{
	    switch(dialogId)
	    {
	     	case DATE_ROUTE_DIALOG_ID: return new DatePickerDialog(this,
	                    									 	   routeDateSetListener,
	                    									 	   routeYear, routeMonth, routeDay);
	     	
	     	case TIME_ROUTE_DIALOG_ID: return new TimePickerDialog(this,
	     														   routeTimeSetListener,
	     														   routeHour, routeMinute, false);

	    }
	    return null;
	}
	
	public void displayAddOfferScreen()
	{
		setContentView(R.layout.addoffer);
		
		startingCityEditText  = (EditText)findViewById(R.id.starting_city_edittext);
		finishingCityEditText = (EditText)findViewById(R.id.finishing_city_edittext);
		
	    dateRouteEditText = (EditText)findViewById(R.id.date_route_edittext);
	    dateRouteButton   = (Button)findViewById(R.id.date_route_button);
	    dateRouteButton.setOnClickListener(this);
	    
	    timeRouteEditText = (EditText)findViewById(R.id.hour_route_edittext);
	    timeRouteButton   = (Button)findViewById(R.id.hour_route_button);
	    timeRouteButton.setOnClickListener(this);
	    
	    // Go to the next step (step 2)
	    goToNextStepButton = (Button)findViewById(R.id.go_to_next_step_button);
	    goToNextStepButton.setOnClickListener(this);
	    
	    incrementNumberOfPassengersButton = (Button)findViewById(R.id.increment_number_of_passenger_button);
	    incrementNumberOfPassengersButton.setOnClickListener(this);
	    
	    numberOfPassengersTextView        = (TextView)findViewById(R.id.number_of_passengers_textview);
	    
	    decrementNumberOfPassengersButton = (Button)findViewById(R.id.decrement_number_of_passenger_button);
	    decrementNumberOfPassengersButton.setOnClickListener(this);
	}
	
	public void displayAddOfferNextStepScreen()
	{
		setContentView(R.layout.addofferstep2);
		
		startingAddressSummaryTextView    = (TextView)findViewById(R.id.starting_address_summary_textview);
		finishingAddressSummaryTextView   = (TextView)findViewById(R.id.finishing_address_summary_textview);
		dateRouteSummaryTextView          = (TextView)findViewById(R.id.date_route_summary_textview);
		numberOfPassengersSummaryTextView = (TextView)findViewById(R.id.number_of_passengers_summary_textview);
		
		Bundle addOfferFirstScreen = getIntent().getExtras();
		
		String dateRoute        = addOfferFirstScreen.getString("dateRoute");
		
		startingAddressSummaryTextView.setText("Départ: " + route.getStartingCity());
		finishingAddressSummaryTextView.setText("Arrivée: " + route.getFinishingCity());
		dateRouteSummaryTextView.setText("Date: " + dateRoute);
		numberOfPassengersSummaryTextView.setText(offer.getNumberOfPlaceInitial() + " places restantes");
		
		decrementPricePerPassengerButton = (Button)findViewById(R.id.decrement_price_per_passenger_button);
		decrementPricePerPassengerButton.setOnClickListener(this);
		
		pricePerPassengerTextView        = (TextView)findViewById(R.id.price_per_passenger_textview);
		pricePerPassengerTextView.setText(offer.getPricePerPassenger() + "€");
		
		incrementPricePerPassengerButton = (Button)findViewById(R.id.increment_price_per_passenger_button);	
		incrementPricePerPassengerButton.setOnClickListener(this);
		
		proposeOfferButton = (Button)findViewById(R.id.propose_offer_button);
		proposeOfferButton.setOnClickListener(this);
	}
	
	public void displayAddOfferSummaryScreen()
	{
		setContentView(R.layout.addoffersummary);
		
		userNameTextView 		 			  = (TextView)findViewById(R.id.user_name_textview);
		
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
	
	public void addOfferProcess()
	{
		// Set an idDriver to the offer
		offer.setIdDriver(IdentificationController.getUserLoggedId(getBaseContext()));
		
		OfferSaveWS offerSaveWS = new OfferSaveWS();
		offerSaveWS.saveOfferWithRoutes(offer, route);
		
		addOfferProcessUpdateUI();
	}
	
	public void addOfferProcessUpdateUI()
	{
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
        	   addOfferProgressDialog.dismiss();
        	  
    		   // To display the "add offer" summary step screen
       		   getIntent().putExtra("addOfferSummaryStep", true);
       		   onResume();
           }
        });
	}
	
	// The callback received when the user sets the route date in the dialog
    private DatePickerDialog.OnDateSetListener routeDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
    	public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
    	{
    		routeYear = year;
    		routeMonth = monthOfYear;
    		routeDay = dayOfMonth;
    		
    		updateDateRouteDisplay();
    	}
    };
    
    // The callback received when the user sets the route time in the dialog
    private TimePickerDialog.OnTimeSetListener routeTimeSetListener = new TimePickerDialog.OnTimeSetListener()
    {
    	public void onTimeSet(TimePicker view, int hourOfDay, int minute)
    	{
    		routeHour   = hourOfDay;
    		routeMinute = minute;
    		
    		updateTimeRouteDisplay();
    	}
    };

    // Update the route date display in the TextView
    private void updateDateRouteDisplay()
    {
    	dateRouteEditText.setText(new StringBuilder()
		                     	  // Month is 0 based so add 1
		                     	  .append(routeYear + 1).append("-")
		                     	  .append(routeMonth).append("-")
		                     	  .append(routeDay));
    }
    
    // Update the route time display in the TextView
    private void updateTimeRouteDisplay()
    {
	   	timeRouteEditText.setText(new StringBuilder()
						     	  .append(routeHour).append(":")
						     	  .append(routeMinute));
    }
}
