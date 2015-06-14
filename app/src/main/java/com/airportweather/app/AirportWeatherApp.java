package com.airportweather.app;

import android.app.Application;
import android.content.Context;
import android.content.res.XmlResourceParser;

import com.airportweather.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.Map;


public class AirportWeatherApp extends Application {

    private static final String TAG = AirportWeatherApp.class.getName();
    private static final String ENTRY = "entry";
    private static final String KEY = "key";
    private static Context context;
    private static Map<String, String> airportNamesToICAO;


    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        airportNamesToICAO = getHashMapResource(context, R.xml.airport_names_to_icao_map);
        int i = 0;
        i++;
    }

    public static Map<String, String> getAirportNamesToICAO() {
        return airportNamesToICAO;
    }

    public static Context getContext() {
        return context;
    }

    private static Map<String, String> getHashMapResource(Context context, int hashMapResId) {
        Map<String, String> map = new HashMap<>();
        XmlResourceParser parser = context.getResources().getXml(hashMapResId);

        String key = null, value = null;

        try {
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (parser.getName().equals(ENTRY)) {
                        key = parser.getAttributeValue(null, KEY);

                        if (null == key) {
                            parser.close();
                            return null;
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (parser.getName().equals(ENTRY)) {
                        map.put(key, value);
                        key = null;
                        value = null;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (null != key) {
                        value = parser.getText();
                    }
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }
}