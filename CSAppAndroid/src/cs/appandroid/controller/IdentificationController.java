package cs.appandroid.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.util.Log;


public class IdentificationController
{
	public static boolean userIsLogged(Context context)
	{
		File userLoggedFile = new File(context.getFilesDir(), "userLogged.txt");
		
		if(userLoggedFile.exists())
			return true;
		else
			return false;
	}
	
	public static Integer getUserLoggedId(Context context)
	{
		int idCustomerAccount = 0;
		
		File userLoggedFile = new File(context.getFilesDir(), "userLogged.txt");
		
		System.out.println(userLoggedFile.getPath());
		
		FileInputStream fis 	= null;
		BufferedInputStream bis = null;
		DataInputStream dis     = null;
		
		try
		{
			fis = context.openFileInput("userLogged.txt");
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			idCustomerAccount = dis.readInt();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return Integer.valueOf(idCustomerAccount);
	}
	
	public static void disconnectUser(Context context)
	{
		File userLoggedFile = new File(context.getFilesDir(), "userLogged.txt");
		userLoggedFile.delete();
	}
	
	public static void saveUserIsLogged(Context context, Integer idCustomerAccount)
	{
		File userLoggedFile = new File(context.getFilesDir(), "userLogged.txt");
		
		// Create the file ".userLogged"
		try {
			userLoggedFile.createNewFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		
		// Save the customer id into the file
		try {
			fos = context.openFileOutput("userLogged.txt", Context.MODE_APPEND);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			Log.v("test id customer", idCustomerAccount.toString());
			
			//dos.writeChars("teub");
			dos.writeInt(idCustomerAccount.intValue());
			dos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
