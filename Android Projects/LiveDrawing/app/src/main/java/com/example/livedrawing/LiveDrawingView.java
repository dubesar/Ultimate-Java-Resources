package com.example.livedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class LiveDrawingView extends SurfaceView implements Runnable {
    private final boolean DEBUGGING = true;

    // These objects are needed to do the drawing
    private SurfaceHolder mOurHolder;
    private Canvas mCanvas;
    private Paint mPaint;

    // How many frames per second did we get?
    private long mFPS;
    // The number of milliseconds in a second
    private final int MILLIS_IN_SECOND = 1000;

    // Holds the resolution of the screen
    private int mScreenX;
    private int mScreenY;
    // How big will the text be?
    private int mFontSize;
    private int mFontMargin;

    private Thread mThread = null;
    // This volatile variable can be accessed
    // from inside and outside the thread
    private volatile boolean mDrawing;
    private boolean mPaused = true;

    // These will be used to make simple buttons
    private RectF mResetButton;
    private RectF mTogglePauseButton;
    private RectF mSetColorButton;
    private RectF mSetSizeButton;

    private int tempSize =0;
    private ArrayList<ParticleSystem> mParticleSystems = new ArrayList<>();

    private int mNextSystem = 0;
    private final int MAX_SYSTEMS = 1000;
    private int mParticlesPerSystem = 100;

    public LiveDrawingView(Context context, int x, int y) {
        super(context);

        mScreenX = x;
        mScreenY = y;

        // Font is 5% (1/20th) of screen width
        mFontSize = mScreenX / 20;
        // Margin is 1.5% (1/75th) of screen width
        mFontMargin = mScreenX / 75;

        // getHolder is a method of SurfaceView
        mOurHolder = getHolder();
        mPaint = new Paint();

        // Initialize the two buttons
        mResetButton = new RectF(0, 0, 100, 100);
        mTogglePauseButton = new RectF(0, 150, 100, 250);
        mSetColorButton = new RectF(0,300,100,400);
        mSetSizeButton = new RectF(0 , 450 , 100 , 550);



        for (int i = 0; i < MAX_SYSTEMS; i++) {
            mParticleSystems.add(new ParticleSystem());
            mParticleSystems.get(i).init(mParticlesPerSystem);
        }

    }

    private void draw(){
        if(mOurHolder.getSurface().isValid()){
            // Lock the canvas (graphics memory) ready to draw
            mCanvas = mOurHolder.lockCanvas();
            //fill screen with color
            mCanvas.drawColor(Color.argb(255, 0, 0, 0));
            // Choose a color to paint with
            mPaint.setColor(Color.argb(255, 255, 255, 255));
            // Choose the font size
            mPaint.setTextSize(mFontSize);


            mPaint.setColor(Color.argb(255,255,255,255));
            mPaint.setTextSize(mFontSize);
            for (int i=0 ; i <mNextSystem ; i++) {
                mParticleSystems.get(i).draw(mCanvas,mPaint);
            }

            // Draw the buttons
            mCanvas.drawRect(mResetButton, mPaint);
            mCanvas.drawRect(mTogglePauseButton, mPaint);
            mCanvas.drawRect(mSetColorButton,mPaint);
            mCanvas.drawRect(mSetSizeButton,mPaint);
            mPaint.setColor(Color.argb(255,120,125,50));
            mPaint.setTextSize(mFontSize/1.1f);
            mCanvas.drawText("Reset" , 10 ,60 ,mPaint);
            mCanvas.drawText("Pause" , 10 ,210 ,mPaint);
            mPaint.setTextSize(mFontSize/1.3f);
            mCanvas.drawText("Color" , 10 ,330 ,mPaint);
            mCanvas.drawText("White" , 10 ,330+mFontSize ,mPaint);
            mCanvas.drawText("Size" , 10 ,490 ,mPaint);
            mCanvas.drawText("Change" , 8 ,490 + mFontSize ,mPaint);
            // Draw the HUD
            if(DEBUGGING){
                printDebuggingText();
            }
            
            // Display the drawing on screen
            // unlockCanvasAndPost is a method of SurfaceHolder
            mOurHolder.unlockCanvasAndPost(mCanvas);
        }


    }

    private void printDebuggingText() {
        int debugSize = mFontSize / 2;
        int debugStart = 600;
        mPaint.setTextSize(debugSize);
        mCanvas.drawText("FPS: " + mFPS ,
                10, debugStart + debugSize, mPaint);
        mCanvas.drawText("Systems: " + mNextSystem,
                10, mFontMargin + debugStart + debugSize * 2, mPaint);

        mCanvas.drawText("Particles: " + mNextSystem * mParticlesPerSystem,
                10, mFontMargin + debugStart + debugSize * 3, mPaint);

    }

    @Override
    public void run() {
        // mDrawing gives us finer control rather than just relying on the calls to run
        // mDrawing must be true AND the thread running for the main loop to execute
        while (mDrawing) {

            // What time is it now at the start of the loop?
            long frameStartTime = System.currentTimeMillis();

            // Provided the app isn't paused
            // call the update method
            if(!mPaused){
                update();
                // Now the particles are in
                // their new positions

            }
            // The movement has been handled and now we can draw the scene.
            draw();
            // How long did this frame/loop take?
            // Store the answer in timeThisFrame
            long timeThisFrame =
                    System.currentTimeMillis() - frameStartTime;

            // Make sure timeThisFrame is at least 1 millisecond because accidentally dividing
            // by zero crashes the app
            if (timeThisFrame > 0) {
                // Store the current frame rate in mFPS
                // ready to pass to the update methods of our particles in the next frame/loop
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    private void update() {
        for(int i =0 ; i< mParticleSystems.size() ; i++) {
            if(mParticleSystems.get(i).mIsRunning){
                mParticleSystems.get(i).update(mFPS);
            }
        }
    }

    public void pause() {

        // Set mDrawing to false
        // Stopping the thread isn't always instant
        mDrawing = false;
        try {
            // Stop the thread
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Error:", "joining thread");
        }
    }
    public void resume() {
        mDrawing = true;
        // Initialize the instance of Thread
        mThread = new Thread(this);

        // Start the thread
        mThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //User moved finger while touching screen
        if((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {
            mParticleSystems.get(mNextSystem).emitParticles(new PointF(event.getX(),event.getY()));
            mNextSystem++;
            if(mNextSystem == MAX_SYSTEMS){
                mNextSystem = 0 ;
            }
        }
        // Did the user touch the screen
        if ((event.getAction() &
                MotionEvent.ACTION_MASK)
                == MotionEvent.ACTION_DOWN) {

            // User pressed the screen see if it was in a button (pause or reset)
            if (mResetButton.contains(event.getX(), event.getY())) {
                // Clear the screen of all particles
                mNextSystem = 0;
            }

            // User pressed the screen see if it was in a button (pause or reset)
            if (mTogglePauseButton.contains(event.getX(), event.getY())) {
                //pause
                mPaused = !mPaused;
            }

            // User pressed the screen see if it was in a button (pause or reset)
            if (mSetSizeButton.contains(event.getX(), event.getY())) {
                tempSize++;
                for(int i=0 ; i<MAX_SYSTEMS;i++)
                    mParticleSystems.get(i).mSize = tempSize;

                if(tempSize == 3)
                    tempSize=0;
            }
            // User pressed the screen see if it was in a button (pause or reset)
            if (mSetColorButton.contains(event.getX(), event.getY())) {
                for(int i=0 ; i<MAX_SYSTEMS;i++)
                    mParticleSystems.get(i).mColor = !mParticleSystems.get(i).mColor;
            }
        }
        return true;
    }
}
