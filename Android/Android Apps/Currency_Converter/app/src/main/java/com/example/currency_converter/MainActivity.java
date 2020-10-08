package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void converters(View view){
        EditText t=(EditText) findViewById(R.id.input);

        Button one=(Button)findViewById(R.id.button1);


        TextView text=(TextView)findViewById(R.id.result);
        String p=t.getText().toString();
        Spinner currencies=(Spinner)findViewById(R.id.currencies);
        String currency=String.valueOf(currencies.getSelectedItem());


        Spinner chooser=(Spinner)findViewById(R.id.choose);
        String choose= (String) chooser.getSelectedItem();


        double to_convert=Double.parseDouble(p);
        double result=0;

        if(choose.equals("dollar")){
            if (currency.equals("Euro")) {
                result = to_convert*0.85;
            } else if (currency.equals("Dirham")) {
                result = to_convert * 3.67;
            } else if (currency.equals("dollar")) {
                result = to_convert ;
            }
            else if (currency.equals("Indian")) {
                result = to_convert*73.16 ;
            }
        }
        else {

            if (currency.equals("Euro")) {
                result = to_convert / 89;
            } else if (currency.equals("Dirham")) {
                result = to_convert / 20.32;
            } else if (currency.equals("dollar")) {
                result = to_convert / 73.16;
            }
            else if (currency.equals("Indian")) {
                result = to_convert;
            }
        }

        String final_result=String.format("%.2f",result);


        text.setText(final_result+" "+currency);
    }

}