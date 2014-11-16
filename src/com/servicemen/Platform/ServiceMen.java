package com.servicemen.Platform;



import android.app.Application;

import com.servicemen.Utils.Logger;

 
public class ServiceMen extends Application{	
	
	private static final String TAG = "com.servicemen.Platform.BhakBhosdi";
		
	@Override
	public void onCreate()
	{		
		super.onCreate();
		//ACRA.init(this);
		Logger.i(TAG,"App start");
		getApplicationContext();		
		Platform.getInstance().initialize(this);
		//Platform.getInstance().startChatService();
        //Platform.getInstance().startUploadEventService();
        //if (!StringUtils.isEmpty(ThisUserConfig.getInstance().getString(ThisUserConfig.USERID))) {
        //	Platform.getInstance().startGCMService();
        //}
        //else userid has not been set yet, service will be started after add user response is received.

		//we check on userid which we wipe out on fb logout. User may login as another user
		//for which we will provide different userid		
		Logger.i(TAG,"Platform initialized");
		
	}

}
