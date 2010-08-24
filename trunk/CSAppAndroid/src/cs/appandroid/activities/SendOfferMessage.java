package cs.appandroid.activities;

import cs.appandroid.view.OfferRowView;
import cs.model.OfferWithCustomerAccount;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout.LayoutParams;


public class SendOfferMessage extends Activity implements OnClickListener
{
	private Button sendAMessageButton;
	
	private OfferWithCustomerAccount offerWithCustomerAccount;
	private String startingCity;
	private String finishingCity;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    Bundle sendOfferMessageExtras = getIntent().getExtras();
	    
	    if(sendOfferMessageExtras.containsKey("offerWithCustomerAccount"))
        	offerWithCustomerAccount = (OfferWithCustomerAccount)sendOfferMessageExtras.getSerializable("offerWithCustomerAccount");	    
	    
        if(sendOfferMessageExtras.containsKey("startingCity") && sendOfferMessageExtras.containsKey("finishingCity"))
        {
        	startingCity  = sendOfferMessageExtras.getString("startingCity");
        	finishingCity = sendOfferMessageExtras.getString("finishingCity");
        }
	    
        // Define the main layout
	    LinearLayout sendOfferMessageViewLayout = new LinearLayout(this);
	    sendOfferMessageViewLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
	    sendOfferMessageViewLayout.setOrientation(LinearLayout.VERTICAL);
	    
	    // Display the selected offer
	    LayoutInflater offerViewlayoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View offerView = offerViewlayoutInflater.inflate(R.layout.offerrow, null);
        
        OfferRowView.displayOfferRow(offerView, offerWithCustomerAccount, startingCity, finishingCity);
        
        // Add the selected offer view into the main view
        sendOfferMessageViewLayout.addView(offerView);
        
        // Display the message EditText
        EditText messageEditText = new EditText(this);
        messageEditText.setGravity(Gravity.TOP);
        messageEditText.setLines(5);
        
        // Add the message EditText
        sendOfferMessageViewLayout.addView(messageEditText);
        
        // Display the button to send a message 
        sendAMessageButton = new Button(this);
        sendAMessageButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT));
        sendAMessageButton.setText("Envoyer");
        sendAMessageButton.setOnClickListener(this);
        
        // Add the "send message" button
        sendOfferMessageViewLayout.addView(sendAMessageButton);
        
        setContentView(sendOfferMessageViewLayout);
	}


	@Override
	public void onClick(View v)
	{
		if(v == sendAMessageButton)
		{
			
			
		}
	}
}
