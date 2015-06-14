package com.airportweather.airports;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.airportweather.R;

import java.util.ArrayList;
import java.util.Set;

public class AirportListAdapter extends ArrayAdapter<String> {
    public AirportListAdapter(Context context, Set<String> airports) {
        super(context, R.layout.airport_listitem, new ArrayList<>(airports));
    }
}
