package com.example.testapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
		try{
			Intent intent = getIntent();
	        new onbuttonclickRegister(this).execute(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));

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
