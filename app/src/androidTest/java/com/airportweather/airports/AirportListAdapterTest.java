package com.airportweather.airports;

import android.test.AndroidTestCase;

import java.util.Set;
import java.util.TreeSet;

public class AirportListAdapterTest extends AndroidTestCase {

    private AirportListAdapter adapter;

    public void setUp() throws Exception {
        super.setUp();
        Set<String> items = new TreeSet<>();
        items.add("Row0");
        items.add("Row1");
        items.add("Row2");
        adapter = new AirportListAdapter(getContext(), items);
    }

    public void testGetItem() {
        assertEquals("Row0 was expected.", "Row0", adapter.getItem(0));
    }

    public void testGetCount() {
        assertEquals("List size is incorrect.", 3, adapter.getCount());
    }
}