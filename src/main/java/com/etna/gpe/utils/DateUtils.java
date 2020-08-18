package com.etna.gpe.utils;

import java.util.Date;

public class DateUtils {

	public static boolean isOnline(Date eventDate) {
		
		long todayInMilliSecond = new Date().getTime();
		
		return eventDate.getTime() - todayInMilliSecond > 0;
	}
	
public static boolean isEqualDate(Date eventDate, Date searchDate) {
		
		long todayInMilliSecond = searchDate.getTime();
		
		return eventDate.getTime() - todayInMilliSecond == 0;
	}
}
