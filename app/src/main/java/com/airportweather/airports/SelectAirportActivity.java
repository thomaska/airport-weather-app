package com.airportweather.airports;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.airportweather.R;
import com.airportweather.ViewWeatherActivity;
import com.airportweather.app.AirportWeatherApp;

import java.util.Set;

public class SelectAirportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_airport);
        setTitle(getResources().getString(R.string.title_activity_select_airport));
        setupList();
    }

    private void setupList() {
        ListView listView = (ListView) findViewById(R.id.lv_airportlist);
        Set<String> airports = AirportWeatherApp.getAirportNamesToICAO().keySet();
        listView.setAdapter(new AirportListAdapter(this, airports));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Intent intent = new Intent(SelectAirportActivity.this, ViewWeatherActivity.class);
                startActivity(intent);
            }
        });
    }
}
