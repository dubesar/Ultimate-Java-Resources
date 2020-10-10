package com.example.dollarstocents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dollarsValue;
    Button convertBtn;
    TextView centsValue;
    private int conversionFactor =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollarsValue = findViewById(R.id.editTextDollars);
        convertBtn = findViewById(R.id.convertBtn);
        centsValue = findViewById(R.id.centsValue);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entry = String.valueOf(dollarsValue.getText());

                if(TextUtils.isEmpty(entry)){
                    Toast.makeText(MainActivity.this, "Please enter a value to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }
                int cents = conversionFactor * Integer.parseInt(entry);
                centsValue.setVisibility(View.VISIBLE);
                centsValue.setText(cents + " cents");
                closeKeyboard();
            }
        });
    }
    private void closeKeyboard()
    {

        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}