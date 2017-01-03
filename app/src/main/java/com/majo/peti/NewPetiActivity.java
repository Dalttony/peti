package com.majo.peti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class NewPetiActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapFragment frgPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_peti);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
