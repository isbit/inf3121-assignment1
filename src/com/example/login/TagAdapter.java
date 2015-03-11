package com.example.login;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TagAdapter extends BaseAdapter {
	
	private static ArrayList<TagList> TagArrayList;
	 
    private LayoutInflater mInflater;
    
    /**
     * Setter inflaterens kontekst til input kontekst.
     * Setter TagArrayList til input arraylist.
     * 
     * @param context konteksten som skal benyttes
     * @param results arraylisten som skal benyttes
     */
    public TagAdapter(Context context, ArrayList<TagList> results) {
        TagArrayList = results;
        mInflater = LayoutInflater.from(context);
    }
 
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getCount()
     */
    public int getCount() {
        return TagArrayList.size();
    }
 
    /*
     * (non-Javadoc)
     * @see android.widget.Adapter#getItem(int)
     */
    public Object getItem(int position) {
        return TagArrayList.get(position);
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
            convertView = mInflater.inflate(R.layout.tags_row_view, null);
            holder = new ViewHolder();
            holder.txtTagName = (TextView) convertView.findViewById(R.id.tagname);
            holder.txtValue = (TextView) convertView.findViewById(R.id.value);
            holder.txtUnit = (TextView) convertView.findViewById(R.id.unit);
            holder.txtQuality = (TextView) convertView.findViewById(R.id.quality);
 
            convertView.setTag(holder);
        } 
        else 
        {
            holder = (ViewHolder) convertView.getTag();
        }
 
        holder.txtTagName.setText("Tag: " + TagArrayList.get(position).getTagName());
        holder.txtValue.setText("Value: " + TagArrayList.get(position).getValue());
        holder.txtUnit.setText("Unit: " + TagArrayList.get(position).getUnit());
        holder.txtQuality.setText("Quality: " + TagArrayList.get(position).getQuality());
 
        return convertView;
    }
 
    /*
     * 
     */
    static class ViewHolder {
        TextView txtTagName;
        TextView txtValue;
        TextView txtUnit;
        TextView txtQuality;
    }
}
