package com.airportweather.rest.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils<T> {
    private final static Gson gson = new GsonBuilder().create();

    public T deserialise(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public String serialise(T object) {
        return gson.toJson(object);
    }
}
