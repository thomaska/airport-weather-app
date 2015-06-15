package com.airportweather.otto.events;

import com.airportweather.rest.WeatherObservation;

public class WeatherObservationEvent {
    private final boolean succeeded;
    private final WeatherObservation weatherObservation;
    private final String error;

    public WeatherObservationEvent(WeatherObservation weatherObservation) {
        if (weatherObservation != null) {
            this.succeeded = true;
            this.weatherObservation = weatherObservation;
            this.error = "";
        } else {
            this.succeeded = false;
            this.weatherObservation = null;
            this.error = "";
        }
    }

    public WeatherObservationEvent(String error) {
        this.succeeded = false;
        this.weatherObservation = null;
        this.error = error;
    }

    public boolean succeeded() {
        return succeeded;
    }

    public WeatherObservation getWeatherObservation() {
        return weatherObservation;
    }

    public String getError() {
        return error;
    }
}
