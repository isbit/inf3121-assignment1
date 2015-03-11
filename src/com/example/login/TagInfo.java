package com.example.login;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class TagInfo extends Activity {
	
	JSONObject taginfo = MainActivity.taginfo;
	TagList tl = new TagList();
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tag_info_listview);
		
		try {
			setTitle(taginfo.getString("n"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<TagList> TagList = GetTagList();
        final ListView lv = (ListView) findViewById(R.id.tiListView);
        TagAdapter ta = new TagAdapter(getApplicationContext(), TagList);
        lv.setAdapter(ta);
	}
	
	/**
	 * Går gjennom alle elementene i taglista og lager
	 * et javaobjekt for hvert element, disse objektene
	 * samles i en liste.
	 * 
	 * @return en liste med ferdig utfyllte javaobjekter
	 */
	private ArrayList<TagList> GetTagList(){
		
	    ArrayList<TagList> results = new ArrayList<TagList>();
	    
	    tl = new TagList();
	    
	    try {
			tl.setTagName(taginfo.getString("n"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			tl.setValue(taginfo.getString("v"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			tl.setUnit(taginfo.getString("u"));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			tl.setQuality(taginfo.getString("q"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    results.add(tl);

	    return results;
	}

}
