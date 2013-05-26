package com.example.testapp2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

public class onbuttonclickRegister extends AsyncTask<String, Void, String> {
	private RegisterActivity ctx;
	
	public onbuttonclickRegister(RegisterActivity appCtx) {
		// TODO Auto-generated constructor stub
		ctx = appCtx;
	}
    @Override
    protected String doInBackground(String... params) {
        String str = "";
        EditText editText;
        String name = "";
        String phone = "";
       // Create a new HttpClient and Post Header
        try{
        editText = (EditText) ctx.findViewById(R.id.editText_name);
        name = editText.getText().toString();
        
        editText = (EditText) ctx.findViewById(R.id.editText_phone);
        phone = editText.getText().toString(); 
        } catch (Exception e) {
        	String s1=e.getMessage();
        	System.out.println(s1);
        	}
        
		String URL = "http://ec2-54-214-92-10.us-west-2.compute.amazonaws.com:8080/Enquiry/Enquiry?emei="
				+params[0] + "&Name=" + name + "&Phone=" + phone;

        try {
    		HttpClient httpclient = new DefaultHttpClient();
    		System.out.println(URL);
    	    HttpResponse response = httpclient.execute(new HttpGet(URL));
    	    str = response.getStatusLine().toString();
         
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	str = e.getMessage();
        }
     //   Context context = getApplicationContext();

        return str;
    }
    
    @Override
    protected void onPostExecute(String result) {       
        String text = "Response: " + result + "Your details have been registered";
        int duration = Toast.LENGTH_LONG;

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