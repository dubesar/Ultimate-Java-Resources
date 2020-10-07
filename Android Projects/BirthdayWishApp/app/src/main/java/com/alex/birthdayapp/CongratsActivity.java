package com.alex.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CongratsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        final String name = getIntent().getStringExtra("name");
        TextView tvCongratulations = findViewById(R.id.tvCongrats);
        tvCongratulations.setText("Happy Birthday,\n"+name + "!");
    }
}
