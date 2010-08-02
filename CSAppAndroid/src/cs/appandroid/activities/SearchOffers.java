package cs.appandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchOffers extends Activity implements OnClickListener
{
	private EditText startingAddressEditText;
	private EditText finishingAddressEditText;
	private Button validateSearch;
	
	
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
			Log.v("azaz", "aaaaa");
			Intent intent = new Intent(SearchOffers.this, DisplayOffers.class);
			startActivity(intent);
		}
	}
}
