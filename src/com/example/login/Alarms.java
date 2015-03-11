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

public class Alarms extends Activity {
	Button b1, b2;
	static JSONObject actjson = new JSONObject();
	static JSONObject histjson = new JSONObject();
	JSONObject alarmcheckerhistoric;
	JSONObject alarmcheckeractive;
	long unixtime = System.currentTimeMillis();
	 
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarms);
		
		b1 = (Button) findViewById(R.id.active_alarms);
		b1.setOnClickListener(new OnClickListener() {
			
			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			@Override
			public void onClick(View v) {
				
				try {
					actjson.put("tim", unixtime);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				AsyncTask<JSONObject, Void, JSONArray> active = new JSONParserActiveAlarms().execute(actjson);
				
				try {
					MainActivity.alarmarray = active.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					alarmcheckeractive = MainActivity.alarmarray.getJSONObject(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(MainActivity.alarmarray != null && alarmcheckeractive != null){
				MainActivity.alarmheader = "Active Alarms";
				startActivity(new Intent("com.example.login.HistoricalAlarms"));
				}
				else{
					Toast.makeText(getApplicationContext(), "There are no active alarms", Toast.LENGTH_LONG).show();
				}
			}
			
			
		});
		
		b2 = (Button) findViewById(R.id.historical_alarms);
		b2.setOnClickListener(new OnClickListener() {
			
			/*
			 * (non-Javadoc)
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			@Override
			public void onClick(View v) {
				
				try {
					histjson.put("tim", unixtime);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					histjson.put("page", "1");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					histjson.put("size", "20");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				AsyncTask<JSONObject, Void, JSONArray> historical = new JSONParserHistoricalAlarms().execute(histjson);
				
				try {
					MainActivity.alarmarray = historical.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					alarmcheckerhistoric = MainActivity.alarmarray.getJSONObject(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(MainActivity.alarmarray != null && alarmcheckerhistoric != null){
					MainActivity.alarmheader = "Historical Alarms";
					startActivity(new Intent("com.example.login.HistoricalAlarms"));
				}
				else{
					Toast.makeText(getApplicationContext(), "There are no historical alarms", Toast.LENGTH_LONG).show();
				}

			}
			
			
		});
	}

}
