package com.example.selfcheck_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeAndBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_and_booking);
        Button about = findViewById(R.id.about);
        Button bookNow = findViewById(R.id.bookNow);
        Button booking = findViewById(R.id.booking);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout(view);
            }
        });

        bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRooms(view);
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBooked(view);
            }
        });
    }

    public void openAbout(View v1){
        Intent intent =new Intent(this, Hotel.class);
        startActivity(intent);
    }

    public void openRooms(View v2){
            Intent intent = new Intent(this, Rooms.class);
            startActivity(intent);
    }

    public void openBooked(View v3){
        Intent intent = new Intent(this, Booked.class);
        startActivity(intent);
    }
}