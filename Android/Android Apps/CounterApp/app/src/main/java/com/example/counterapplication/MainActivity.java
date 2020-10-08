package com.example.counterapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView counterTxt;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.plusBtn:
                    plusCounter();
                    break;
                case R.id.minusBtn:
                    minusCounter();
                    break;
                case R.id.resetBtn:
                    initCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTxt = (TextView) findViewById(R.id.counterTxt);

        minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);

        plusBtn = (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);

        resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);

        initCounter();
    }

    @SuppressLint("SetTextI18n")
    private void initCounter() {
        counter = 0;
        counterTxt.setText(counter + "");
    }

    @SuppressLint("SetTextI18n")
    private void plusCounter() {
        counter++;
        counterTxt.setText(counter + "");
    }

    private void minusCounter() {
        counter--;
        counterTxt.setText(counter);
    }
}
