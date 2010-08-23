package cs.appandroid.activities;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchOffers extends ActivityGroup implements OnClickListener
{
	private EditText startingAddressEditText;
	private EditText finishingAddressEditText;
	private Button validateSearch;
	    
    private View displayOffersView;
	
    public static SearchOffers searchOffer;
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.searchoffers);
	    
	    startingAddressEditText  = (EditText)findViewById(R.id.starting_address_edittext);
	    finishingAddressEditText = (EditText)findViewById(R.id.finishing_address_edittext);
	    
	    validateSearch           = (Button)findViewById(R.id.validate_search);
	    validateSearch.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v)
	{
		if(v == validateSearch)
		{
			searchOffer = this;
			
			Intent intent = new Intent(SearchOffers.this, DisplayOffers.class);
			
			// Start the root activity within the group and get its view  
	        displayOffersView = getLocalActivityManager().startActivity("DisplayOffers", intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView();  
	              
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
