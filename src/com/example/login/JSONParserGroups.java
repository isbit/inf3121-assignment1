package com.example.login;

import java.io.InputStream;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.CookieSpecBase;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

public class JSONParserGroups extends AsyncTask<Void, Void, JSONArray> {
	
	InputStream in;
	JSONObject jsonresponse;
	JSONArray groups;
	private final String url = "https://www.compile.no/ci/ndapi/getgroups";
	List<Header> cookieHeader;
	CookieSpecBase cookieSpecBase = new BrowserCompatSpec();
	
	/*
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@SuppressLint("NewApi")
	protected JSONArray doInBackground(Void...voids) {
		
		
		DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response;


        try {
            HttpPost post = new HttpPost(url);

            StringEntity se = new StringEntity("r="); 
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded"));
            cookieHeader = cookieSpecBase.formatCookies(MainActivity.cookies);
            post.setHeader((Header) cookieHeader.get(0));
            post.setEntity(se);
            
            response = client.execute(post);
            

            //Checking response 
            if(response!=null){
                in = response.getEntity().getContent();
                jsonresponse = new JSONObject(StringConverter.convertStreamToString(in));
                groups = jsonresponse.getJSONArray("groups");
            }

            
        } catch(Exception e) {
            e.printStackTrace();
        }
		return groups;
	}

}
