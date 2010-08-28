package cs.appandroid.activities;

import java.util.ArrayList;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    
    private ArrayList<View> history;
    
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.searchoffers);
	    
	    startingCityEditText  = (EditText)findViewById(R.id.starting_city_edittext);
	    finishingCityEditText = (EditText)findViewById(R.id.finishing_city_edittext);
	    
	    validateSearch           = (Button)findViewById(R.id.validate_search);
	    validateSearch.setOnClickListener(this);
	    
	    history = new ArrayList<View>();
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
	
    @Override  
    public void onBackPressed()
    {  
        SearchOffersGroup.searchOffersGroup.back();  
        return;  
    }
	
	public void replaceView(View v)
	{  
        // Adds the old one to history  
		history.add(v);  
        // Changes this Groups View to the new View.  
		setContentView(v);
	}
	
	public void back()
	{  
        if(history.size() > 0)
        {
            history.remove(history.size()-1);
            
            if(history.size() > 1)
             setContentView(history.get(history.size()-1));
            else
             setContentView(R.layout.searchoffers);
        }
        else finish();
    }
}
