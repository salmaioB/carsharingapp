package cs.appandroid.activities;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchOffersGroup extends ActivityGroup implements OnClickListener
{
	private EditText startingCityEditText;
	private EditText finishingCityEditText;
	private Button validateSearch;
	    
    private View displayOffersView;
	
    public static SearchOffersGroup searchOffersGroup;
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.searchoffers);
	    
	    startingCityEditText  = (EditText)findViewById(R.id.starting_city_edittext);
	    finishingCityEditText = (EditText)findViewById(R.id.finishing_city_edittext);
	    
	    validateSearch           = (Button)findViewById(R.id.validate_search);
	    validateSearch.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v)
	{
		if(v == validateSearch)
		{
			searchOffersGroup = this;
			
			Intent intent = new Intent(SearchOffersGroup.this, DisplayOffers.class);
			intent.putExtra("startingCity", startingCityEditText.getText().toString());
			intent.putExtra("finishingCity", finishingCityEditText.getText().toString());
			
			// Start the root activity within the group and get its view  
	        displayOffersView = getLocalActivityManager().startActivity("DisplayOffers",
	        		                                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
	        		                                     .getDecorView();  
	              
	        // Replace the view of this ActivityGroup  
	        replaceView(displayOffersView);
		}
	}
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		//history.add(v);  
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
}
