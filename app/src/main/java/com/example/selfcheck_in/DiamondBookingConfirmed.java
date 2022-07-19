package com.example.selfcheck_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class DiamondBookingConfirmed extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_booking_confirmed);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(DiamondBookingConfirmed.this, WelcomeAndBooking.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }
}