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
		
		customerTransmitterGenderImageview.setImageResource(R.drawable.icon_customer_man);
		routeFullNameTextview.setText("azeazeze");
		customerTransmitterFullNameTextview.setText("azeazeaze");
	}
}
