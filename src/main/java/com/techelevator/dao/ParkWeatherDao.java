package com.techelevator.dao;

import java.util.List;

import com.techelevator.classes.ParkWeather;

public interface ParkWeatherDao {

	public List<ParkWeather> getWeatherByParkCode(String parkCode);

}
