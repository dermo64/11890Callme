package com.example.testapp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
	    // Do something in response to button
		try{
			  TelephonyManager mTelephonyMgr;
		        mTelephonyMgr = (TelephonyManager)
		            getSystemService(Context.TELEPHONY_SERVICE); 
		      String s =  mTelephonyMgr.getDeviceId();
	        new onbuttonclickHttpPost(this).execute(s);

		} catch (Exception e){String s = e.getMessage();
		System.out.println(s);}
	}
	/** Called when the user clicks the Send button */
	public void register(View view) {
		 Intent intent = new Intent(this, RegisterActivity.class);
		 startActivity(intent);

	}
}
