package com.servicemen.HTTPServer;

public class ServerConstants {
	
	//public static  String  SERVER_ADDRESS = "http://192.168.1.4/hopon/";
	//public static  String  SERVER_ADDRESS = "http://www.greenyatra.org/sb/";
	public static  String  SERVER_ADDRESS = "http://bhakbhosdi.com";
	public static String REGISTER="/Register";
	//public static String BEEP="/Beep";
	//public static String TRENDS="/Trends";	
	public static String CHATSERVERIP= "54.169.39.148";
	//public static String CHATADMINACKFROM = "hopin_server_ack";
	//public static String TROLLIMGLOC = "https://s3-ap-southeast-1.amazonaws.com/bbdimg/trollface/";
	
	
	public static String AppendServerIPToFBID(String fbid)
	{
		return fbid+"@"+CHATSERVERIP;
	}
	
	
	//api constants
	public static  String MOBILE = "mobile";
	public static  String NAME = "name";
	public static  String AREA = "area";
	public static  String SKILL = "skill";
	public static  String DESCRIPTION = "description";
	

}
