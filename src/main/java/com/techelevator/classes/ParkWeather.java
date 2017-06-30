package com.techelevator.classes;

public class ParkWeather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int lowTempF;
	private int highTempF;
	private int lowTempC;
	private int highTempC;
	private String forecast;
	private String day;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public int getLowTempF() {
		return lowTempF;
	}

	public void setLowTempF(int lowTemp) {
		this.lowTempF = lowTemp;
	}

	public int getHighTempF() {
		return highTempF;
	}

	public void setHighTempF(int highTemp) {
		this.highTempF = highTemp;
	}

	public int getLowTempC() {

		return lowTempC;
	}

	public void setLowTempC(int lowTemp) {
		this.lowTempC = (int) ((lowTemp - 32) * (5 / 9.0));

	}

	public int getHighTempC() {
		return highTempC;
	}

	public void setHighTempC(int highTemp) {
		this.highTempC = (int) ((highTemp - 32) * (5 / 9.0));
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getDay() {
		return day;
	}

	public void setDay() {
		if (this.fiveDayForecastValue == 1) {
			this.day = "Monday";
		} else if (this.fiveDayForecastValue == 2) {
			this.day = "Tuesday";
		} else if (this.fiveDayForecastValue == 3) {
			this.day = "Wednesday";
		} else if (this.fiveDayForecastValue == 4) {
			this.day = "Thursday";
		} else {
			this.day = "Friday";
		}
	}
}
