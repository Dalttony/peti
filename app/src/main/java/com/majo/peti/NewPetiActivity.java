package com.majo.peti;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import ext.AppLocationService;

public class NewPetiActivity extends AppCompatActivity implements OnMapReadyCallback, LocationSource.OnLocationChangedListener, LocationListener  {

    private SupportMapFragment frgPlace;
    private GoogleMap map;
    private Geocoder geocoder;
    private LocationManager locationManager;
    TextView newelcomemsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_peti);
        frgPlace = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        frgPlace.getMapAsync(this);

        newelcomemsg = (TextView) findViewById(R.id.newelcomemsg);
        geocoder = new Geocoder(this, Locale.getDefault());
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        AppLocationService appLocationService = new AppLocationService(NewPetiActivity.this);
        Location gpsLocation = appLocationService
                .getLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            double latitude = gpsLocation.getLatitude();
            double longitude = gpsLocation.getLongitude();
            String result = "Latitude: " + gpsLocation.getLatitude() +
                    " Longitude: " + gpsLocation.getLongitude();
            newelcomemsg.setText(result);
        }else{
            Toast.makeText(getApplicationContext(),"Dosent found",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
            this.map = googleMap;
    }

    @Override
    public void onLocationChanged(Location location) {

        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());

       double latitude = location.getLatitude();
       double longitude = location.getLongitude();

        Log.e("latitude", "latitude--" + latitude);

        try {
            Log.e("latitude", "inside latitude--" + latitude);
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();

                newelcomemsg.setText(address + " " + city + " " + country);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
           Log.i("Error",e.toString());
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
