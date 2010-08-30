package cs.appandroid.activitiesgroup;

import java.util.ArrayList;
import java.util.Calendar;

import cs.appandroid.activities.AddOfferSecondStep;
import cs.appandroid.activities.R;
import cs.model.Offer;
import cs.model.Route;

import android.app.ActivityGroup;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


public class AddOfferGroup extends ActivityGroup implements OnClickListener
{
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
	
	private int routeYear;
	private int routeMonth;
	private int routeDay;
	
	private int routeHour;
	private int routeMinute;
	
	private Offer offer;
	private Route route;
	
	private static final int DATE_ROUTE_DIALOG_ID = 0;
	private static final int TIME_ROUTE_DIALOG_ID = 1;
	
	private View addOfferSecondStepView;
	
	public static AddOfferGroup addOfferGroup;
	public ArrayList<View> historyAddOfferGroup;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    offer = new Offer();
	    
	    // Default number of passengers
	    offer.setNumberOfPlaceInitial(3);

	    route = new Route();
	    
	    displayAddOffer();
	    
	    historyAddOfferGroup = new ArrayList<View>();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
			
		displayAddOffer();
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
			addOfferGroup = this;
			
			offer.setStartingCity(startingCityEditText.getText().toString());
			offer.setFinishingCity(finishingCityEditText.getText().toString());
			
			route.setStartingCity(startingCityEditText.getText().toString());
			route.setFinishingCity(finishingCityEditText.getText().toString());
			
			Intent intentAddOfferSecondStep = new Intent(AddOfferGroup.this, AddOfferSecondStep.class);
			intentAddOfferSecondStep.putExtra("offer", offer);
			intentAddOfferSecondStep.putExtra("route", route);
			
			// Start the root activity within the group and get its view  
	        addOfferSecondStepView = getLocalActivityManager().startActivity("Add offer second step",
	        												  intentAddOfferSecondStep.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	        		                                     	  .getDecorView();
	        
	        // Replace the view of this ActivityGroup  
	        replaceView(addOfferSecondStepView);
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
	
    @Override  
    public void onBackPressed()
    {
        AddOfferGroup.addOfferGroup.back();        
        return;  
    }
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		historyAddOfferGroup.add(v);
		
        // Changes this Groups View to the new View.	
		setContentView(v);
	}
	
	public void back()
	{  
        if(historyAddOfferGroup.size() > 0)
        {
        	historyAddOfferGroup.remove(historyAddOfferGroup.size()-1);
            
            if(historyAddOfferGroup.size() > 0)
            	setContentView(historyAddOfferGroup.get(historyAddOfferGroup.size()-1));
            else
            	AddOfferGroup.addOfferGroup.onResume();
        }
        else finish();
    }
	
	public void displayAddOffer()
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
