package com.binnarytodecimal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout inputBinary;
    TextInputEditText txtBinary;
    MaterialButton btnConvert;
    TextView tvDecimalOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputBinary = findViewById(R.id.inputBinary);
        txtBinary = findViewById(R.id.txtBinary);
        btnConvert = findViewById(R.id.btnConvert);
        tvDecimalOutput = findViewById(R.id.tvDecimalOutput);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processBinaryToDecimalConvert();
            }
        });
    }

    private void processBinaryToDecimalConvert() {
        if (txtBinary.getText() == null) {
            Toast.makeText(this, "Enter Binary Number", Toast.LENGTH_SHORT).show();
            return;
        }
        String s = txtBinary.getText().toString().trim();
        if (s.isEmpty()) {
            Toast.makeText(this, "Enter Binary Number", Toast.LENGTH_SHORT).show();
            return;
        }

        char[] chars = s.toCharArray();

        int j = chars.length - 1;
        long outPut = 0;
        for (char digit : chars) {
            outPut = (long) (outPut + Integer.parseInt(String.valueOf(digit)) * Math.pow(2, j));
            j--;
        }

        tvDecimalOutput.setText(String.valueOf(outPut));
    }
}