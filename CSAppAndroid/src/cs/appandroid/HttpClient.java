package cs.appandroid;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.util.zip.GZIPInputStream;
	import org.apache.http.Header;
	import org.apache.http.HttpEntity;
	import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
	import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
	import org.apache.http.entity.StringEntity;
	import org.apache.http.impl.client.DefaultHttpClient;

	import org.json.JSONObject;
import android.util.Log;
import android.widget.TextView;
	 
	public class HttpClient {
	 private static final String TAG = "HttpClient";
	 
	 public static JSONObject SendHttpPost(String URL, JSONObject jsonObjSend,TextView text)
	 {
	 
	try {
		
		text.setText("interne 1");
	   DefaultHttpClient httpclient = new DefaultHttpClient();
	   text.setText("interne 1.5");
	   HttpPost httpPostRequest = new HttpPost(URL);

	   text.setText("interne 2");

	   StringEntity se;
	   se = new StringEntity(jsonObjSend.toString());

	   text.setText("interne 3");
	   // Set HTTP parameters
	   httpPostRequest.setEntity(se);
	   httpPostRequest.setHeader("Accept", "application/json");
	   httpPostRequest.setHeader("Content-type", "application/json");
	   //httpPostRequest.setHeader("Accept-Encoding", "gzip"); // only set this parameter if you would like to use gzip compression
	   text.setText("interne 4");
	   //long t = System.currentTimeMillis();
	   HttpResponse response = (HttpResponse) httpclient.execute(httpPostRequest);
	   text.setText("interne 5 : "+response.toString());
	   
	   //if(1==1) return response.toString();
	  
	   //Log.i(TAG, "HTTPResponse received in [" + (System.currentTimeMillis()-t) + "ms]");
	   
	   // Get hold of the response entity (-> the data):
	   HttpEntity entity = response.getEntity();
	 
	   if (entity != null) {
	    // Read the content stream
	    InputStream instream = entity.getContent();
	    Header contentEncoding = response.getFirstHeader("Content-Encoding");
	    if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
	    	instream = new GZIPInputStream(instream);
	    }
	    text.setText("interne 6");
	    // convert content stream to a StringconvertStreamToString
	    String resultString= convertStreamToString(instream);
	    instream.close();
	    //resultString = resultString.substring(1,resultString.length()-1); // remove wrapping "[" and "]"
	    text.setText("interne 7" + resultString);
	    // Transform the String into a JSONObject
	    JSONObject jsonObjRecv = new JSONObject(resultString);
	    // Raw DEBUG output of our received JSON object:
	    text.setText("interne 8 : " + jsonObjRecv.toString());
	    return jsonObjRecv;
	   }
	 
	  }
	  catch (Exception e)
	  {
	   // More about HTTP exception handling in another tutorial.
	   // For now we just print the stack trace.
	   e.printStackTrace();
	  }
	  return null;
	  
	 }
	 
	 
	 private static String convertStreamToString(InputStream is) {
	  /*
	   * To convert the InputStream to String we use the BufferedReader.readLine()
	   * method. We iterate until the BufferedReader return null which means
	   * there's no more data to read. Each line will appended to a StringBuilder
	   * and returned as String.
	   *
	   * (c) public domain: http://senior.ceng.metu.edu.tr/2009/praeda/2009/01/11/a-simple-restful-client-at-android/
	   */
	  BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	  StringBuilder sb = new StringBuilder();
	 
	  String line = null;
	  try {
	   while ((line = reader.readLine()) != null) {
	    sb.append(line + "\n");
	   }
	  } catch (IOException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	    is.close();
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	  }
	  return sb.toString();
	 }
	 
	}