package com.nextap.cryptosurge;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);


        if(isGpsEnabled())
        {
            GoogleMapOptions options = new GoogleMapOptions().zoomControlsEnabled(true);
            SupportMapFragment mapFragment = SupportMapFragment.newInstance(options);
            getSupportFragmentManager().beginTransaction().add(R.id.map, mapFragment).commit();
            mapFragment.getMapAsync(this);



        }
        else
            Toast.makeText(getApplicationContext(), "GPS must be enabled", Toast.LENGTH_SHORT).show();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Toast.makeText(getApplicationContext(),"User Location",Toast.LENGTH_LONG).show();

        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//
//        // show all atms near by
//        List<LatLng> list = new ArrayList<LatLng>();
//        list.add(new LatLng(40.7127, -74.0059));
//        list.add(new LatLng(33.7489954, -84.3879824));
//
//        // Polyline options
//        PolylineOptions line = new PolylineOptions();
//        line.addAll(list);
//        line.width(10);
//        line.color(0xFF0000FF);
//        line.geodesic(true);
//
//        mMap.addPolyline(line);
    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onResume() {
        super.onResume();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }

    public void getAtms(LatLng coordinates){
        StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json");
        sb.append("?keyword=atm");
        sb.append("&location="+coordinates.latitude+','+coordinates.longitude);
        sb.append("&radius="+1000);
        sb.append("&key="+getResources().getString(R.string.google_maps_key));

        String url = sb.toString();
        System.out.println("UUUUUURRRRRRRRRRLLLLLLLLLLLL "+url);

        Object dataTransfer[] = new Object[2];
        dataTransfer[0] = mMap;
        dataTransfer[1] = url;

        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
        getNearbyPlaces.execute(dataTransfer);



    }


    public boolean isGpsEnabled()
    {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        LatLng coordinates = new LatLng(location.getLatitude(),location.getLongitude());
        getAtms(coordinates);
        System.out.println("CCOORRDDIINNAATTEESS "+coordinates.latitude+" "+coordinates.longitude);
    }
}