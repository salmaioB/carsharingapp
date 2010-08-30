package cs.appandroid.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cs.appandroid.activities.R;
import cs.model.OfferWithCustomerAccount;


public class OfferRowView
{
	private static ImageView customerGenderImageView;
	private static TextView customerFullNameTextView;
	private static TextView customerDriverInfosTextView;
	private static TextView customerOpinionTextView;
	
	private static TextView offerDateTimeStartedTextView;
	private static TextView offerNumberOfPlaceRemainingTextView;
	private static TextView offerPricePerPassengerTextView;
	private static TextView offerStartingCityTextView;
	private static TextView offerFinishingCityTextView;
	
	
	public static void displayOfferRow(View offerRowView, OfferWithCustomerAccount offerWithCustomerAccount, String startingCity, String finishingCity)
	{
		// Get list adapter components
		customerGenderImageView    			= (ImageView)offerRowView.findViewById(R.id.customer_gender_imageview);
		customerFullNameTextView       		= (TextView)offerRowView.findViewById(R.id.customer_full_name_textview);
		customerDriverInfosTextView         = (TextView)offerRowView.findViewById(R.id.customer_driver_infos_textview);
		customerOpinionTextView 			= (TextView)offerRowView.findViewById(R.id.customer_opinion_textview);
		
		offerDateTimeStartedTextView        = (TextView)offerRowView.findViewById(R.id.offer_datetime_started_textview);
		offerNumberOfPlaceRemainingTextView = (TextView)offerRowView.findViewById(R.id.offer_number_of_place_remaining_textview);
		offerPricePerPassengerTextView 		= (TextView)offerRowView.findViewById(R.id.offer_price_per_passenger_textview);
		offerStartingCityTextView           = (TextView)offerRowView.findViewById(R.id.offer_starting_city_textview);
		offerFinishingCityTextView          = (TextView)offerRowView.findViewById(R.id.offer_finishing_city_textview);
		
		if(offerWithCustomerAccount != null)
        {
			// Display offer infos into components
			if(offerWithCustomerAccount.getCustomerAccount().getGender() == 0)
			{
				customerGenderImageView.setImageResource(R.drawable.icon_customer_woman);
				customerDriverInfosTextView.setText("Conductrice");
			}
			else if(offerWithCustomerAccount.getCustomerAccount().getGender() == 1)
			{
				customerGenderImageView.setImageResource(R.drawable.icon_customer_man);
				customerDriverInfosTextView.setText("Conducteur");
			}
		    
			String lastName = offerWithCustomerAccount.getCustomerAccount().getLastName().substring(0,1);
			customerFullNameTextView.setText(offerWithCustomerAccount.getCustomerAccount().getFirstName() + " " + lastName + ".");
			
			customerOpinionTextView.setText("pas d'avis");
			
			//offerDateTimeStartedTextView.setText(offerWithCustomerAccount.getOffer().getDatetimeStartedToDisplay());
			
			switch(offerWithCustomerAccount.getOffer().getNumberOfPlaceRemaining())
			{
				case 0:  offerNumberOfPlaceRemainingTextView.setText("complet");
						 break;
				case 1:  offerNumberOfPlaceRemainingTextView.setText(offerWithCustomerAccount.getOffer().getNumberOfPlaceRemaining() + " pl. restante");
						 break;
				default: offerNumberOfPlaceRemainingTextView.setText(offerWithCustomerAccount.getOffer().getNumberOfPlaceRemaining() + " pl. restantes");
				         break;
			}
			
			offerPricePerPassengerTextView.setText("Prix par pers.: " + offerWithCustomerAccount.getOffer().getPricePerPassenger().toString() + "€");
            
			if(startingCity != null && finishingCity != null)
			{
				offerStartingCityTextView.setText(startingCity);
				offerFinishingCityTextView.setText(finishingCity);
			}
			else
			{
				offerStartingCityTextView.setText(offerWithCustomerAccount.getOffer().getStartingCity());
				offerFinishingCityTextView.setText(offerWithCustomerAccount.getOffer().getFinishingCity());
			}
        }
	}
}
