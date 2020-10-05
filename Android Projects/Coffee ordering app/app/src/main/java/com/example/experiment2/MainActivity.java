package com.example.experiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView q = (TextView)findViewById(R.id.quantity);

        Button b1 = (Button)findViewById(R.id.decrease);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity > 1){
                    quantity -= 1;
                }
                if(quantity == 1){
                    Context context = getApplicationContext();
                    CharSequence text = "You cannot order less than 1 coffee!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
                q.setText("" + quantity);
            }
        });

        Button b2 = (Button)findViewById(R.id.increase);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity < 10){
                    quantity += 1;
                }
                q.setText("" + quantity);
            }
        });

        final EditText e1 = (EditText)findViewById(R.id.name);
        final EditText e2 = (EditText)findViewById(R.id.address);

        final CheckBox c1 = (CheckBox)findViewById(R.id.chocolate);
        final CheckBox c2 = (CheckBox)findViewById(R.id.whipped_cream);

        Button b3 = (Button)findViewById(R.id.submit);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Order placed",Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String name = "Name: " + e1.getText().toString();
                String address = "Address: " + e2.getText().toString();
                String quant = "Quantity: " + q.getText().toString();
                String price = "Price: Rs." + quantity*5;

                String toppings = "";
                if(c1.isChecked()){
                    toppings += "Has chocolate \n";
                }
                if(c2.isChecked()){
                    toppings += "Has whipped cream \n";
                }

                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //For Passing the Values to Second Activity
                i.putExtra("name_key", name);
                i.putExtra("reg_key",address);
                i.putExtra("dept_key", quant);
                i.putExtra("toppings_key",toppings);
                i.putExtra("price_key",price);

                startActivity(i);
                return false;
            }

        });
    }
}
