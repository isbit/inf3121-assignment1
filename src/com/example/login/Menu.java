package com.example.login;


import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {
	
	Button b1, b2, b3;
	JSONObject groupchecker;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		b1 = (Button) findViewById(R.id.groups);
		b1.setOnClickListener(new OnClickListener() {
			
			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			public void onClick(View v) {
				AsyncTask<Void, Void, JSONArray> groups = new JSONParserGroups().execute();

				
				try {
					MainActivity.grouparray = groups.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					groupchecker = MainActivity.grouparray.getJSONObject(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(groupchecker != null){
					startActivity(new Intent("com.example.login.Groups"));
				}
				else{
					Toast.makeText(getApplicationContext(), "There are no groups available", Toast.LENGTH_LONG).show();
				}
				
			}
		});
			
		b2 = (Button) findViewById(R.id.alarms);
		b2.setOnClickListener(new OnClickListener(){
			
			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			public void onClick(View v) {
				startActivity(new Intent("com.example.login.Alarms"));
			}
			
		});
		
		b3 = (Button) findViewById(R.id.logout);
		b3.setOnClickListener(new OnClickListener() {
			
			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			public void onClick(View v) {
				MainActivity.jsonobj = null;
				Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);   
				startActivity(startIntent);
				finish();
				
			}
		});
	}

}
