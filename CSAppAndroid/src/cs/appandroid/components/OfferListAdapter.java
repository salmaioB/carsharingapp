package cs.appandroid.components;

import java.util.List;


import cs.appandroid.activities.R;
import cs.model.OfferWithCustomerAccount;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OfferListAdapter extends ArrayAdapter<OfferWithCustomerAccount>
{
    private List<OfferWithCustomerAccount> offersWithCustomerAccount;
	
	public OfferListAdapter(Context context, int textViewResourceId, List<OfferWithCustomerAccount> offersWithCustomerAccount)
	{
		super(context, textViewResourceId, offersWithCustomerAccount);
		this.offersWithCustomerAccount = offersWithCustomerAccount;
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
		
		OfferWithCustomerAccount offerWithCustomerAccount = offersWithCustomerAccount.get(position);
        
		if(offerWithCustomerAccount != null)
        {
//			TextView tt = (TextView)v.findViewById(R.id.toptext);
//            TextView bt = (TextView)v.findViewById(R.id.bottomtext);
//            if (tt != null)
//             tt.setText("Title: "+OfferWithCustomerAccount.getTitle());
//            
//		    if(bt != null)
//             bt.setText("Description: "+ OfferWithCustomerAccount.getDescription());
        }
		return v;
	}
}
