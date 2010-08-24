package cs.appandroid.activities;

import cs.appandroid.view.OfferRowView;
import cs.model.OfferWithCustomerAccount;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;


public class OfferView extends Activity implements OnClickListener
{
	//private ImageView customerPhotoImageView;
	private TextView customerFullNameTextView;
	private TextView customerDateRegistrationTextView;
	
	private ImageView customerAcceptAnimalsImageView;
	private ImageView customerAcceptRadioImageView;
	private ImageView customerAcceptSmokerImageView;
	private ImageView customerAcceptToDiscussImageView;
	private ImageView customerAcceptToMakeADetourImageView;
	
	private Button customerMobileButton;
	private Button customerSendAMessageButton;
	
	OfferWithCustomerAccount offerWithCustomerAccount;
	private String startingCity;
	private String finishingCity;
	private String customerMobile;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    // Retrieve offer data
        Bundle offerViewExtras = getIntent().getExtras();
        
        if(offerViewExtras.containsKey("offerWithCustomerAccount"))
        	offerWithCustomerAccount = (OfferWithCustomerAccount)offerViewExtras.getSerializable("offerWithCustomerAccount");	    
	    
        if(offerViewExtras.containsKey("startingCity") && offerViewExtras.containsKey("finishingCity"))
        {
        	startingCity  = offerViewExtras.getString("startingCity");
        	finishingCity = offerViewExtras.getString("finishingCity");
        }
        
	    LinearLayout offerViewLayout = new LinearLayout(this);
	    offerViewLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
	    offerViewLayout.setOrientation(LinearLayout.VERTICAL);
	    
	    // Display the route TextView
	    TextView theRouteTextView = new TextView(this);
	    theRouteTextView.setText("Le trajet");
	    theRouteTextView.setGravity(Gravity.LEFT);
	    
	    offerViewLayout.addView(theRouteTextView);
	    
	    // Display the selected offer
	    LayoutInflater offerViewlayoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View offerView = offerViewlayoutInflater.inflate(R.layout.offerrow, null);
        
        OfferRowView.displayOfferRow(offerView, offerWithCustomerAccount, startingCity, finishingCity);
        
        // Add the selected offer view into the main view
        offerViewLayout.addView(offerView);
        
	    // Display the customer TextView
	    TextView theCustomerTextView = new TextView(this);
	    theCustomerTextView.setText("Le conducteur");
	    theCustomerTextView.setGravity(Gravity.LEFT);
	    
	    offerViewLayout.addView(theCustomerTextView);
        
        // Display the customer view
	    LayoutInflater customerViewLayoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customerView = customerViewLayoutInflater.inflate(R.layout.customerview, null);
        
	    getCustomerViewComponents(customerView);
        displayCustomerView(customerView, offerWithCustomerAccount);
        
        customerView.setPadding(0, 20, 0, 0);
        
        // Add the selected offer view into the main view
        offerViewLayout.addView(customerView);
        
        setContentView(offerViewLayout);
	}

	@Override
	public void onClick(View v)
	{
		if(v == customerMobileButton)
		{
			String toDial = "tel:" + customerMobile.toString();
			startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
		}
		else if(v == customerSendAMessageButton)
		{
			Intent intentSendOfferMessageView = new Intent(this, SendOfferMessage.class);	
			intentSendOfferMessageView.putExtra("offerWithCustomerAccount", offerWithCustomerAccount);
			intentSendOfferMessageView.putExtra("startingCity", startingCity);
			intentSendOfferMessageView.putExtra("finishingCity", finishingCity);
			
			View sendOfferMessageView = SearchOffersGroup.searchOffersGroup.getLocalActivityManager()
														   				   .startActivity("Send message offer view",
														   				   intentSendOfferMessageView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))  
														   				   .getDecorView(); 
			
			SearchOffersGroup.searchOffersGroup.replaceView(sendOfferMessageView);
		}
	}
	
	public void getCustomerViewComponents(View customerView)
	{
		// Get customer view components
		//customerPhotoImageView               = (ImageView)customerView.findViewById(R.id.customer_photo_imageview);
		customerFullNameTextView             = (TextView)customerView.findViewById(R.id.customer_full_name_textview);
		customerDateRegistrationTextView     = (TextView)customerView.findViewById(R.id.customer_date_registration_textview);
		
		customerAcceptAnimalsImageView       = (ImageView)customerView.findViewById(R.id.customer_accept_animals_imageview);
		customerAcceptRadioImageView         = (ImageView)customerView.findViewById(R.id.customer_accept_radio_imageview);
		customerAcceptSmokerImageView        = (ImageView)customerView.findViewById(R.id.customer_accept_smoker_imageview);
		customerAcceptToDiscussImageView     = (ImageView)customerView.findViewById(R.id.customer_accept_to_discuss_imageview);
		customerAcceptToMakeADetourImageView = (ImageView)customerView.findViewById(R.id.customer_accept_to_make_a_detour);
		
		customerMobileButton                 = (Button)customerView.findViewById(R.id.customer_mobile_button);
		customerSendAMessageButton			 = (Button)customerView.findViewById(R.id.customer_send_a_message_button);
	}
	
	public void displayCustomerView(View customerView, OfferWithCustomerAccount offerWithCustomerAccount)
	{
		if(offerWithCustomerAccount != null)
		{
			customerMobile = offerWithCustomerAccount.getMobile();
			
			customerFullNameTextView.setText("Nom: " + offerWithCustomerAccount.getFirstName() + " " + offerWithCustomerAccount.getLastName());
			customerDateRegistrationTextView.setText("Inscription: " + offerWithCustomerAccount.getDatetimeRegistrationToDisplay());

			customerAcceptAnimalsImageView.setImageResource(R.drawable.accept_animals_green);
			customerAcceptRadioImageView.setImageResource(R.drawable.accept_radio_red);
			customerAcceptSmokerImageView.setImageResource(R.drawable.accept_smoker_yellow);
			customerAcceptToDiscussImageView.setImageResource(R.drawable.accept_to_discuss_green);
			customerAcceptToMakeADetourImageView.setImageResource(R.drawable.accept_to_make_a_detour_red);
			
			customerMobileButton.setText(offerWithCustomerAccount.getMobile());
			customerMobileButton.setOnClickListener(this);
			
			customerSendAMessageButton.setOnClickListener(this);
		}
	}
}
