package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etHeight,etWeight;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight=findViewById(R.id.etHeight);
        etWeight=findViewById(R.id.etWeight);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String H=etHeight.getText().toString().trim();
                String W=etWeight.getText().toString().trim();
                double height=Double.parseDouble(H);
                double weight=Double.parseDouble(W);
                if(H.equals("") || W.equals("")) {
                    Toast.makeText(MainActivity.this,"please fill the  data",Toast.LENGTH_SHORT).show();
                } else {
                    String predict,bmiResult;
                    height=height/100.0;
                    double bmiCal = weight/(height*height);
                    bmiResult=String.format("%.2f",bmiCal);
                    if(bmiCal<18.5) predict="Underweight";
                    else if(bmiCal>=18.5 && bmiCal<25) predict="Normal";
                    else if(bmiCal>=25 && bmiCal<30) predict="Overweight";
                    else predict="Obese";
                    tvResult.setText("Your BMI is "+bmiResult+"("+predict+")");
                }
            }
        });
    }
}
