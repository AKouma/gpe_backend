package com.etna.gpe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class LocalizationService {

	public static String LONGITUDE = "longitude";
	public static String LATITUDE = "latitude";
	private String LOCATION = "location";
	private String LAT = "lat";
	private String LNG = "lng";
	private String RESULTS = "results";
	private String GEOMETRY = "geometry";

	public Map<String, Long> execute(String address) {
		Map<String, Long> lngLat = new HashMap<>();
		HttpResponse<String> response;
		if (address != null && !address.isBlank()) {
			address = address.replace(" ", "+");

			String url = "https://maps.googleapis.com/maps/api/geocode/json?address=".concat(address)
					.concat("&key=AIzaSyAe1WPBLhSasHA1CvdEpkbOqqGOTB4d3pM");

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

			try {
				response = client.send(request, HttpResponse.BodyHandlers.ofString());

				JsonObject locateJson = new Gson().fromJson(response.body(), JsonObject.class);
				locateJson = locateJson.get(RESULTS).getAsJsonArray().get(0).getAsJsonObject().get(GEOMETRY)
						.getAsJsonObject().get(LOCATION).getAsJsonObject();
				Long longitude = locateJson.get(LNG).getAsLong();
				Long latitude = locateJson.get(LAT).getAsLong();

				lngLat.put(LONGITUDE, longitude);
				lngLat.put(LATITUDE, latitude);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lngLat;
	}
}
