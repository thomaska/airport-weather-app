package com.airportweather.airports;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;

import com.airportweather.R;
import com.airportweather.ViewWeatherActivity;
import com.airportweather.app.AirportWeatherApp;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class SelectAirportActivityTest extends ActivityInstrumentationTestCase2<SelectAirportActivity> {

    private SelectAirportActivity activity;

    @SuppressWarnings("deprecation")
    public SelectAirportActivityTest() {
        super("com.dropamemo.map", SelectAirportActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        activity = getActivity();
    }

    public void testContainsList() throws Exception {
        ListView listView = (ListView) activity.findViewById(R.id.lv_airportlist);
        assertNotNull(listView);
    }

    public void testClickOnItemStartsViewWeatherActivity() throws Exception {
        final ListView listView = (ListView) activity.findViewById(R.id.lv_airportlist);
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ViewWeatherActivity.class.getName(), null, false);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                listView.performItemClick(listView.getAdapter().getView(0, null, null),
                        0, listView.getAdapter().getItemId(0));
            }
        });

        getInstrumentation().waitForIdleSync();
        Activity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 10000);
        assertNotNull(nextActivity);
        assertTrue(nextActivity instanceof ViewWeatherActivity);
        nextActivity.finish();
    }

    public void testListContainsAllMappings() throws Exception {
        final ListView listView = (ListView) activity.findViewById(R.id.lv_airportlist);
        final int numberOfElementsInList = listView.getAdapter().getCount();
        final int expected = AirportWeatherApp.getAirportNamesToICAO().size();
        assertEquals(expected, numberOfElementsInList);
    }

    public void testSearchViewFiltersList() throws Exception {
        onView(withId(R.id.sv_search_airport)).perform(click(), typeText("Thessaloniki"));
        onView(withText("Makedonia Thessaloniki Greece SKG")).check(matches(isDisplayed()));
    }
}