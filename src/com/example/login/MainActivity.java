package com.example.login;


import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button b1;
	static EditText username;
	static EditText password;
	static JSONObject validate = new JSONObject();
	static JSONObject jsonobj = null;
	static JSONArray grouparray;
	static JSONArray tagarray;
	static JSONObject taginfo;
	static JSONArray alarmarray;
	String checkjson = null;
	static List<Cookie> cookies;
	CookieStore store = new BasicCookieStore();
	static String alarmheader;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setTitleColor(Color.WHITE);
		
		
		b1 = (Button) findViewById(R.id.btn_login);
        b1.setOnClickListener(new OnClickListener() {
			
        	/*
        	 * (non-Javadoc)
        	 * @see android.view.View.OnClickListener#onClick(android.view.View)
        	 */
			@Override
			public void onClick(View v) {
				username = (EditText) findViewById(R.id.entered_user);
				password = (EditText) findViewById(R.id.entered_password);
				
				try {
					validate.put("u", username.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					validate.put("p", password.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				AsyncTask<JSONObject, Void, String> login = new JSONParser().execute(validate);
				//String jsonobj = null;
				try {
					jsonobj = new JSONObject(login.get());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					checkjson = jsonobj.getString("error");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int checklogin = Integer.parseInt(checkjson);
				if (checklogin == 0)
				{
				Context context = getApplicationContext();
				CharSequence text = (CharSequence) "Login successful";
				//CharSequence text = (CharSequence) validate.toString();
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				username.setText("");
				password.setText("");
				startActivity(new Intent("com.example.login.Menu"));
				}
				else
				{
					Context context = getApplicationContext();
					CharSequence text = (CharSequence) "Username or password is incorrect ";
					//CharSequence text = (CharSequence) validate.toString();
					int duration = Toast.LENGTH_LONG;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}
			}
		});
		
	}
}
