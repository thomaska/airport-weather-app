package com.airportweather.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.airportweather.R;
import com.airportweather.app.AirportWeatherApp;

public class AppPreferences {

    private static final String PROPERTY_LAST_ICAO = "PROPERTY_LAST_ICAO";
    private static final Context context = AirportWeatherApp.getContext();
    private static final SharedPreferences prefs = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    public static String getLastIcao() {
        return prefs.getString(PROPERTY_LAST_ICAO, "");
    }

    public static void setLastIcao(String icao) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_LAST_ICAO, icao);
        editor.apply();
    }
}
