package com.airportweather.rest;

import java.util.Date;

public class WeatherObservation {

    private final int elevation;
    private final double lng;
    private final double lat;
    private final String observation;
    private final String ICAO;
    private final String clouds;
    private final float dewPoint;
    private final String cloudsCode;
    private final Date datetime;
    private final String countryCode;
    private final float temperature;
    private final int humidity;
    private final String stationName;
    private final String weatherCondition;
    private final int windDirection;
    private final int windSpeed;
    private final int hectoPascAltimeter;

    public WeatherObservation(int elevation, double lng, double lat, String observation, String ICAO, String clouds, float dewPoint, String cloudsCode, Date datetime, String countryCode, float temperature, int humidity, String stationName, String weatherCondition, int windDirection, int windSpeed, int hectoPascAltimeter) {
        this.elevation = elevation;
        this.lng = lng;
        this.lat = lat;
        this.observation = observation;
        this.ICAO = ICAO;
        this.clouds = clouds;
        this.dewPoint = dewPoint;
        this.cloudsCode = cloudsCode;
        this.datetime = datetime;
        this.countryCode = countryCode;
        this.temperature = temperature;
        this.humidity = humidity;
        this.stationName = stationName;
        this.weatherCondition = weatherCondition;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
        this.hectoPascAltimeter = hectoPascAltimeter;
    }

    public int getElevation() {
        return elevation;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public String getObservation() {
        return observation;
    }

    public String getICAO() {
        return ICAO;
    }

    public String getClouds() {
        return clouds;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public String getCloudsCode() {
        return cloudsCode;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getStationName() {
        return stationName;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getHectoPascAltimeter() {
        return hectoPascAltimeter;
    }
}
