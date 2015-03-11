package com.example.login;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AlarmAdapter extends BaseAdapter {
	
	private static ArrayList<AlarmList> AlarmArrayList;
	
    private LayoutInflater mInflater;
    
    /**
     * Setter inflaterens kontekst til input kontekst.
     * Setter AlarmArrayList til input arraylist.
     * 
     * @param context konteksten som skal benyttes
     * @param results arraylisten som skal benyttes
     */
    public AlarmAdapter(Context context, ArrayList<AlarmList> results) {
        AlarmArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
    
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getCount()
     */
    public int getCount() {
        return AlarmArrayList.size();
    }
 
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    public Object getItem(int position) {
        return AlarmArrayList.get(position);
    }
 
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getItemId(int)
     */
    public long getItemId(int position) {
        return position;
    }
    
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.alarms_row_view, null);
            holder = new ViewHolder();
            holder.txtTagName = (TextView) convertView.findViewById(R.id.tagname);
            holder.txtAlarmTxt = (TextView) convertView.findViewById(R.id.alarmtxt);
            holder.txtAlarmOn = (TextView) convertView.findViewById(R.id.alarmon);
            holder.txtAlarmOff = (TextView) convertView.findViewById(R.id.alarmoff);
 
            convertView.setTag(holder);
        } 
        else 
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
        holder.txtTagName.setText("Tag: " + AlarmArrayList.get(position).getTagName());
        holder.txtAlarmTxt.setText("Alarm text: " + AlarmArrayList.get(position).getAlarmTxt());
        holder.txtAlarmOn.setText("Turned on: " + AlarmArrayList.get(position).getAlarmOn());
        holder.txtAlarmOff.setText("Turned off: " + AlarmArrayList.get(position).getAlarmOff());
 
        return convertView;
    }
 
    static class ViewHolder {
        TextView txtTagName;
        TextView txtAlarmTxt;
        TextView txtAlarmOn;
        TextView txtAlarmOff;
    }
}
