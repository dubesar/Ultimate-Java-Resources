package com.example.weatherreport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    private final int PERMISSION_ID = 44 ;
    private final float KELVIN_CONSTANT = (float) 273.00;

    private TextView cityView;
    private TextView temperatureView;
    private FusedLocationProviderClient mFusedLocationClient;
    private String latitude;
    private String longitude;

    private WeatherAsyncTask networkTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        getLastLocation();
        cityView = (TextView) findViewById(R.id.City);
        temperatureView = (TextView) findViewById(R.id.Temperature);

        networkTask = new WeatherAsyncTask();
    }

    public class WeatherAsyncTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... location) {
            Weather weather = QueryUtils.fetchWeather(location[0], location[1]);
            return weather;
        }

        protected void onPostExecute(Weather weather) {
            if (weather!=null) {
                cityView.setText(weather.getCity());
                temperatureView.setText(kelvinToCelsius(weather.getTemperature())+"\u2103");
            }
        }
    }

    public String kelvinToCelsius(String kelvin) {
        float celsius = (float) Float.parseFloat(kelvin);
        celsius = (float) (celsius - KELVIN_CONSTANT);
        return String.valueOf(Math.round((celsius)));
    }

    private void getLastLocation()
    {
        // check if permissions are given
        if (checkPermission()) {

            // check if location is enabled
            if (isLocationEnabled()) {

                // getting last location from FusedLocationClient object
                mFusedLocationClient
                        .getLastLocation()
                        .addOnCompleteListener(
                                new OnCompleteListener<Location>() {

                                    @Override
                                    public void onComplete(@NonNull Task<Location> task)
                                    {
                                        Location location = task.getResult();
                                        if (location == null) {
                                            requestNewLocationData();
                                        }
                                        else {
                                            latitude =  String.valueOf(location.getLatitude());
                                            longitude = String.valueOf(location.getLongitude());
                                            networkTask.execute(latitude, longitude);
                                        }
                                    }
                                });
            }

            else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        }
        else {
            // if permissions aren't available,
            // request for permissions
            requestPermissions();
        }
    }

    // method to check for permissions
    private boolean checkPermission()
    {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled()
    {
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    private void requestPermissions()
    {
        ActivityCompat.requestPermissions(
                this,
                new String[] {
                        Manifest.permission
                                .ACCESS_COARSE_LOCATION,
                        Manifest.permission
                                .ACCESS_FINE_LOCATION },
                PERMISSION_ID);
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData()
    {
        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult)
        {
            Location mLastLocation
                    = locationResult
                    .getLastLocation();
            latitude =  String.valueOf(mLastLocation.getLatitude());
            longitude = String.valueOf(mLastLocation.getLongitude());
            networkTask.execute(latitude, longitude);
        }
    };
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(
                        requestCode,
                        permissions,
                        grantResults);

        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0
                    && grantResults[0]
                    == PackageManager
                    .PERMISSION_GRANTED) {

                getLastLocation();
            }
        }
    }
}