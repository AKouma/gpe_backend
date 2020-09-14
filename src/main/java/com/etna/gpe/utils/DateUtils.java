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

	public static boolean isPeriodAsked(Date searchDate1, Date searchDate2, Date eventDate) {
		boolean isPeriodAsked = false;
		long eventDateInMilli = eventDate.getTime();
		long searchDate1InMilli = searchDate1.getTime();
		long searchDate2InMilli = searchDate1.getTime();
		
		isPeriodAsked = searchDate1InMilli <= eventDateInMilli && searchDate2InMilli >= eventDateInMilli;
				
		return isPeriodAsked;
	}
	
	public static boolean isEligibled(Date searchDate1, Date searchDate2, Date eventDate) {
		boolean isEligibled = false;
		if(searchDate2 == null)
			isEligibled = isEqualDate(eventDate, searchDate1);
		else
			isEligibled = isPeriodAsked(searchDate1, searchDate2, eventDate);
		
		return isEligibled;
	}
}
