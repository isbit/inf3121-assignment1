package com.example.login;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

public class Show_Alarms extends Activity {
	
	JSONArray alarms = MainActivity.alarmarray;
	AlarmList al = new AlarmList();
	@SuppressLint("SimpleDateFormat")
	SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy,HH:mm");
    String alarmon;
    String alarmoff;
    Long alarmonl;
    Long alarmoffl;
    TextView header;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm_info_listview);
		
		setTitle(MainActivity.alarmheader);
		
		ArrayList<AlarmList> AlarmList = GetAlarmList();
        final ListView lv = (ListView) findViewById(R.id.aiListView);
        AlarmAdapter aa = new AlarmAdapter(getApplicationContext(), AlarmList);
        lv.setAdapter(aa);
        lv.setClickable(true);
	}
	
	/**
	 * Går gjennom alle elementene i alarmlista og lager
	 * et javaobjekt for hvert element, disse objektene
	 * samles i en liste.
	 * 
	 * @return en liste med ferdig utfyllte javaobjekter
	 */
	private ArrayList<AlarmList> GetAlarmList(){
	     ArrayList<AlarmList> results = new ArrayList<AlarmList>();

	 
	     for (int i = 0; i < alarms.length(); i++) {
	    	 
	    	 al = new AlarmList();
	    	 try {
				al.setTagName(alarms.getJSONObject(i).getString("tagname"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 try {
				al.setAlarmTxt(alarms.getJSONObject(i).getString("alarmtxt"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 try {
				alarmon = alarms.getJSONObject(i).getString("alarmon");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 alarmonl = Long.valueOf(alarmon);
	    	 
	    	 if(alarmonl == 0){
	    		 al.setAlarmOn("");
	    	 }
	    	 
	    	 else{
	    		 al.setAlarmOn(f.format(new Date(alarmonl)));
	    	 }
	    	 
	    	 try {
				alarmoff = alarms.getJSONObject(i).getString("alarmoff");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 alarmoffl = Long.valueOf(alarmoff);
	    	 
	    	 if(alarmoffl == 0){
	    		 al.setAlarmOff("");
	    	 }
	    	 
	    	 else{
	    		 al.setAlarmOff(f.format(new Date(alarmoffl)));
	    	 }

	    	 
	    	 results.add(al);
	       }
	     
	     return results;
	}
}