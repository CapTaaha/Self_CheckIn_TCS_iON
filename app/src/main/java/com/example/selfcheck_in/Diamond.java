package com.example.selfcheck_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Diamond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond);

        TextView send_text = findViewById(R.id.textView9);
        Button bookDiamond = findViewById(R.id.bookDiamond);
        bookDiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookingDia(view);
            }
        });
    }

    public void openBookingDia(View vbd){
        Intent intent = new Intent(this, Booking.class);
        startActivity(intent);
    }
}