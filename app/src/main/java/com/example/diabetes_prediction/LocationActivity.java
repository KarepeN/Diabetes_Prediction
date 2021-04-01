package com.example.diabetes_prediction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageView imgBack;
    boolean isPermissionGranted;
    GoogleMap mgoogleMap;
    FloatingActionButton floatButton;
    private FusedLocationProviderClient mLocationClient;
    private final int GPS_REQUEST_CODE = 9001;
    EditText etSearch;
    ImageView btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        floatButton = findViewById(R.id.floatBtn);

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);

        isGPSEnabled();
        initMap();
        mLocationClient = new FusedLocationProviderClient(this);
        floatButton.setOnClickListener(v -> getCurrentLocation());

        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(v -> finish());

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


    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {
        mLocationClient.getLastLocation().addOnCompleteListener(task -> {
            if (task.isSuccessful())
            {
                Location location = task.getResult();


            }
        });
    }



    private void initMap(){
        if (isPermissionGranted)
        {

                SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
                assert supportMapFragment != null;
                supportMapFragment.getMapAsync(this);




        }
    }
    private boolean isGPSEnabled()
    {
        LocationManager locationManager  = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean provider = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (provider)
        {
            return true;
        }
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(this).
                    setTitle("GPS permission")
                    .setMessage("Gps Required for this app to work")
                    .setPositiveButton("Yes",((dialog, which) -> {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent,GPS_REQUEST_CODE);
                    })).setCancelable(false)
                    .show();


        }
        return false;
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}