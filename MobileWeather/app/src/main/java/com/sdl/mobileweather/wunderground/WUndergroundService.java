package com.sdl.mobileweather.wunderground;

import java.net.MalformedURLException;
import java.net.URL;

import com.sdl.mobileweather.artifact.WeatherLocation;
import com.sdl.mobileweather.weather.WeatherService;

public class WUndergroundService extends WeatherService {
	
	private static final String API_KEY = "";	// API key used for WUnderground API
	private static final String BASE_URL = "http://api.wunderground.com/api/";	// Base request URL for WUnderground

	public WUndergroundService() {
		super();
		mWeatherProcessor = new WUndergroundWeatherJsonProcessor();
	}
	
	@Override
	protected void updateWeatherData(URL... urls) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Creates service specific weather data URLs.
	 */
	@Override
	protected URL[] getURLs(WeatherLocation currentLocation)
	{
		URL conditionsURL = null;
		URL forecastURL = null;
		URL hourlyForecastURL = null;
		URL alertsURL = null;
		try {
			conditionsURL = new URL(BASE_URL + API_KEY +"/conditions/q/" + currentLocation.gpsLocation.latitude + "," + currentLocation.gpsLocation.longitude + ".json");
			forecastURL = new URL(BASE_URL + API_KEY +"/forecast10day/q/" + currentLocation.gpsLocation.latitude + "," + currentLocation.gpsLocation.longitude + ".json");
			hourlyForecastURL = null;
			alertsURL = null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new URL[] { conditionsURL, forecastURL, hourlyForecastURL, alertsURL };
	}

}
