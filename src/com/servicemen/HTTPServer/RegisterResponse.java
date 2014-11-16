package com.servicemen.HTTPServer;

import org.apache.http.HttpResponse;
import org.json.JSONException;

import android.util.Log;

import com.servicemen.HTTPClient.HttpResponseListener;
import com.servicemen.HelperClasses.ProgressHandler;
import com.servicemen.HelperClasses.ToastTracker;
import com.servicemen.Platform.Platform;
import com.servicemen.Utils.Logger;

public class RegisterResponse extends ServerResponseBase{

		
	private static final String TAG = "com.servicemen.Server.RegisterResponse";
	public RegisterResponse(HttpResponse response,String jobjStr,String api) {
		super(response,jobjStr,api);		
	}
	
	@Override
	public void process() {
		Logger.i(TAG,"processing RegisterResponse response.status:"+this.getStatus());
		
		Logger.i(TAG,"got json "+jobj.toString());		
		try {
			body = jobj.getJSONObject("body");
			String name = body.getString(ServerConstants.NAME);
			ToastTracker.showToast(name + " successfully registered");
						
			HttpResponseListener listener = getResponseListener();
			if(listener!=null)
				listener.onComplete(body);
			
			logSuccess();
		} catch (JSONException e) {
			logServererror();
			if (Platform.getInstance().isLoggingEnabled()) Log.e(TAG, "Error returned by server on user add");
			ProgressHandler.dismissDialoge();
			ToastTracker.showToast("Unable to register, try again later");
			e.printStackTrace();
		}
		
	}
		
   }
