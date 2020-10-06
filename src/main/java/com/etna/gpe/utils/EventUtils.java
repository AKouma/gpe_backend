package com.etna.gpe.utils;

public class EventUtils {
	
	private static String SPACE_STRING = " ";
	private static String COMA_STRING = ",";
	private static String EMPTY_STRING = "";

	public static boolean isLocation(String locateRequested, String locate) {
		
		boolean isfound = locateRequested.equalsIgnoreCase(getTownOnLocation(locate));
		System.err.println("locateRequested " + locateRequested);
		return isfound;
	}
	
	private static String getTownOnLocation(String location) {
		String town = EMPTY_STRING;
		String[] locationSplit = location.split(SPACE_STRING);
		int length = locationSplit.length;
		if(length > 1) {
			town = locationSplit[length - 2];
		}
		return town.replace(COMA_STRING, EMPTY_STRING);
	}
}
