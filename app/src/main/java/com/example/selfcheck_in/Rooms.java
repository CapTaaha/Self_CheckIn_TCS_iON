package com.example.selfcheck_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        Button diamond = findViewById(R.id.diamond);
        Button luxury = findViewById(R.id.luxury);
        Button standard = findViewById(R.id.standard);

        diamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDiamond(view);
            }
        });

        luxury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLuxury(view);
            }
        });

        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStandard(view);
            }
        });
    }

    public void openDiamond(View vd){
        Intent intent = new Intent(this, Diamond.class);
        startActivity(intent);
    }

    public void openLuxury(View vl){
        Intent intent = new Intent(this, Luxury.class);
        startActivity(intent);
    }

    public void openStandard(View vs){
        Intent intent = new Intent(this, Standard.class);
        startActivity(intent);
    }
}