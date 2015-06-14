package com.airportweather.app;

import android.test.ApplicationTestCase;

import com.airportweather.R;

import java.util.Map;


public class AirportWeatherAppTest extends ApplicationTestCase<AirportWeatherApp> {
    public AirportWeatherAppTest() {
        super(AirportWeatherApp.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createApplication();
    }

    public void testContextNotNull() throws Exception {
        assertNotNull(AirportWeatherApp.getContext());
    }

    public void testGetString() throws Exception {
        final String actual = AirportWeatherApp.getContext().getString(R.string.test);
        assertEquals("Test", actual);
    }

    public void testGetAirportNamesToICAOForExistingValue() throws Exception {
        final Map<String, String> airportNamesToICAO = AirportWeatherApp.getAirportNamesToICAO();
        assertNotNull(airportNamesToICAO);
        final String actual = airportNamesToICAO.get("Eleftherios Venizelos Intl Athens Greece ATH");
        assertEquals("LGAV", actual);
    }

    public void testGetAirportNamesToICAOForNonExistingValue() throws Exception {
        final Map<String, String> airportNamesToICAO = AirportWeatherApp.getAirportNamesToICAO();
        assertNotNull(airportNamesToICAO);
        final String actual = airportNamesToICAO.get("INVALID VALUE 1");
        assertNull(actual);
    }
}