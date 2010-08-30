package cs.appandroid.activities;

import java.util.Iterator;
import java.util.List;

import cs.appandroid.activitiesgroup.MyMessagesGroup;
import cs.appandroid.activitiesgroup.MyRoutesGroup;
import cs.appandroid.activitiesgroup.SearchOffersGroup;
import cs.appandroid.controller.IdentificationController;
import cs.appandroid.view.OfferRowView;
import cs.model.CustomerAccount;
import cs.model.MessageWithCustomerAccount;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.OfferMessagesWS;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
	
	private OfferWithCustomerAccount offerWithCustomerAccount;
	private String startingCity;
	private String finishingCity;
	private String customerMobile;
	
	private Bundle offerViewExtras;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    // Retrieve offer data
        offerViewExtras = getIntent().getExtras();
        
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
	    
        ScrollView scrollView = new ScrollView(this);
        scrollView.addView(offerViewLayout);
	    
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
        
	    CustomerAccount customerAccountTransmitter = null;
	    
	    if(offerViewExtras.containsKey("customerAccountTransmitter"))
	    {
	    	customerAccountTransmitter = (CustomerAccount)offerViewExtras.getSerializable("customerAccountTransmitter");
	    	displayCustomerView(customerView, customerAccountTransmitter);
	    }
	    else displayCustomerView(customerView, offerWithCustomerAccount.getCustomerAccount());
        
        customerView.setPadding(0, 20, 0, 0);
        
        // Add the selected offer view into the main view
        offerViewLayout.addView(customerView);
        
        if(offerViewExtras.containsKey("displayMessages"))
		{
        	
        	Integer idOffer			         = offerWithCustomerAccount.getId();
        	Integer idCustomerTransmitter 	 = customerAccountTransmitter.getId();
        	Integer idCurrentCustomerAccount = IdentificationController.getUserLoggedId(getBaseContext());
        	
        	OfferMessagesWS offerMessagesWS = new OfferMessagesWS();
        	List<MessageWithCustomerAccount> messagesWithCustomerAccount = offerMessagesWS.getOfferMessages(idOffer, idCustomerTransmitter, idCurrentCustomerAccount);
        	
        	Iterator<MessageWithCustomerAccount> iteratorMessagesWithCustomerAccount = messagesWithCustomerAccount.iterator();
    		while(iteratorMessagesWithCustomerAccount.hasNext())
    		{
    			MessageWithCustomerAccount messageWithCustomerAccount = iteratorMessagesWithCustomerAccount.next();
    			Log.v("test", messageWithCustomerAccount.getCustomerAccount().getFirstName());
    			
    			LinearLayout messageViewLayout = new LinearLayout(this);
    			messageViewLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    		    
    			String userFullNameStr = messageWithCustomerAccount.getCustomerAccount().getFirstName() + " " + messageWithCustomerAccount.getCustomerAccount().getLastName().substring(0, 1);
    			TextView messageUserFullNameTextView = new TextView(this);
    			messageUserFullNameTextView.setText(userFullNameStr);
    			messageViewLayout.addView(messageUserFullNameTextView);
    			
    			//String messageDatetimeWritedStr = messageWithCustomerAccount.getMessage().getDatetimeWrited().toString();
    			TextView messageDatetimeWritedTextView = new TextView(this);
    			messageDatetimeWritedTextView.setGravity(Gravity.RIGHT);
    			//messageDatetimeWritedTextView.setText("azeze");
    			messageViewLayout.addView(messageDatetimeWritedTextView);
    			
    			offerViewLayout.addView(messageViewLayout);
    			
    			TextView messageContentTextView = new TextView(this);
    			messageContentTextView.setText(messageWithCustomerAccount.getMessage().getContent());
   
    			offerViewLayout.addView(messageContentTextView);
    		}
		}
        
        setContentView(scrollView);
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
			
			if(!offerViewExtras.containsKey("displayMessages"))
			{
				View sendOfferMessageView = SearchOffersGroup.searchOffersGroup.getLocalActivityManager()
																			   .startActivity("Send message offer view",
														   				       intentSendOfferMessageView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))  
														   				       .getDecorView(); 
			
				SearchOffersGroup.searchOffersGroup.replaceView(sendOfferMessageView);
			}
			else
			{
				View sendOfferMessageView = MyMessagesGroup.myMessagesGroup.getLocalActivityManager()
				   													       .startActivity("Send message offer view",
																	       intentSendOfferMessageView.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))  
																	       .getDecorView(); 

				MyMessagesGroup.myMessagesGroup.replaceView(sendOfferMessageView);
			}
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
	
	public void displayCustomerView(View customerView, CustomerAccount customerAccount)
	{
		if(offerWithCustomerAccount != null)
		{
			customerMobile = customerAccount.getMobile();
			
			customerFullNameTextView.setText("Nom: " + customerAccount.getFirstName() + " " + customerAccount.getLastName());
			//customerDateRegistrationTextView.setText("Inscription: " + offerWithCustomerAccount.getCustomerAccount().getDatetimeRegistrationToDisplay());

			customerAcceptAnimalsImageView.setImageResource(R.drawable.accept_animals_green);
			customerAcceptRadioImageView.setImageResource(R.drawable.accept_radio_red);
			customerAcceptSmokerImageView.setImageResource(R.drawable.accept_smoker_yellow);
			customerAcceptToDiscussImageView.setImageResource(R.drawable.accept_to_discuss_green);
			customerAcceptToMakeADetourImageView.setImageResource(R.drawable.accept_to_make_a_detour_red);
			
			customerMobileButton.setText(customerAccount.getMobile());
			customerMobileButton.setOnClickListener(this);
			
			if(offerViewExtras.containsKey("myOffers"))
				customerSendAMessageButton.setVisibility(View.INVISIBLE);
			
			customerSendAMessageButton.setOnClickListener(this);
		}
	}
}
