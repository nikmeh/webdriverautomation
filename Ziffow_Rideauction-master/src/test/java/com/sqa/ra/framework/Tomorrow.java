package com.sqa.ra.framework;

import java.util.*;

public class Tomorrow {

	public static Date getTomorrow() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, 1); // <--
		Date tomorrow = cal.getTime();
		System.out.println(tomorrow);
		return tomorrow;
	}
	
	
	public static void main(String args[]){
		Date tomorrow = Tomorrow.getTomorrow();
		System.out.println(tomorrow);
	}
}