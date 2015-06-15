package com.airportweather.airports;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.airportweather.R;
import com.airportweather.ViewWeatherActivity;
import com.airportweather.app.AirportWeatherApp;

import java.util.Set;

public class SelectAirportActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public static final String ICAO_EXTRA = "ICAO_EXTRA";
    private AirportListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_airport);
        setupList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_airport, menu);
        setupSearchView(menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView(Menu menu) {
        final View actionView = MenuItemCompat.getActionView(menu.findItem(R.id.custom_actionbar));

        SearchView searchView = (SearchView) actionView.findViewById(R.id.sv_search_airport);
        final TextView title = (TextView) actionView.findViewById(R.id.tv_title);
        searchView.setQueryHint(getString(R.string.search_by_airport_name_andor_location));
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                title.setVisibility(View.VISIBLE);
                return false;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setVisibility(View.GONE);
            }
        });
    }

    private void setupList() {
        final ListView listView = (ListView) findViewById(R.id.lv_airportlist);
        Set<String> airports = AirportWeatherApp.getAirportNamesToICAO().keySet();
        adapter = new AirportListAdapter(this, airports);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String key = adapter.getItem(i);
                final String ICAO = AirportWeatherApp.getAirportNamesToICAO().get(key);
                final Intent intent = new Intent(SelectAirportActivity.this, ViewWeatherActivity.class);
                intent.putExtra(ICAO_EXTRA, ICAO);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }
}
