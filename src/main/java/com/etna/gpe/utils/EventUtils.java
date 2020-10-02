package com.etna.gpe.utils;

public class EventUtils {
	
	private static String SPACE_STRING = " ";
	private static String COMA_PLUS_SPACE_STRING = ", ";
	private static String COMA_STRING = ",";
	private static String EMPTY_STRING = "";

	public static boolean isLocation(String locateRequested, String locate) {
		
		boolean isfound = locateRequested.equalsIgnoreCase(
				getCountryOnLocation(locate).equals(EMPTY_STRING) ?
				getTownOnLocation(locate) : 	
				getTownOnLocation(locate) + COMA_PLUS_SPACE_STRING + getCountryOnLocation(locate));
		System.err.println("locateRequested " + locateRequested);
		System.err.println("locate " + getTownOnLocation(locate) + COMA_PLUS_SPACE_STRING + getCountryOnLocation(locate));
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
	
	private static String getCountryOnLocation(String location) {
		String country = EMPTY_STRING;
		String[] locationSplit = location.split(COMA_PLUS_SPACE_STRING);
		int length = locationSplit.length;
		if(length > 1) {
			country = locationSplit[length - 1];
		}
		return country;
	}
}
