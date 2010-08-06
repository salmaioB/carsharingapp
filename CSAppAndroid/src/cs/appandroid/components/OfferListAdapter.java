package cs.appandroid.components;

import java.util.List;


import cs.appandroid.activities.R;
import cs.model.Offer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OfferListAdapter extends ArrayAdapter<Offer>
{
    private List<Offer> offers;
	
	public OfferListAdapter(Context context, int textViewResourceId, List<Offer> offers) {
		super(context, textViewResourceId, offers);
		this.offers = offers;
	}
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View v = convertView;
		
		if(v == null)
		{
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.offerrow, null);
		}
		
		Log.v("azezeaze", "qqqqqqqqqqqqqq");
		
		Offer offer = offers.get(position);
        
		if(offer != null)
        {
			TextView tt = (TextView)v.findViewById(R.id.toptext);
            TextView bt = (TextView)v.findViewById(R.id.bottomtext);
            if (tt != null)
             tt.setText("Title: "+offer.getTitle());
            
		    if(bt != null)
             bt.setText("Description: "+ offer.getDescription());
        }
		return v;
	}
}
