package cs.appandroid.activities;

import cs.appandroid.activitiesgroup.AddOfferGroup;
import cs.appandroid.controller.IdentificationController;
import cs.model.Offer;
import cs.model.Route;
import cs.webservice.OfferSaveWS;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddOfferSecondStep extends Activity implements OnClickListener
{
	private TextView startingAddressSummaryTextView;
	private TextView finishingAddressSummaryTextView;
	private TextView dateRouteSummaryTextView;
	private TextView numberOfPassengersSummaryTextView;
	private Button decrementPricePerPassengerButton;
	private TextView pricePerPassengerTextView;
	private Button incrementPricePerPassengerButton;
	private EditText descriptionEditText;
	private Button proposeOfferButton;
	
	private Runnable addOfferProcess;
	private ProgressDialog addOfferProgressDialog;
	
	private Offer offer;
	private Route route;
	
	Intent intentAddOfferSummary;
	private View addOfferSummaryView;
	
	
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
	    
		//Default price per passenger
	    offer.setPricePerPassenger(8f);
		
	    displayAddOfferSecondStep();
	    
	    intentAddOfferSummary = new Intent(this, AddOfferSummary.class);
	}
	
	public void displayAddOfferSecondStep()
	{
		setContentView(R.layout.addoffersecondstep);
		
		startingAddressSummaryTextView    = (TextView)findViewById(R.id.starting_address_summary_textview);
		finishingAddressSummaryTextView   = (TextView)findViewById(R.id.finishing_address_summary_textview);
		dateRouteSummaryTextView          = (TextView)findViewById(R.id.date_route_summary_textview);
		numberOfPassengersSummaryTextView = (TextView)findViewById(R.id.number_of_passengers_summary_textview);
				
		//String dateRoute = addOfferSecondStepExtras.getString("dateRoute");
		
		startingAddressSummaryTextView.setText("Départ: " + offer.getStartingCity());
		finishingAddressSummaryTextView.setText("Arrivée: " + offer.getFinishingCity());
		//dateRouteSummaryTextView.setText("Date: " + dateRoute);
		numberOfPassengersSummaryTextView.setText(offer.getNumberOfPlaceInitial() + " places restantes");
		
		decrementPricePerPassengerButton = (Button)findViewById(R.id.decrement_price_per_passenger_button);
		decrementPricePerPassengerButton.setOnClickListener(this);
		
		pricePerPassengerTextView        = (TextView)findViewById(R.id.price_per_passenger_textview);
		pricePerPassengerTextView.setText(offer.getPricePerPassenger().intValue() + " €");
		
		incrementPricePerPassengerButton = (Button)findViewById(R.id.increment_price_per_passenger_button);	
		incrementPricePerPassengerButton.setOnClickListener(this);
		
		descriptionEditText              = (EditText)findViewById(R.id.description_edittext);
		
		proposeOfferButton = (Button)findViewById(R.id.propose_offer_button);
		proposeOfferButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		if(v == proposeOfferButton)
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
		    
		    addOfferProgressDialog = ProgressDialog.show(AddOfferGroup.addOfferGroup, "Please wait...", "Publication de votre offre ...", true);
		}
		else if(v == incrementPricePerPassengerButton)
		{
			if(offer.getPricePerPassenger() != 15)
            {
				offer.setPricePerPassenger(offer.getPricePerPassenger()+1);
				pricePerPassengerTextView.setText(offer.getPricePerPassenger().intValue() + " €");
            }
		}
		else if(v == decrementPricePerPassengerButton)
        {       
                if(offer.getPricePerPassenger() != 1)
                {
                	offer.setPricePerPassenger(offer.getPricePerPassenger()-1);
                	pricePerPassengerTextView.setText(offer.getPricePerPassenger().intValue() + " €");
                }
        }
	}
	
	public void addOfferProcess()
	{
		Integer idCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
		offer.setDescription(descriptionEditText.getText().toString());
		
		OfferSaveWS offerSaveWS = new OfferSaveWS();
		offerSaveWS.saveOfferWithRoutes(offer, route, idCustomerAccount, 1);
		
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
   			   
        	   intentAddOfferSummary.putExtra("offer", offer);
        	   intentAddOfferSummary.putExtra("route", route);
        	   
   			   // Start the root activity within the group and get its view  
   			   addOfferSummaryView = AddOfferGroup.addOfferGroup.getLocalActivityManager().startActivity("Add offer summary",
   					   												 					  intentAddOfferSummary.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
   					   												 					  .getDecorView();
   			   
	   	       // Replace the view of this ActivityGroup
	   	       AddOfferGroup.addOfferGroup.replaceView(addOfferSummaryView);
           }
        });
	}
}
