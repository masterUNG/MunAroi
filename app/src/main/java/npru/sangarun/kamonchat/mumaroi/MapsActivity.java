package npru.sangarun.kamonchat.mumaroi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng centerLatLng;
    private String centerString, latString, lngString;
    private double latADouble, lngADouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //Receive Value From Intent
        receiveValue();

        //Create LatLng for center Map
        createLatLng();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }   // Main Method

    private void createLatLng() {

        latADouble = Double.parseDouble(latString);
        lngADouble = Double.parseDouble(lngString);

        centerLatLng = new LatLng(latADouble, lngADouble);

    }

    private void receiveValue() {

        centerString = getIntent().getStringExtra("Name");
        latString = getIntent().getStringExtra("Lat");
        lngString = getIntent().getStringExtra("Lng");

    }   // receiveValue

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Create Center Map
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 16));

        //Create Marker for Shop
        mMap.addMarker(new MarkerOptions()
        .position(centerLatLng)
        .title(centerString));

    }   // onMapReady
}   // Main Class
