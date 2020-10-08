package com.thegeekylad.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * Once user clicks on the play button, an intent is created that launches GameActivity
         * The intent carries along a value, which indicates who would start playing first, i.e. X or )
         * NOTE: The logic on GameActivity associates player 'X' with index 0 and player 'O' with index 1 (see array 'players' on GameActivity)
         */
        findViewById(R.id.startGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("startPlayer", ((RadioGroup) findViewById(R.id.playerSelectorRadio)).getCheckedRadioButtonId() == R.id.playerX ? 0 : 1);
                startActivity(intent);
            }
        });

    }
}