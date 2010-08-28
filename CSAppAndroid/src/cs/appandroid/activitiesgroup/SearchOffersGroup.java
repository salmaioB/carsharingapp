package cs.appandroid.activitiesgroup;

import java.util.ArrayList;

import cs.appandroid.activities.DisplayOffers;
import cs.appandroid.activities.R;

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
    private String historyStartingCity;
    private String historyFinishingCity;
    private ArrayList<View> historySearchOffersGroup;
    
    
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.searchoffers);
	    
	    getSearchOffersViewComponents();
	    
	    historySearchOffersGroup = new ArrayList<View>();
	}
	
	@Override
	public void onResume()
	{
		super.onResume();
		setContentView(R.layout.searchoffers);
		
	    getSearchOffersViewComponents();
	    
	    // To show the previous search
	    startingCityEditText.setText(historyStartingCity);
	    finishingCityEditText.setText(historyFinishingCity);
	}

	@Override
	public void onClick(View v)
	{
		if(v == validateSearch)
		{	
			searchOffersGroup    = this;
			
			historyStartingCity  = startingCityEditText.getText().toString();
			historyFinishingCity = finishingCityEditText.getText().toString();
			
			Intent intent = new Intent(SearchOffersGroup.this, DisplayOffers.class);
			intent.putExtra("startingCity", historyStartingCity);
			intent.putExtra("finishingCity", historyFinishingCity);
			
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
		historySearchOffersGroup.add(v);  
        // Changes this Groups View to the new View.
		
		Log.v("tata", "tata");
		
		setContentView(v);
	}
	
	public void back()
	{  
        if(historySearchOffersGroup.size() > 0)
        {
        	historySearchOffersGroup.remove(historySearchOffersGroup.size()-1);
            
            if(historySearchOffersGroup.size() > 0)
            	setContentView(historySearchOffersGroup.get(historySearchOffersGroup.size()-1));
            else
            	SearchOffersGroup.searchOffersGroup.onResume();
        }
        else finish();
    }
	
	public void getSearchOffersViewComponents()
	{
	    startingCityEditText  = (EditText)findViewById(R.id.starting_city_edittext);
	    finishingCityEditText = (EditText)findViewById(R.id.finishing_city_edittext);
	    
	    validateSearch        = (Button)findViewById(R.id.validate_search);
	    validateSearch.setOnClickListener(this);
	}
}
