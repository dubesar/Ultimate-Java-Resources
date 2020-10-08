package com.developershutt.passwordgeneratorapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView passwordTextView, passwordLenTextView;
    private Button generateButton;
    private CheckBox numberCheckBox, lowercaseCheckBox, uppercaseCheckBox, symbolCheckBox;
    private SeekBar seekBar;

    private int length = 0;
    private String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init layout items
        initLayoutItems();
    }

    private void initLayoutItems() {
        passwordTextView = findViewById(R.id.password_textview);
        passwordLenTextView = findViewById(R.id.password_len_textView);
        generateButton = findViewById(R.id.generate_button);
        numberCheckBox = findViewById(R.id.number_checkbox);
        lowercaseCheckBox = findViewById(R.id.lowercase_checkbox);
        uppercaseCheckBox = findViewById(R.id.uppercase_checkbox);
        symbolCheckBox = findViewById(R.id.symbol_checkbox);
        seekBar = findViewById(R.id.seekBar);
        seekBarHandler();
        buttonClickHandler();
        setPasswordTextListener();
    }

    private boolean isNumberIncluded() {
        return numberCheckBox.isChecked();
    }

    private boolean isLowercaseIncluded() {
        return lowercaseCheckBox.isChecked();
    }

    private boolean isUppercaseIncluded() {
        return uppercaseCheckBox.isChecked();
    }

    private boolean isSymbolIncluded() {
        return symbolCheckBox.isChecked();
    }

    private void seekBarHandler() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                passwordLenTextView.setText("Length: " + progress);
                length = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String generate() {
        PasswordHelper helper = new PasswordHelper(length);
        helper.useLowercase(isLowercaseIncluded());
        helper.useUppercase(isUppercaseIncluded());
        helper.useNumbers(isNumberIncluded());
        helper.useSymbols(isSymbolIncluded());
        return helper.generatePassword();
    }

    private void buttonClickHandler() {
        generateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        v.animate().scaleX(0.7f).scaleY(0.7f).setDuration(100).setInterpolator(new LinearInterpolator()).start();
                        return true;
                    case MotionEvent.ACTION_UP:
                        v.animate().scaleX(1).scaleY(1).setDuration(100).setInterpolator(new LinearInterpolator()).start();
                        password = generate();
                        passwordTextView.setVisibility(View.VISIBLE);
                        passwordTextView.setText(generate());
                        Toast.makeText(MainActivity.this, "Long press to copy", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
    }

    private void setPasswordTextListener() {
        passwordTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setClipboard(password);
                Toast.makeText(MainActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void setClipboard(String text) {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
        assert clipboard != null;
        clipboard.setPrimaryClip(clip);
    }
}