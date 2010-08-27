package cs.appandroid.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cs.appandroid.activities.R;
import cs.model.CustomerOfferWithMessageAndCustomerAccount;


public class OfferRowWithMessageAndCustomerAccountView
{
	private static ImageView customerTransmitterGenderImageview;
	private static TextView routeFullNameTextview;
	private static TextView customerTransmitterFullNameTextview;
	
	
	public static void displayOfferRowWithMessageAndCustomerAccount(View offerRowWithMessageAndCustomerAccountView, CustomerOfferWithMessageAndCustomerAccount customerOfferWithMessageAndCustomerAccount)
	{
		customerTransmitterGenderImageview  = (ImageView)offerRowWithMessageAndCustomerAccountView.findViewById(R.id.customer_transmitter_gender_imageview);
		routeFullNameTextview			    = (TextView)offerRowWithMessageAndCustomerAccountView.findViewById(R.id.route_full_name_textview);
		customerTransmitterFullNameTextview = (TextView)offerRowWithMessageAndCustomerAccountView.findViewById(R.id.customer_transmitter_full_name_textview);
		
		if(customerOfferWithMessageAndCustomerAccount.getCustomerAccount().getGender() == 0)
			customerTransmitterGenderImageview.setImageResource(R.drawable.icon_customer_woman);
		else if(customerOfferWithMessageAndCustomerAccount.getCustomerAccount().getGender() == 1)
			customerTransmitterGenderImageview.setImageResource(R.drawable.icon_customer_man);
		
		String routeFullName = "Trajet de " + customerOfferWithMessageAndCustomerAccount.getOffer().getStartingCity() +
							   " à " +customerOfferWithMessageAndCustomerAccount.getOffer().getFinishingCity();
		
		routeFullNameTextview.setText(routeFullName);
		
		String customerTransmitterFullName = customerOfferWithMessageAndCustomerAccount.getCustomerAccount().getFirstName() + " " +
		                                     customerOfferWithMessageAndCustomerAccount.getCustomerAccount().getLastName().substring(0, 1);
		
		customerTransmitterFullNameTextview.setText(customerTransmitterFullName);
	}
}
