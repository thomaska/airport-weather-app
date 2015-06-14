package airportweather.rest.json;

import com.airportweather.rest.WeatherObservation;
import com.airportweather.rest.WeatherObservationMsg;
import com.airportweather.rest.json.JsonUtils;

import static junit.framework.TestCase.assertEquals;

public class JsonUtilsTest {

    @org.junit.Test
    public void testDeserialise() throws Exception {
        String json = "{\"weatherObservation\":{\"weatherCondition\":\"n/a\",\"clouds\":\"few clouds\",\"observation\":\"LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG\",\"ICAO\":\"LSZH\",\"elevation\":432,\"countryCode\":\"CH\",\"cloudsCode\":\"FEW\",\"lng\":8.533333333333333,\"temperature\":\"22\",\"dewPoint\":\"15\",\"windSpeed\":\"04\",\"humidity\":64,\"stationName\":\"Zurich-Kloten\",\"datetime\":\"2015-06-13 09:50:00\",\"lat\":47.483333333333334,\"hectoPascAltimeter\":1014}}";
        final WeatherObservationMsg actual = new JsonUtils<WeatherObservationMsg>().deserialise(json, WeatherObservationMsg.class);
        final WeatherObservationMsg expected = new WeatherObservationMsg(new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "n/a", null, "04", 1014));
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testSerialise() throws Exception {
        final WeatherObservationMsg observationMsg = new WeatherObservationMsg(new WeatherObservation(432, 8.533333333333333, 47.483333333333334, "LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG", "LSZH", "few clouds", "15", "FEW", "2015-06-13 09:50:00", "CH", "22", 64, "Zurich-Kloten", "Weather Observation", null, "04", 1014));
        String actual = new JsonUtils<WeatherObservationMsg>().serialise(observationMsg);
        String expected = "{\"weatherObservation\":{\"elevation\":432,\"lng\":8.533333333333333,\"lat\":47.483333333333334,\"observation\":\"LSZH 130950Z VRB04KT 9999 FEW028 SCT180 22/15 Q1014 NOSIG\",\"ICAO\":\"LSZH\",\"clouds\":\"few clouds\",\"dewPoint\":\"15\",\"cloudsCode\":\"FEW\",\"datetime\":\"2015-06-13 09:50:00\",\"countryCode\":\"CH\",\"temperature\":\"22\",\"humidity\":64,\"stationName\":\"Zurich-Kloten\",\"weatherCondition\":\"Weather Observation\",\"windSpeed\":\"04\",\"hectoPascAltimeter\":1014}}";
        assertEquals(expected, actual);
    }
}