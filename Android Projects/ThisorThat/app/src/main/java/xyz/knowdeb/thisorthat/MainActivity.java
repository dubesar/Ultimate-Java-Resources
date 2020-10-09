package xyz.knowdeb.thisorthat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView leftImg;
    ImageView rightImg;
    private static Random randomGenerator = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        leftImg = findViewById(R.id.leftImg);
        rightImg = findViewById(R.id.rightImg);

        leftImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage();
            }
        });

        rightImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage();
            }
        });

    }

    private void changeImage() {
        int leftRandom = 1 + randomGenerator.nextInt(5);
        int rightRandom = 1 + randomGenerator.nextInt(5);

        leftImg.setImageDrawable(getResources().getDrawable(selectImage(leftRandom)));
        rightImg.setImageDrawable(getResources().getDrawable(selectImage(rightRandom)));

    }

    private int selectImage (int number) {
        switch (number) {
            case 1:
                return R.drawable.a1;

            case 2:
                return R.drawable.a2;

            case 3:
                return R.drawable.a3;

            case 4:
                return R.drawable.a4;

            case 5:
                return R.drawable.a5;
        }
        return R.drawable.a1;
    }

}