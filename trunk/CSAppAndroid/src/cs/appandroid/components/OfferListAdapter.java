package cs.appandroid.components;

import java.util.List;
import java.util.StringTokenizer;


import cs.appandroid.activities.R;
import cs.model.OfferWithCustomerAccount;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OfferListAdapter extends ArrayAdapter<OfferWithCustomerAccount>
{
	private String startingCity;
	private String finishingCity;
    private List<OfferWithCustomerAccount> offersWithCustomerAccount;
	
    private ImageView customerGenderImageView;
    private TextView customerFullNameTextView;
    private TextView customerDriverInfosTextView;
    
    private TextView offerDateTimeStartedTextView;
    private TextView offerNumberOfPlaceRemainingTextView;
    private TextView offerPricePerPassengerTextView;

    private TextView offerStartingCityTextView;
    private TextView offerFinishingCityTextView;
    
    
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
		View v = convertView;
		
		if(v == null)
		{
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.offerrow, null);
		}
		
		OfferWithCustomerAccount offerWithCustomerAccount = offersWithCustomerAccount.get(position);
        
		if(offerWithCustomerAccount != null)
        {
			// Get list adapter components
			customerGenderImageView    			= (ImageView)v.findViewById(R.id.customer_gender_imageview);
			customerFullNameTextView       		= (TextView)v.findViewById(R.id.customer_full_name_textview);
			customerDriverInfosTextView         = (TextView)v.findViewById(R.id.customer_driver_infos_textview);
			
			offerDateTimeStartedTextView        = (TextView)v.findViewById(R.id.offer_datetime_started_textview);
			offerNumberOfPlaceRemainingTextView = (TextView)v.findViewById(R.id.offer_number_of_place_remaining_textview);
			offerPricePerPassengerTextView 		= (TextView)v.findViewById(R.id.offer_price_per_passenger_textview);
			
			offerStartingCityTextView           = (TextView)v.findViewById(R.id.offer_starting_city_textview);
			offerFinishingCityTextView          = (TextView)v.findViewById(R.id.offer_finishing_city_textview);
			
			
			// Display offer infos into components
			if(offerWithCustomerAccount.getGender() == 0)
			{
				customerGenderImageView.setImageResource(R.drawable.icon_customer_woman);
				customerDriverInfosTextView.setText("Conductrice");
			}
			else if(offerWithCustomerAccount.getGender() == 1)
			{
				customerGenderImageView.setImageResource(R.drawable.icon_customer_man);
				customerDriverInfosTextView.setText("Conducteur");
			}
		    
			String lastName = offerWithCustomerAccount.getLastName().substring(0,1);
			customerFullNameTextView.setText(offerWithCustomerAccount.getFirstName() + " " + lastName + ".");
		    
//			offerDateTimeStartedTextView.setText(offerWithCustomerAccount.getDatetimeStarted().toString());
			
			switch(offerWithCustomerAccount.getNumberOfPlaceRemaining())
			{
				case 0:  offerNumberOfPlaceRemainingTextView.setText("complet");
						 break;
				case 1:  offerNumberOfPlaceRemainingTextView.setText(offerWithCustomerAccount.getNumberOfPlaceRemaining() + " pl. restante");
						 break;
				default: offerNumberOfPlaceRemainingTextView.setText(offerWithCustomerAccount.getNumberOfPlaceRemaining() + " pl. restantes");
				         break;
			}
			
			offerPricePerPassengerTextView.setText("Prix par pers.: " + offerWithCustomerAccount.getPricePerPassenger().toString() + "€");
        
            offerStartingCityTextView.setText(startingCity);
            offerFinishingCityTextView.setText(finishingCity);
        }
		return v;
	}
}
