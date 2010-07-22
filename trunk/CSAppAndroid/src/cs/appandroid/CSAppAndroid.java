package cs.appandroid;

import org.json.JSONException;
import org.json.JSONObject;

import cs.model.CustomerAccounts;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.os.Bundle;  
import android.view.KeyEvent;   
//android.maps.MapActivity;
//import com.google.android.maps.MapController;  
//import com.google.android.maps.MapView;

public class CSAppAndroid extends Activity {
	
	private static final String TAG = "MainActivity";
	private static final String URL = "http://10.0.2.2:8888/CSAppWeb/CustomerAccountsWS";
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.v(TAG, "Test logger");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	 
		// JSON object to hold the information, which is sent to the server	 
		JSONObject jsonObjSend = new JSONObject();

		TextView jsonTextView = (TextView) findViewById(R.id.myTextView);
	   
		jsonTextView.setText("test");
		
	  try {
	   // Add key/value pairs
	   //jsonObjSend.put("key_1", "value_1");
	   //jsonObjSend.put("key_2", "value_2");
	 
	   // Add a nested JSONObject (e.g. for header information)
	   JSONObject header = new JSONObject();
	   header.put("deviceType","Android"); // Device type
	   header.put("deviceVersion","2.0"); // Device OS version
	   header.put("language", "es-es"); // Language of the Android client
	   jsonObjSend.put("header", header);

	   // Output the J
		//setContentView(R.layout.main);//SON object we're sending to Logcat:
	   jsonTextView.setText("avant");
		//setContentView(R.layout.main);
		//jsonTextView.setText(jsonObjSend.toString());
	    //jsonTextView.setText("av");
	  } catch (JSONException e) {
		  e.printStackTrace();
	  }
	 
 	  // Send the HttpPostRequest and receive a JSONObject in return
	  //JSONObject jsonObjRecv =
	  HttpClient  ht = new HttpClient();
	  JSONObject tmp = ht.SendHttpPost(URL, jsonObjSend,jsonTextView) ;
	 
	  String s = "name";
	  CustomerAccounts use = new CustomerAccounts();

	  jsonTextView.setText( "interne 9 " + tmp.toString() );

		try {
			JSONObject ob = tmp.getJSONObject("use");

			use = (CustomerAccounts) tmp.get("use");
			
			//use.setName(ob.getString("name"));
			jsonTextView.setText( "interne 10 " + use.getCustomerLogin() );
		} catch (JSONException e) {
			jsonTextView.setText( "interne 11 " + e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//} catch (JSONException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	//}
	  //jsonTextView.setText( "interne 10 : " + nuse.toString() );
	  //}
	  //else
	  //{
		 // jsonTextView.setText( "no key");
	  //}
	  //jsonTextView.setText(jsonObjRecv.toString());

	  //Log.i(TAG,jsonObjRecv.toString() );
	  /*
	   *  From here on do whatever you want with your JSONObject, e.g.
	   *  1) Get the value for a key: jsonObjRecv.get("key");
	   *  2) Get a nested JSONObject: jsonObjRecv.getJSONObject("key")
	   *  3) Get a nested JSONArray: jsonObjRecv.getJSONArray("key")
	   
	 
	 */
	 }
	}