package com.servicemen.HTTPClient;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.servicemen.HTTPServer.RegisterResponse;
import com.servicemen.HTTPServer.ServerConstants;
import com.servicemen.HTTPServer.ServerResponseBase;
import com.servicemen.Utils.Logger;

public class RegisterRequest extends HttpRequest{
	private static String RESTAPI="registerServiceMan";
    public static final String URL = ServerConstants.SERVER_ADDRESS + ServerConstants.REGISTER + "/"+RESTAPI+"/";
    private static final String TAG = "com.BhakBosdi.HttpClient.AddFriendRequest";
    
	HttpPost httpQuery;
	JSONObject jsonobj;
	HttpClient httpclient = new DefaultHttpClient();
	RegisterResponse registerResponse;
	String jsonStr;
	HttpResponseListener mListener;
	
	public RegisterRequest(String mobile,String Name,String Area,String Skill,String Description,HttpResponseListener listener)
	{
		super(URL,RESTAPI);
		
		mListener = listener;		
		jsonobj= new JSONObject();//GetServerAuthenticatedJSON();
		httpQuery =  new HttpPost(URL);
				
		try {			
			jsonobj.put(ServerConstants.MOBILE, mobile);
			jsonobj.put(ServerConstants.NAME, Name);
			jsonobj.put(ServerConstants.AREA, Area);
			jsonobj.put(ServerConstants.SKILL, Skill);
			jsonobj.put(ServerConstants.DESCRIPTION, Description);
			//jsonobj.put(UserAttributes.PHONE, phone);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		
		StringEntity postEntityUser = null;
		try {
			postEntityUser = new StringEntity(jsonobj.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postEntityUser.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		Logger.i(TAG, "calling server:"+jsonobj.toString());	
		httpQuery.setEntity(postEntityUser);
	}
	
	public ServerResponseBase execute() {
			//BBDTracker.sendEvent("HttpRequest",RESTAPI,"httprequest:"+RESTAPI+":execute",1L);
			try {
				response=httpclient.execute(httpQuery);
			} catch (Exception e) {
				//BBDTracker.sendEvent("HttpRequest",RESTAPI,"httprequest:"+RESTAPI+":execute:executeexception",1L);
			}
			try {
				if(response==null)
					return null;
				jsonStr = responseHandler.handleResponse(response);
			} catch (Exception e) {
				//BBDTracker.sendEvent("HttpRequest",RESTAPI,"httprequest:"+RESTAPI+":execute:responseexception",1L);
			}   
					
			registerResponse =	new RegisterResponse(response,jsonStr,RESTAPI);
			registerResponse.setReqTimeStamp(this.reqTimeStamp);
			registerResponse.setResponseListener(mListener);
			return registerResponse;		
	}
	
	

}

