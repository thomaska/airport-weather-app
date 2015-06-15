package com.airportweather.rest;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.Test;

import java.util.concurrent.Future;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class GeoNameServiceTest {

    @Test
    public void testExecuteSuccessfulRequest() throws Exception {
        MockWebServer server = new MockWebServer();
        final String response = "{\"weatherObservation\":{\"weatherCondition\":\"n/a\",\"clouds\":\"few clouds\",\"observation\":\"LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG\",\"ICAO\":\"LSZH\",\"elevation\":432,\"countryCode\":\"CH\",\"cloudsCode\":\"FEW\",\"lng\":8.533333333333333,\"temperature\":\"22\",\"dewPoint\":\"15\",\"windSpeed\":\"04\",\"humidity\":64,\"stationName\":\"Zurich-Kloten\",\"datetime\":\"2015-06-13 09:50:00\",\"lat\":47.483333333333334,\"hectoPascAltimeter\":1014}}";
        server.enqueue(new MockResponse().setBody(response));
        server.start();
        String url = server.getUrl("/").toString();
        final Future<WeatherObservation> request = new GeoNameService("LSZH").executeRequest(url);
        final WeatherObservation observation = request.get();
        final WeatherObservation expected = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", null, "04", 1014);
        assertEquals("Expected: " + expected.toString() + "  Actual: " + observation.toString(), expected, observation);
    }

    @Test
    public void testExecuteUnsuccessfulRequest() throws Exception {
        MockWebServer server = new MockWebServer();
        final String response = "ERROR";
        server.enqueue(new MockResponse().setBody(response));
        server.start();
        String url = server.getUrl("/").toString();
        final Future<WeatherObservation> request = new GeoNameService("LSZH").executeRequest(url);
        final WeatherObservation observation = request.get();
        assertNull(observation);
    }
}