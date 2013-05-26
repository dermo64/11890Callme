package com.example.testapp2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class onbuttonclickHttpPost extends AsyncTask<String, Void, String> {
	private Context ctx;
	
	public onbuttonclickHttpPost(Context appCtx) {
		// TODO Auto-generated constructor stub
		ctx = appCtx;
	}
    @Override
    protected String doInBackground(String... params) {
        String str = "";
       // Create a new HttpClient and Post Header
      
		String URL = "http://ec2-54-214-92-10.us-west-2.compute.amazonaws.com:8080/Enquiry/Enquiry?emei=" 
				+params[0];

        try {
    		HttpClient httpclient = new DefaultHttpClient();
    	    HttpResponse response = httpclient.execute(new HttpGet(URL));
         
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	str = e.getMessage();
        }
     //   Context context = getApplicationContext();

        return str;
    }
    
    @Override
    protected void onPostExecute(String result) {       
        String text = "You will receive a call shortly!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(ctx, text, duration);
        toast.show();
       
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}