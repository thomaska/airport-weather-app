package com.airportweather.rest;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WeatherObservationTest {

    @Test
    public void testEqualsForEqualObjects() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        WeatherObservation observation2 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        assertEquals(observation1, observation2);
    }

    @Test
    public void testEqualsForNonEqualObjects() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        WeatherObservation observation2 = new WeatherObservation(111, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        assertNotEquals(observation1, observation2);
    }

    @Test
    public void testEqualsForEqualObjectsWithNull() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(null, null, null, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", null, null, null, null, null, null, null, null, null, null, null, null);
        WeatherObservation observation2 = new WeatherObservation(null, null, null, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", null, null, null, null, null, null, null, null, null, null, null, null);
        assertEquals(observation1, observation2);
    }

    @Test
    public void testEqualsForNull() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        assertFalse(observation1.equals(null));
    }

    @Test
    public void testHashCode() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        WeatherObservation observation2 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        assertEquals(observation1.hashCode(), observation2.hashCode());
    }

    @Test
    public void testHashCodeForEqualObjectsWithNull() throws Exception {
        WeatherObservation observation1 = new WeatherObservation(null, null, null, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", null, null, null, null, null, null, null, null, null, null, null, null);
        WeatherObservation observation2 = new WeatherObservation(null, null, null, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", null, null, null, null, null, null, null, null, null, null, null, null);
        assertEquals(observation1.hashCode(), observation2.hashCode());
    }

    @Test
    public void testGetters() throws Exception {
        WeatherObservation obsrv = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", null);
        assertEquals("few clouds", obsrv.getClouds());
        assertEquals("FEW", obsrv.getCloudsCode());
        assertEquals("CH", obsrv.getCountryCode());
        assertEquals("2015-06-13 09:50:00", obsrv.getDatetime());
        assertEquals("15", obsrv.getDewPoint());
        assertEquals("LSZH", obsrv.getICAO());
        assertEquals("LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", obsrv.getObservation());
        assertEquals(Integer.valueOf(432), obsrv.getElevation());
        assertEquals(null, obsrv.getHectoPascAltimeter());
        assertEquals(Integer.valueOf(64), obsrv.getHumidity());
        assertEquals("22", obsrv.getTemperature());
        assertEquals(Integer.valueOf(0), obsrv.getWindDirection());
        assertEquals("04", obsrv.getWindSpeed());
        assertEquals("Zurich-Kloten", obsrv.getStationName());
        assertEquals(Double.valueOf(8.533333333333333), obsrv.getLng());
        assertEquals(Double.valueOf(47.483333333333334), obsrv.getLat());
        Assert.assertEquals("n/a", obsrv.getWeatherCondition());
    }
}