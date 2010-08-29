package cs.appandroid.activities;

import cs.appandroid.controller.IdentificationController;
import cs.appandroid.view.OfferRowView;
import cs.model.Message;
import cs.model.OfferWithCustomerAccount;
import cs.webservice.MessageSaveWS;
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
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;


public class SendOfferMessage extends Activity implements OnClickListener
{
	private EditText messageEditText;
	private Button sendAMessageButton;
	
	TextView sendOfferMessageInfo;
	
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
        
        // Display the send offer message info
        sendOfferMessageInfo = new TextView(this);
        sendOfferMessageViewLayout.addView(sendOfferMessageInfo);
        
        // Display the message EditText
        messageEditText = new EditText(this);
        messageEditText.setGravity(Gravity.TOP);
        messageEditText.setLines(5);
        
        // Add the message EditText
        sendOfferMessageViewLayout.addView(messageEditText);
        
        // Display the button to send a message 
        sendAMessageButton = new Button(this);
        //sendAMessageButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.RIGHT));
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
			Message message = new Message();
			message.setContent(messageEditText.getText().toString());
			message.setIdOffer(offerWithCustomerAccount.getId());
			message.setIdCustomerAccount(offerWithCustomerAccount.getCustomerAccount().getId());
			message.setIdCustomerTransmitter(IdentificationController.getUserLoggedId(getBaseContext()));
			message.setIsRead(0);
			
			MessageSaveWS messageSaveWS = new MessageSaveWS();
			messageSaveWS.saveMessage(message);
			
			sendOfferMessageInfo.setText("Message envoyé");
			messageEditText.setText("");
		}
	}
}
