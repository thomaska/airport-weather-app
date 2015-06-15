package com.airportweather.rest;

import com.squareup.otto.Bus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GeoNameService {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final String icao;
    private final static String BASE_URL = "http://ws.geonames.org/weatherIcaoJSON?username=com.airportweather&ICAO=";
    private final Bus messageBus;

    public GeoNameService(String icao, Bus bus) {
        this.icao = icao;
        this.messageBus = bus;
    }

    public Future<WeatherObservation> executeRequest() {
        return executorService.submit(new IcaoRequestRunnable(BASE_URL + icao, messageBus));
    }

    Future<WeatherObservation> executeRequest(String url) {
        return executorService.submit(new IcaoRequestRunnable(url, messageBus));
    }
}
