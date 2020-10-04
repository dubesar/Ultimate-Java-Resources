package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dice;
    Button btn;
    public static final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = (ImageView)findViewById(R.id.dice);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                rotateDice();


            }
        });

    }



    private void rotateDice() {
        int i = random.nextInt(5)+1;
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        dice.startAnimation(anim);
        switch(i){
            case 1:
                dice.setImageResource(R.drawable.dice_1);
                break;

            case 2:
                dice.setImageResource(R.drawable.dice_2);
                break;

            case 3:
                dice.setImageResource(R.drawable.dice_3);
                break;

            case 4:
                dice.setImageResource(R.drawable.dice_4);
                break;

            case 5:
                dice.setImageResource(R.drawable.dice_5);
                break;

            case 6:
                dice.setImageResource(R.drawable.dice_6);
                break;
        }
    }


}