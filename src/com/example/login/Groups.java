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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Groups extends Activity {

	JSONArray groups = MainActivity.grouparray;
	String[] stringarray = new String[groups.length()];
	String gid;
	JSONObject group = new JSONObject();
	JSONObject groupchecker;
	long unixtime = System.currentTimeMillis();

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups);
		
		final ListView lv = (ListView)findViewById(R.id.group_list);  
		
		
		for (int i = 0; i < groups.length(); i++) {
            try {
				stringarray[i] = groups.getJSONObject(i).getString("name");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

		ArrayAdapter<String> ladapter = new ArrayAdapter<String>(this, R.layout.lv_centered, stringarray);
		lv.setAdapter(ladapter);
		lv.setClickable(true);
		lv.setDividerHeight(5);
		lv.setOnItemClickListener(new OnItemClickListener() {

			/*
			 * (non-Javadoc)
			 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
			 */
			@Override
			public void onItemClick(AdapterView<?> p, View v, int pos,
					long id) {
				Object o = lv.getItemAtPosition(pos);
	            @SuppressWarnings("unused")
				String str=o.toString();
	            try {
					gid = groups.getJSONObject(pos).getString("id");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

	            try {
					group.put("group", gid);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            try {
					group.put("tim", unixtime);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            AsyncTask<JSONObject, Void, JSONArray> info = new JSONParserGroupInfo().execute(group);
	            
	            try {
					MainActivity.tagarray = info.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            try {
					groupchecker = MainActivity.tagarray.getJSONObject(0);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            if(groupchecker != null){
	            startActivity(new Intent("com.example.login.GroupInfo"));
	            }
	            
	            else{
	            	Toast.makeText(getApplicationContext(), "There are no groups available", Toast.LENGTH_LONG).show();
	            }
				
			}
		});


	}



}
