package cs.appandroid.components;

import java.util.List;

import cs.appandroid.activities.R;
import cs.appandroid.view.OfferRowView;
import cs.model.OfferWithCustomerAccount;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class OfferListAdapter extends ArrayAdapter<OfferWithCustomerAccount>
{
	private String startingCity;
	private String finishingCity;
    private List<OfferWithCustomerAccount> offersWithCustomerAccount;
    
    
	public OfferListAdapter(Context context, int textViewResourceId, List<OfferWithCustomerAccount> offersWithCustomerAccount, String startingCity, String finishingCity)
	{
		super(context, textViewResourceId, offersWithCustomerAccount);
		this.startingCity  = startingCity;
		this.finishingCity = finishingCity;
		this.offersWithCustomerAccount = offersWithCustomerAccount;
	}
		
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View offerRowView = convertView;
		
		if(offerRowView == null)
		{
			LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			offerRowView      			  = layoutInflater.inflate(R.layout.offerrow, null);
		}
		
		OfferWithCustomerAccount offerWithCustomerAccount = offersWithCustomerAccount.get(position);
		OfferRowView.displayOfferRow(offerRowView, offerWithCustomerAccount, startingCity, finishingCity);
		
		return offerRowView;
	}
}
