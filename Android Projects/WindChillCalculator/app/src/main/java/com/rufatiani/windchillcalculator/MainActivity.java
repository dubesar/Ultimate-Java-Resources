package com.rufatiani.windchillcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etTemp, etSpeed;
    private Button btnCalculate;
    private TextView tvResultSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSpeed = findViewById(R.id.etWindSpeed);
        etTemp = findViewById(R.id.etTemperature);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResultSpeed = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTemp.getText().toString().equals("") && etSpeed.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "You must fill the temperature and speed!", Toast.LENGTH_SHORT).show();
                }else if (etSpeed.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "You must fill the speed!", Toast.LENGTH_SHORT).show();
                }else if (etTemp.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "You must fill the temperature!", Toast.LENGTH_SHORT).show();
                }else{
                    if (Double.valueOf(etTemp.getText().toString()).compareTo(50.0) > 0 || Double.valueOf(etTemp.getText().toString()).compareTo(-50.0) < 0){
                        Toast.makeText(getApplicationContext(), "Only can convert between -50 - 50 °F!", Toast.LENGTH_SHORT).show();
                    }else {
                        tvResultSpeed.setText(String.valueOf(calculateWindChillWattsPerMeterSquared(Double.parseDouble(etTemp.getText().toString()), Double.parseDouble(etSpeed.getText().toString()))));
                    }

                }
            }
        });
    }

    private Double calculateWindChill(Double temp, Double windSpeed){
        return 35.74 + (0.6215 * temp) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * temp * Math.pow(windSpeed, 0.16));
    }

    private Double calculateWindChillWattsPerMeterSquared(Double temp, Double windSpeed){
        temp = fahrenheitToCelcius(temp);
        windSpeed = mphToMps(windSpeed);
        return (12.1452 + 11.6222 * Math.sqrt(windSpeed) - 1.16222 * windSpeed) * (33 - temp);
    }

    private Double fahrenheitToCelcius(Double temp){
        return (9/5) * temp + 32;
    }

    private Double mphToMps(Double speed){
        return 0.44704 * speed;
    }
}