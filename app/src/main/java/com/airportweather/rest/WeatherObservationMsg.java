package com.airportweather.rest;

public class WeatherObservationMsg {
    private final WeatherObservation weatherObservation;

    public WeatherObservationMsg(WeatherObservation weatherObservation) {
        this.weatherObservation = weatherObservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherObservationMsg)) return false;

        WeatherObservationMsg that = (WeatherObservationMsg) o;

        return !(weatherObservation != null ? !weatherObservation.equals(that.weatherObservation) : that.weatherObservation != null);

    }

    @Override
    public int hashCode() {
        return weatherObservation != null ? weatherObservation.hashCode() : 0;
    }
}
