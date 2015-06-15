package com.airportweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.airportweather.airports.SelectAirportActivity;
import com.airportweather.otto.BusProvider;
import com.airportweather.otto.events.WeatherObservationEvent;
import com.airportweather.rest.GeoNameService;
import com.squareup.otto.Subscribe;


public class ViewWeatherActivity extends AppCompatActivity {

    private static final String TAG = ViewWeatherActivity.class.getName();
    private ProgressDialog progressDialog;
    private String icao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weather);
        icao = getIntent().getStringExtra(SelectAirportActivity.ICAO_EXTRA);
    }

    private void performGeonameServiceCall() {
        GeoNameService geoNameService = new GeoNameService(icao, BusProvider.getInstance());
        geoNameService.executeRequest();
        showProgressDialog();
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(ViewWeatherActivity.this);
        progressDialog.setTitle(getString(R.string.retrieving_weather_data));
        progressDialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
        performGeonameServiceCall();
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_change_airport) {
            Intent startSelectAirportActivity = new Intent(ViewWeatherActivity.this, SelectAirportActivity.class);
            startActivity(startSelectAirportActivity);
            finish();
            return true;
        } else if (id == R.id.action_refresh) {
            performGeonameServiceCall();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void onGeonameResponseEvent(WeatherObservationEvent event) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (event.succeeded()) {
        }
    }
}
