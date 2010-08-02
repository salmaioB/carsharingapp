package cs.appandroid.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.util.Log;

public class IdentificationUtilities
{
	public static boolean userIsLogged(Context context)
	{
//		FileOutputStream fos = new FileOutputStream();
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		File userLoggedFile = new File(context.getFilesDir(), ".userLogged");
		
		if(userLoggedFile.exists())
			return true;
		else
			return false;
	}
}
