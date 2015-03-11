package com.example.login;

import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.os.AsyncTask;

public class JSONParser extends AsyncTask<JSONObject, Void, String> {

	InputStream in;
	String jsonobj;
	private final String url = "https://www.compile.no/ci/ndapi/login";

	/*
	 * (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@SuppressLint("NewApi")
	@Override
	protected String doInBackground(JSONObject... json) {
		
		
		DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response;


        try {
            HttpPost post = new HttpPost(url);

            StringEntity se = new StringEntity("r="+ json[0]); 
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded"));
            post.setEntity(se);
            
            response = client.execute(post);
            
            MainActivity.cookies = client.getCookieStore().getCookies();
            
            if(response!=null){
                in = response.getEntity().getContent();
                jsonobj = StringConverter.convertStreamToString(in);
            }

            
        } catch(Exception e) {
            e.printStackTrace();
        }
		return jsonobj;
	}

}
