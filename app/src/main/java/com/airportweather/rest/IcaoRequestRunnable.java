package com.airportweather.rest;

import com.airportweather.rest.json.JsonUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.Callable;

public class IcaoRequestRunnable implements Callable<WeatherObservation> {

    private final OkHttpClient client = new OkHttpClient();
    private final String url;

    public IcaoRequestRunnable(String url) {
        this.url = url;
    }

    @Override
    public WeatherObservation call() throws Exception {
        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        final String responseBody = response.body().string();
        WeatherObservationMsg deserialise = null;
        try {
            final JsonUtils<WeatherObservationMsg> jsonUtils = new JsonUtils<>();
            deserialise = jsonUtils.deserialise(responseBody, WeatherObservationMsg.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deserialise != null ? deserialise.getWeatherObservation() : null;
    }
}
