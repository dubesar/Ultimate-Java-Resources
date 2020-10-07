package com.haseebahmed.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private CardView distanceCard,weightCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distanceCard = (CardView) findViewById(R.id.cardViewDistance);
        weightCard= (CardView) findViewById(R.id.cardViewWeight);
        distanceCard.setOnClickListener(this);
        weightCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;
        if(view.getId()==R.id.cardViewDistance)
        {
            i= new Intent(this,DistanceConverter.class);
            startActivity(i);

        }

        else if (view.getId()==R.id.cardViewWeight)
        {
            i= new Intent(this,WeightConverter.class);
            startActivity(i);

        }

    }
}