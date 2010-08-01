package cs.appandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class OldCSAppAndroid extends Activity
{	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{	
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
        //GridView gridview = (GridView) findViewById(R.id.gridview);
        //gridview.setAdapter(new HomeMenuAdapter(this));
        
        MyCustomGridView mGrid = (MyCustomGridView) findViewById(R.id.my_custom_grid_view);
        mGrid.setListener(new ItemListener());
        mGrid.setAdapter(new HomeMenuAdapter(this));
	}

	 private class ItemListener implements MyCustomGridView.Listener
	 {
	    public void onClick(int position)
	    {
	      switch(position)
	      {
	       case 0: Intent intent = new Intent(OldCSAppAndroid.this, SearchOffers.class);
	       		   startActivity(intent);
	       		   break;
	       case 1: Intent intent2 = new Intent(OldCSAppAndroid.this, AddOffer.class);
		           startActivity(intent2);
		           break;
	       case 3: Intent intent3 = new Intent(OldCSAppAndroid.this, MyMessages.class);
                   startActivity(intent3);
	    	       break;
	       default: break;
	      }
	    }
	 }
}