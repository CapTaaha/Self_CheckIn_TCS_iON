package com.example.selfcheck_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Standard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        TextView send_text = findViewById(R.id.textView9);
        Button bookStandard = findViewById(R.id.bookStan);
        bookStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookingStan(view);
            }
        });
    }

    public void openBookingStan(View vbs){
        Intent intent = new Intent(this, Booking.class);
        startActivity(intent);
    }
}