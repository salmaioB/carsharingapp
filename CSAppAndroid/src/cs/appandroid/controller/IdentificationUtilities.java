package cs.appandroid.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

public class IdentificationUtilities
{
	public static boolean userIsLogged(Context context)
	{
		File userLoggedFile = new File(context.getFilesDir(), ".userLogged");
		
		if(userLoggedFile.exists())
			return true;
		else
			return false;
	}
	
	public static Integer getUserLoggedId(Context context)
	{
		File userLoggedFile = new File(context.getFilesDir(), ".userLogged");
		
		Log.v("Android path", context.getFilesDir() + ".userLogged");
		Log.v("File path", userLoggedFile.getPath());
		
//		FileInputStream fis 	= null;
//		BufferedInputStream bis = null;
//		DataInputStream dis     = null;
		
		//fos = context.openFileOutput(context.getFilesDir() + ".userLogged", Context.MODE_APPEND);
		
		return null;
	}
	
	public static void disconnectUser(Context context)
	{
		File userLoggedFile = new File(context.getFilesDir(), ".userLogged");
		userLoggedFile.delete();
	}
	
	public static void saveUserIsLogged(Context context, Integer customerId)
	{
		File userLoggedFile = new File(context.getFilesDir(), ".userLogged");
		
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
			fos = context.openFileOutput(".userLogged", Context.MODE_APPEND);
			bos = new BufferedOutputStream(fos);
			dos = new DataOutputStream(bos);
			
			dos.writeInt(customerId.intValue());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
