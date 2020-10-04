package com.alex.birthdayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
    }

    public void onClickCreateCard(View view) {
        final String name = etName.getText().toString();
        if (name.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.enter_the_name,
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, CongratsActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
