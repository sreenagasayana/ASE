package com.example.jayantis.team22icp5;

import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public abstract class MyMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public Bitmap bm;
    private GoogleMap mMap;
    public Geocoder geocoder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

    private void onMapReady(Location location) {
        String straddr=markerPosition(location);
        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title(straddr);
        CameraUpdate center= CameraUpdateFactory.newLatLng(new LatLng(currentLatitude, currentLongitude));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(13);
        mMap.addMarker(options);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
    public String markerPosition(Location location)
    {
        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        String address = "";
        Geocoder geoCoder= new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geoCoder
                    .getFromLocation(currentLatitude, currentLongitude, 1);
            if (addressList != null) {
                android.location.Address returnedAddress = addressList.get(0);
                StringBuilder returnedAddrress = new StringBuilder("");
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    returnedAddrress
                            .append(returnedAddress.getAddressLine(i)).append(
                            "\n");
                }
                address = returnedAddrress.toString();
            } else {
                Log.d("Error", "Address null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }
    /**@Override
    public void onMapReady (GoogleMap googleMap){

    // Add a marker in Sydney, Australia,
    // and move the map's camera to the same location.
    LatLng sydney = new LatLng(-33.852, 151.211);
    googleMap.addMarker(new MarkerOptions().position(sydney)
    .title("Marker in Sydney"));
    googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    } **/
}
