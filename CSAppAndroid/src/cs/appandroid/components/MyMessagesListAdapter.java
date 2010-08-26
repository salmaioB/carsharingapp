package cs.appandroid.components;

import java.util.List;

import cs.appandroid.activities.R;
import cs.appandroid.view.OfferRowWithMessageAndCustomerAccountView;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;
import cs.model.OfferWithCustomerAccount;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class MyMessagesListAdapter extends ArrayAdapter<CustomerOfferWithMessageAndCustomerAccount>
{
	private List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount;
	
	
	public MyMessagesListAdapter(Context context, int textViewResourceId, List<CustomerOfferWithMessageAndCustomerAccount> customerOffersWithMessageAndCustomerAccount)
	{
		super(context, textViewResourceId, customerOffersWithMessageAndCustomerAccount);
		
		this.customerOffersWithMessageAndCustomerAccount = customerOffersWithMessageAndCustomerAccount;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View CustomerOfferWithMessage = convertView;
		
		if(CustomerOfferWithMessage == null)
		{
			LayoutInflater layoutInflater   = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			CustomerOfferWithMessage = layoutInflater.inflate(R.layout.messagerow, null);
		}
		
		CustomerOfferWithMessageAndCustomerAccount customerOfferWithMessageAndCustomerAccount = customerOffersWithMessageAndCustomerAccount.get(position);
		
		OfferRowWithMessageAndCustomerAccountView.displayOfferRowWithMessageAndCustomerAccount(CustomerOfferWithMessage, customerOfferWithMessageAndCustomerAccount);
		
		return CustomerOfferWithMessage;
	}
}
