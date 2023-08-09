package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // SupportMapFragment를 비동기로 가져옴
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapContainer);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        LatLng KKU = new LatLng(37.33, 126.57);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(KKU);
        markerOptions.title("경기대");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(KKU));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
