package com.example.login;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.content.Intent;

public class GroupInfo extends Activity {
	
	JSONArray tags = MainActivity.tagarray;
	JSONObject test;
	String[] stringarray = new String[tags.length()];

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups);
		
		final ListView lv = (ListView)findViewById(R.id.group_list); 
		
		for (int i = 0; i < tags.length(); i++) {
			
			try {
				stringarray[i] = tags.getJSONObject(i).getString("n");
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
					MainActivity.taginfo = tags.getJSONObject(pos);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

	            startActivity(new Intent("com.example.login.TagInfo"));
				
			}
		});
		
	}

}
