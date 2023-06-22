package com.fadhlan.tugas_sensor_10120012;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.fadhlan.tugas_sensor_10120012.databinding.ActivityMainBinding;

//Nama  : Muhammad Fadhlan
//NIM   : 10120012
//Kelas : IF 1

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFagment(new MapsFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.maps:
                    replaceFagment(new MapsFragment());
                    break;
                case R.id.m_terdekat:
                    replaceFagment(new FoodFragment());
                    break;
                case R.id.profile:
                    replaceFagment(new ProfileFragment());
                    break;
                case R.id.info:
                    replaceFagment(new AppInfoFragment());
                    break;

            }

            return true;
        });
    }

    private void replaceFagment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBase,fragment);
        fragmentTransaction.commit();
    }
}