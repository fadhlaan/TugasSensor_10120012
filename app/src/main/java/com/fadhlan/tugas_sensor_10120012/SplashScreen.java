package com.fadhlan.tugas_sensor_10120012;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

//Nama  : Muhammad Fadhlan
//NIM   : 10120012
//Kelas : IF 1
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Menghilangkan Action Bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread thread = new Thread(){
            public  void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, SliderActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}