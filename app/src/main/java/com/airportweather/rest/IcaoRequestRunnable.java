package com.airportweather.rest;

import com.airportweather.otto.events.WeatherObservationEvent;
import com.airportweather.rest.json.JsonUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.otto.Bus;

import java.util.concurrent.Callable;

public class IcaoRequestRunnable implements Callable<WeatherObservation> {

    private static final OkHttpClient client = new OkHttpClient();
    private final String url;
    private final Bus messageBus;

    public IcaoRequestRunnable(String url, Bus messageBus) {
        this.url = url;
        this.messageBus = messageBus;
    }

    @Override
    public WeatherObservation call() throws Exception {
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        Response response = call.execute();

        if (!response.isSuccessful()) {
            WeatherObservationEvent event = new WeatherObservationEvent("Error getting airport weather data");
            messageBus.post(event);
            return null;
        }
        final String responseBody = response.body().string();
        WeatherObservationMsg deserialise = null;
        try {
            final JsonUtils<WeatherObservationMsg> jsonUtils = new JsonUtils<>();
            deserialise = jsonUtils.deserialise(responseBody, WeatherObservationMsg.class);
        } catch (Exception e) {
            handleParsingError(e);
            return null;
        }
        final WeatherObservation observation = deserialise != null ? deserialise.getWeatherObservation() : null;
        sendSuccessfullCallEvent(observation);
        return observation;
    }

    private void sendSuccessfullCallEvent(WeatherObservation observation) {
        WeatherObservationEvent event = new WeatherObservationEvent(observation);
        messageBus.post(event);
    }

    private void handleParsingError(Exception e) {
        WeatherObservationEvent event = new WeatherObservationEvent("Error in parsing weather data");
        messageBus.post(event);
        e.printStackTrace();
    }
}
