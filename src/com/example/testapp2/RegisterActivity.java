package com.example.testapp2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;

public class RegisterActivity extends Activity {

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    
	/** Called when the user clicks the Send button */
	public void doRegister(View view) {
	    // Do something in response to button
		System.out.println("ALLOALLO");
		String URL = "http://ec2-54-214-92-10.us-west-2.compute.amazonaws.com:8080/Enquiry/Enquiry?089887664";
		try{
			  TelephonyManager mTelephonyMgr;
		        mTelephonyMgr = (TelephonyManager)
		            getSystemService(Context.TELEPHONY_SERVICE); 
		      String s =  mTelephonyMgr.getDeviceId();
	        new onbuttonclickRegister(this).execute(s);

		} catch (Exception e){String s = e.getMessage();
		System.out.println(s);}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }
    
}
