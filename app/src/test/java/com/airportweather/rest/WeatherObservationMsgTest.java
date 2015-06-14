package com.airportweather.rest;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WeatherObservationMsgTest {

    @Test
    public void testEqualsForEqualObjects() throws Exception {
        final WeatherObservation observation = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservation observation2 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservationMsg obsrvMsg = new WeatherObservationMsg(observation);
        final WeatherObservationMsg obsrvMsg2 = new WeatherObservationMsg(observation2);
        assertEquals(obsrvMsg, obsrvMsg2);
    }

    @Test
    public void testEqualsForNonEqualObjects() throws Exception {
        final WeatherObservation observation = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservation observation2 = new WeatherObservation(432, 10d, 10d, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservationMsg obsrvMsg = new WeatherObservationMsg(observation);
        final WeatherObservationMsg obsrvMsg2 = new WeatherObservationMsg(observation2);
        assertNotEquals(obsrvMsg, obsrvMsg2);
    }

    @Test
    public void testHashCode() throws Exception {
        final WeatherObservation observation = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservation observation2 = new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", 0, "04", 1014);
        final WeatherObservationMsg obsrvMsg = new WeatherObservationMsg(observation);
        final WeatherObservationMsg obsrvMsg2 = new WeatherObservationMsg(observation2);
        assertEquals(obsrvMsg.hashCode(), obsrvMsg2.hashCode());
    }
}