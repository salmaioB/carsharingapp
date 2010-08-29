package cs.appandroid.activities;

import cs.appandroid.activitiesgroup.MyProfileGroup;
import cs.appandroid.controller.IdentificationController;
import cs.webservice.CustomerAccountsWS;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UserPassword extends Activity implements OnClickListener
{
    private TextView alertUserSavePasswordTextView;
    private EditText currentPasswordEditText;
    private EditText newPasswordEditText;
    private EditText newPasswordConfirmationEditText;
    private Button validateUserPasswordButton;
    
    private Runnable saveUserPasswordProcess;
    private ProgressDialog saveUserPasswordProgressDialog;
    
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    super.onCreate(savedInstanceState);
	    
	    displayUserPasswordScreen();
	}
	
	@Override
	public void onResume()
	{
	    super.onResume();
	    
	    displayUserPasswordScreen();
	}
	
	@Override
	public void onClick(View v)
	{
		if(v == validateUserPasswordButton)
		{
			saveUserPasswordProcess = new Runnable()
			{	
				@Override
				public void run()
				{
					saveCustomerNewPasswordProcess();
				}
			};
			
			Thread saveUserNewPasswordThread =  new Thread(null, saveUserPasswordProcess, "SaveUserNewPasswordThread");
			saveUserNewPasswordThread.start();
			
			saveUserPasswordProgressDialog = ProgressDialog.show(MyProfileGroup.myProfileGroup, "Please wait...", "Sauvegarde de vos informations ...", true);
		}
	}
	
	public void displayUserPasswordScreen()
	{
		setContentView(R.layout.userpassword);
		
		alertUserSavePasswordTextView   = (TextView)findViewById(R.id.alert_user_save_password_textview);
		currentPasswordEditText         = (EditText)findViewById(R.id.current_password_edittext);
	    newPasswordEditText             = (EditText)findViewById(R.id.new_password_edittext);
	    newPasswordConfirmationEditText = (EditText)findViewById(R.id.new_password_confirmation_edittext);
	    
	    validateUserPasswordButton      = (Button)findViewById(R.id.validate_user_password_button);
	    validateUserPasswordButton.setOnClickListener(this);
	}
	
	public void saveCustomerNewPasswordProcess()
	{
		Integer saveCustomerNewPasswordStatus;
		
		Integer idCustomerAccount      = IdentificationController.getUserLoggedId(getBaseContext());
		String currentPassword         = currentPasswordEditText.getText().toString();
		String newPassword             = newPasswordEditText.getText().toString();
		String newPasswordConfirmation = newPasswordConfirmationEditText.getText().toString();
		
		if(newPassword.equals(newPasswordConfirmation))
		{
			CustomerAccountsWS customerAccountWS = new CustomerAccountsWS();
			saveCustomerNewPasswordStatus = customerAccountWS.saveCustomerNewPassword(idCustomerAccount, currentPassword, newPassword);
		}
		else saveCustomerNewPasswordStatus = 3;
	    
		saveCustomerNewPasswordProcessUpdateUI(saveCustomerNewPasswordStatus);
	}
	
	public void saveCustomerNewPasswordProcessUpdateUI(final Integer saveCustomerNewPasswordStatus)
	{
	    //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
	     
		// Drop the Runnable into the UI thread queue
    	runOnUiThread(new Runnable()
    	{
           @Override
           public void run()
           {
	       	   switch(saveCustomerNewPasswordStatus)
	    	   {
	       	   		case 0: Log.v("Error: ", "saveCustomerNewPassword json");
	       	   		        break;
	       	   		case 1: alertUserSavePasswordTextView.setText("Votre mot de passe a bien été mis à jour.");
	       	   			    currentPasswordEditText.setText("");
	       	   			    newPasswordEditText.setText("");
	       	   			    newPasswordConfirmationEditText.setText("");
	       	   			    break;
	       	   		case 2: alertUserSavePasswordTextView.setText("Votre mot de passe actuel est invalide.");
	       	   			    break;
	       	   		case 3: alertUserSavePasswordTextView.setText("Veuillez resaisir votre nouveau mot de passe.");
	       	   				break;
	    	   }
        	   
        	   saveUserPasswordProgressDialog.dismiss();
           }
    	});
	}
}
