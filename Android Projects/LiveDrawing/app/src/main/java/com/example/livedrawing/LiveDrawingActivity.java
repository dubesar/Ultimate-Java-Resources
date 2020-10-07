package com.example.livedrawing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class LiveDrawingActivity extends AppCompatActivity {

    private LiveDrawingView mLiveDrawingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mLiveDrawingView = new LiveDrawingView(this, size.x,size.y);
        setContentView(mLiveDrawingView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // More code here later in the chapter
        mLiveDrawingView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // More code here later in the chapter
        mLiveDrawingView.pause();
    }
}