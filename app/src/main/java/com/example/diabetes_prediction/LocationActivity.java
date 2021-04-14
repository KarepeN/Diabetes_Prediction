
package com.example.diabetes_prediction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {
    GoogleMap mgoogleMap;
    EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private void gotoLocation(double latitude, double longitude)
    {
        LatLng latLng = new LatLng(latitude,longitude);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng,18);
        mgoogleMap.moveCamera(cameraUpdate);
        mgoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    private void geolocate(View view) {
        hideKeyboard(this);
        String locationName = etSearch.getText().toString();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocationName(locationName,1);
            if (addressList.size()>0)
            {
                Address address = addressList.get(0);
                gotoLocation(address.getLatitude(),address.getLongitude());
                mgoogleMap.addMarker(new MarkerOptions().position(new LatLng(address.getLatitude(),address.getLongitude())));
                Toast.makeText(this, address.getLocality(), Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;
        mgoogleMap.setMyLocationEnabled(true);

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
