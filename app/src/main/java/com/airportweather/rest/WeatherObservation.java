package com.airportweather.rest;

public class WeatherObservation {

    private final Integer elevation;
    private final Double lng;
    private final Double lat;
    private final String observation;
    private final String ICAO;
    private final String clouds;
    private final String dewPoint;
    private final String cloudsCode;
    private final String datetime;
    private final String countryCode;
    private final String temperature;
    private final Integer humidity;
    private final String stationName;
    private final String weatherCondition;
    private final Integer windDirection;
    private final String windSpeed;
    private final Integer hectoPascAltimeter;

    public WeatherObservation(Integer elevation, Double lng, Double lat, String observation, String ICAO, String clouds, String dewPoint, String cloudsCode, String datetime, String countryCode, String temperature, Integer humidity, String stationName, String weatherCondition, Integer windDirection, String windSpeed, Integer hectoPascAltimeter) {
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

    public Integer getElevation() {
        return elevation;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
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

    public String getDewPoint() {
        return dewPoint;
    }

    public String getCloudsCode() {
        return cloudsCode;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getStationName() {
        return stationName;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public Integer getHectoPascAltimeter() {
        return hectoPascAltimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherObservation)) return false;

        WeatherObservation that = (WeatherObservation) o;

        if (elevation != null ? !elevation.equals(that.elevation) : that.elevation != null)
            return false;
        if (lng != null ? !lng.equals(that.lng) : that.lng != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (!observation.equals(that.observation)) return false;
        if (!ICAO.equals(that.ICAO)) return false;
        if (clouds != null ? !clouds.equals(that.clouds) : that.clouds != null) return false;
        if (dewPoint != null ? !dewPoint.equals(that.dewPoint) : that.dewPoint != null)
            return false;
        if (cloudsCode != null ? !cloudsCode.equals(that.cloudsCode) : that.cloudsCode != null)
            return false;
        if (datetime != null ? !datetime.equals(that.datetime) : that.datetime != null)
            return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null)
            return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null)
            return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null)
            return false;
        if (stationName != null ? !stationName.equals(that.stationName) : that.stationName != null)
            return false;
        if (weatherCondition != null ? !weatherCondition.equals(that.weatherCondition) : that.weatherCondition != null)
            return false;
        if (windDirection != null ? !windDirection.equals(that.windDirection) : that.windDirection != null)
            return false;
        if (windSpeed != null ? !windSpeed.equals(that.windSpeed) : that.windSpeed != null)
            return false;
        return !(hectoPascAltimeter != null ? !hectoPascAltimeter.equals(that.hectoPascAltimeter) : that.hectoPascAltimeter != null);

    }

    @Override
    public int hashCode() {
        int result = elevation != null ? elevation.hashCode() : 0;
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + observation.hashCode();
        result = 31 * result + ICAO.hashCode();
        result = 31 * result + (clouds != null ? clouds.hashCode() : 0);
        result = 31 * result + (dewPoint != null ? dewPoint.hashCode() : 0);
        result = 31 * result + (cloudsCode != null ? cloudsCode.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
        result = 31 * result + (weatherCondition != null ? weatherCondition.hashCode() : 0);
        result = 31 * result + (windDirection != null ? windDirection.hashCode() : 0);
        result = 31 * result + (windSpeed != null ? windSpeed.hashCode() : 0);
        result = 31 * result + (hectoPascAltimeter != null ? hectoPascAltimeter.hashCode() : 0);
        return result;
    }
}
