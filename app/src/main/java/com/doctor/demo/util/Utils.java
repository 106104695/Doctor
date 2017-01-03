package com.doctor.demo.util;

public class Utils {

	private static long lastClickTime;
	public synchronized static boolean isFastClick() {
		long time = System.currentTimeMillis();
		if ( time - lastClickTime < 500) {
			return true;
		}
		lastClickTime = time;
		return false;
	}

}
