package cs.appandroid.components;

import java.util.List;

import cs.model.OfferWithCustomerAccount;

import android.content.Context;
import android.widget.ArrayAdapter;

public class CustomerOfferListAdapter extends ArrayAdapter<OfferWithCustomerAccount>
{
	public CustomerOfferListAdapter(Context context, int textViewResourceId, List<OfferWithCustomerAccount> offers)
	{
		super(context, textViewResourceId, offers);
		
		
	}
}
