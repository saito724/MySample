package com.example.mysample.util;

import android.util.Log;

public class LogUtil {
	
	public static void DLog(String tag ,String msg){
		if(tag == null || tag.equals("")){
			tag = "TAG";
		}
		if(msg == null || msg.equals("")){
			msg = "msg is null or empty";
		}
		
		Log.d(tag, msg);
	}
	
	public static void DLog(String tag, int msg){
		DLog(tag, Integer.toString(msg));

	}

	public static void DLog(String tag, double msg){
		DLog(tag, Double.toString(msg));

	}
	
	public static void DLog(String tag, float msg){
		DLog(tag, Float.toString(msg));

	}
	
	public static void DLog(String tag, boolean msg){
		DLog(tag, Boolean.toString(msg));

	}
	
	public static void DLog(String tag, Object msg){
		DLog(tag, msg.toString());

	}
}
