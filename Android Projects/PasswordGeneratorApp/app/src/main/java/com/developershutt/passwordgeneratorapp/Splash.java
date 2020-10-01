package com.developershutt.passwordgeneratorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private TextView textView;
    private String title = "Password Generator App";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = findViewById(R.id.titleTextView);

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startMainActivity();
                }
            }
        });
        thread.start();

        Thread animateTitle = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder animatedText = new StringBuilder();
                    for (int i = 0; i < title.length(); i++) {
                        animatedText.append(title.charAt(i));
                        setText(animatedText.toString());
                        Thread.sleep(2000 / title.length());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animateTitle.start();
    }

    private void startMainActivity() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        });
    }

    private void setText(final String string) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(string);
            }
        });
    }
}