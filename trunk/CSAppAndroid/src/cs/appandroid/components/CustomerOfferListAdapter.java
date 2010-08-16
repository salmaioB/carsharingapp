package cs.appandroid.components;

import java.util.List;

import cs.model.Offer;

import android.content.Context;
import android.widget.ArrayAdapter;

public class CustomerOfferListAdapter extends ArrayAdapter<Offer>
{
	public CustomerOfferListAdapter(Context context, int textViewResourceId, List<Offer> offers)
	{
		super(context, textViewResourceId, offers);
		
		
	}
}
