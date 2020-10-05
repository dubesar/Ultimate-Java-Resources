package com.example.randomnumberapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button mButton;


    private TextView mRandomNumber;
    private EditText mMin;
    private EditText mMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMin = (EditText)findViewById(R.id.min);
        mMin.setText("1");
        mMax = (EditText)findViewById(R.id.max);
        mMax.setText("10");
        mRandomNumber = (TextView)findViewById(R.id.number);

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mMin.getText().toString().equals("") && !mMax.getText().toString().equals(""))
                {

                    int min = Integer.parseInt(mMin.getText().toString());
                    int max = Integer.parseInt(mMax.getText().toString());
                    if(max > min)
                    {
                        Random r = new Random();
                        int random_number = r.nextInt(max - min + 1) + min;
                        mRandomNumber.setText(Integer.toString(random_number));
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "Max is less than min", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Fill in all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}