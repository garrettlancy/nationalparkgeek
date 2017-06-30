package com.techelevator.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.classes.ParkWeather;
import com.techelevator.dao.ParkWeatherDao;

@Component
public class JdbcParkWeatherDao implements ParkWeatherDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkWeatherDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private ParkWeather mapRowToParkWeather(SqlRowSet results) {
		ParkWeather weather = new ParkWeather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		weather.setLowTempF(results.getInt("low"));
		weather.setHighTempF(results.getInt("high"));
		weather.setLowTempC(results.getInt("low"));
		weather.setHighTempC(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		weather.setDay();

		return weather;
	}

	@Override
	public List<ParkWeather> getWeatherByParkCode(String parkCode) {
		SqlRowSet result = jdbcTemplate
				.queryForRowSet("SELECT * FROM weather WHERE parkcode=? ORDER BY fivedayforecastvalue ASC", parkCode);
		List<ParkWeather> parkWeather = new ArrayList<>();
		while (result.next()) {
			ParkWeather weather = mapRowToParkWeather(result);
			parkWeather.add(weather);
		}
		return parkWeather;
	}

}
