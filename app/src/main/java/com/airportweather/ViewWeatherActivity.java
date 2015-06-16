package com.airportweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airportweather.airports.SelectAirportActivity;
import com.airportweather.otto.BusProvider;
import com.airportweather.otto.events.WeatherObservationEvent;
import com.airportweather.prefs.AppPreferences;
import com.airportweather.rest.GeoNameService;
import com.airportweather.rest.WeatherObservation;
import com.squareup.otto.Subscribe;


public class ViewWeatherActivity extends AppCompatActivity {

    public static final String FIRST_TIME = "FIRST_TIME";
    private ProgressDialog progressDialog;
    private String icao;
    private TextView aiportName;
    private TextView clouds;
    private TextView weatherDate;
    private TextView humidity;
    private TextView windspeed;
    private TextView temperature;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weather);
        icao = getIntent().getStringExtra(SelectAirportActivity.ICAO_EXTRA);
        initViews();
    }

    private void initViews() {
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_weather);
        aiportName = (TextView) findViewById(R.id.tv_airportname);
        temperature = (TextView) findViewById(R.id.tv_temperature);
        clouds = (TextView) findViewById(R.id.tv_clouds);
        windspeed = (TextView) findViewById(R.id.tv_windspeed);
        humidity = (TextView) findViewById(R.id.tv_humidity);
        weatherDate = (TextView) findViewById(R.id.tv_date);

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
            startSelectAirportActivity();
            return true;
        } else if (id == R.id.action_refresh) {
            performGeonameServiceCall();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startSelectAirportActivity() {
        Intent startSelectAirportActivity = new Intent(ViewWeatherActivity.this, SelectAirportActivity.class);
        startSelectAirportActivity.putExtra(FIRST_TIME, false);
        startActivity(startSelectAirportActivity);
        finish();
    }

    @Subscribe
    public void onGeonameResponseEvent(WeatherObservationEvent event) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        if (event.succeeded()) {
            relativeLayout.setVisibility(View.VISIBLE);
            AppPreferences.setLastIcao(icao);
            final WeatherObservation observation = event.getWeatherObservation();
            setValueIfNotEmpty(clouds, observation.getClouds());
            setValueIfNotEmpty(weatherDate, observation.getDatetime());
            setValueIfNotEmpty(humidity, observation.getHumidity() + "");
            setValueIfNotEmpty(temperature, observation.getTemperature());
            setValueIfNotEmpty(windspeed, observation.getWindSpeed());
            setValueIfNotEmpty(aiportName, observation.getStationName());
        } else {
            relativeLayout.setVisibility(View.GONE);
            Toast.makeText(ViewWeatherActivity.this, getString(R.string.something_went_wrong) + event.getError(), Toast.LENGTH_LONG).show();
        }
    }

    private void setValueIfNotEmpty(TextView textView, String value) {
        if (value != null) {
            textView.setText(value);
        } else {
            textView.setText("n/a");
        }
    }
}
