package com.fadhlan.tugas_sensor_10120012;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//Nama  : Muhammad Fadhlan
//NIM   : 10120012
//Kelas : IF 11

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        // check condition
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {
                //Lokasi 1
                LatLng lokasi1 = new LatLng(-6.890054362053164, 107.61626334209134);
                MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Waroeng Steak & Shake");
                //Lokasi 2
                LatLng lokasi2 = new LatLng(-6.887607515479654, 107.61517415741044);
                MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Richeese Factory");
                //Lokasi 3
                LatLng lokasi3 = new LatLng(-6.886315221475382, 107.61508296804159);
                MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Warung Nasi SPG");
                //Lokasi 4
                LatLng lokasi4 = new LatLng(-6.887936427472603, 107.61558956933784);
                MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Ayam Tulang Lunak Amboe");
                //Lokasi 5
                LatLng lokasi5 = new LatLng(-6.885852506162825, 107.61487852655199);
                MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Rumah Makan Boga Raso");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi3,17));
                googleMap.addMarker(options1);
                googleMap.addMarker(options2);
                googleMap.addMarker(options3);
                googleMap.addMarker(options4);
                googleMap.addMarker(options5);


            });
        }
        else {
            // When permission is not granted
            // Call method
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        // Return view
        return view;
    }

}