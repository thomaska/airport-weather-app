package com.airportweather.prefs;

import android.test.AndroidTestCase;

public class AppPreferencesTest extends AndroidTestCase {

    public void testGetLastIcaoNotSet() throws Exception {
        String actual = AppPreferences.getLastIcao();
        assertTrue(actual.isEmpty());
    }

    public void testSetLastIcao() throws Exception {
        String lastValue = AppPreferences.getLastIcao();
        AppPreferences.setLastIcao("KJFK");
        String actual = AppPreferences.getLastIcao();
        assertEquals("KJFK", actual);
        AppPreferences.setLastIcao(lastValue);
    }
}