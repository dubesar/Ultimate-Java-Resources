package com.example.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView t1 = (TextView) findViewById(R.id.textView1);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        TextView t3 = (TextView) findViewById(R.id.textView3);
        TextView t4 = (TextView) findViewById(R.id.textView4);
        TextView t5 = (TextView) findViewById(R.id.textView5);

        //Getting the Intent
        Intent i = getIntent();

        //Getting the Values from First Activity using the Intent received
        String name = i.getStringExtra("name_key");
        String address = i.getStringExtra("reg_key");
        String quantity = i.getStringExtra("dept_key");
        String topping = i.getStringExtra("toppings_key");
        String price = i.getStringExtra("price_key");

        //Setting the Values to Intent
        t1.setText(name);
        t2.setText(address);
        t3.setText(quantity);
        t4.setText(topping);
        t5.setText(price);
    }
}
