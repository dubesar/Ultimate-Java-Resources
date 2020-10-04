package com.example.livedrawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ParticleSystem {
    public boolean mColor = false;
    public int mSize = 1;
    private float mDuration;
    private ArrayList<Particle> mParticles;
    private Random random = new Random(); // this is used a lot... so instanciated here
     boolean mIsRunning = false;

     void init( int numParticles) {
        mParticles = new ArrayList<>();

        for(int i=0; i<numParticles ;i++) {
            float angle = random.nextInt(360);
            angle =3.14f/180;

            //for slow particles
            //float speed = random.nextFloat()/10;

            //for fast particles
            float speed = random.nextInt() + 1 ;

            PointF direction =  new PointF((float)Math.cos(angle) * speed, (float)Math.sin(angle) * speed);

            mParticles.add(new Particle(direction));
        }
    }

    void update(long fps){
        mDuration -= (1f/fps);

        for(Particle p : mParticles){
            p.update(fps);
        }

        if (mDuration < 0)
        {
            mIsRunning = false;
        }
    }

    //when the user starts interacting(drawing)
    void emitParticles(PointF startPosition){
        mIsRunning = true;

        // Option 1 - Sysstem lasts for half a minute
        //mDuration = 30f;

        // Option 2 - System lasts for 2 seconds
        mDuration = 3f;

        for(Particle p : mParticles){
            p.setmPosition(startPosition);
        }
    }

    void  draw(Canvas canvas , Paint paint) {
        for(Particle p : mParticles) {
            if(mColor) {
                // Option 1 - Coloured particles
                paint.setARGB(255, random.nextInt(256),random.nextInt(256),random.nextInt(256));
            } else {
                // Option 2 - White particles
                paint.setColor(Color.argb(255,255,255,255));
            }
            // How big is each particle?
            float sizeX = 0;
            float sizeY = 0;

            if(mSize == 2 ){
                // Option 1 - Big particles
                sizeX = 25;
                sizeY = 25;
            } else if(mSize == 1) {
                // Option 2 - Medium particles
                sizeX = 10;
                sizeY = 10;
            } else if(mSize == 0) {
                // Option 3 - Tiny particles
                sizeX = 1;
                sizeY = 1;
            }


            // Draw the particle
            // Option 1 - Square particles
            //canvas.drawRect(p.getPosition().x,
            //p.getPosition().y,
            //p.getPosition().x + sizeX,
            //p.getPosition().y + sizeY,
            //paint);

            // Option 2 - Circle particles
            canvas.drawCircle(p.getmPosition().x,
                    p.getmPosition().y,
                    sizeX, paint);
        }
    }
}
