package com.example.selfcheck_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Luxury extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luxury);

        Button bookLuxury = findViewById(R.id.bookLuxury);
        bookLuxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookingLux(view);
            }
        });
    }

    public void openBookingLux(View vbl){
        Intent intent = new Intent(this, Booking.class);
        startActivity(intent);
    }
}