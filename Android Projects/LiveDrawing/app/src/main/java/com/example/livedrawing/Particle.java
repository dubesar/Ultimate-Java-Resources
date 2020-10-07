package com.example.livedrawing;

import android.graphics.PointF;

public class Particle {
    PointF mVelocity;
    PointF mPosition;

    Particle(PointF direction) {

        mVelocity = new PointF();
        mPosition = new PointF();

        // Determine the direction
        mVelocity.x = direction.x;
        mVelocity.y = direction.y;
    }

    public void update(float fps){
        mPosition.x += mVelocity.x;
        mPosition.y += mVelocity.y;
    }

    public void setmPosition(PointF position) {
        mPosition.x = position.x;
        mPosition.y = position.y;
    }

    PointF getmPosition() {
        return mPosition;
    }
}
