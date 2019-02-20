package com.example.balldemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {




    //adding  commits
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = INVALID_POINTER_ID;
    private ScaleGestureDetector mScaleDetector;

    private float mScaleFactor = 1.f;



    private int color = Color.YELLOW;
    private Canvas canvas;
    public RelativeLayout relativeLayout;
    private Point cursorAtMouseDown = null;
    private Point startAtMouseDown = null;
    private Point endAtMouseDown = null;
    private boolean movingStart = false;
    private boolean movingEnd = false;
    private boolean movingLine = false;
    public  ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relative);

        mScaleDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener());

        draw();
    }

    private void draw() {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

        canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        canvas.drawColor(color);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(100, 100, 50, paint);


      imageView  = new ImageView(this);
        imageView.setImageBitmap(bitmap);
        imageView.performClick();

        relativeLayout = new RelativeLayout(this);
        relativeLayout.addView(imageView);
        relativeLayout.setBackgroundColor(Color.BLACK);

        setContentView(relativeLayout);




    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleDetector.onTouchEvent(event);
        final int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_DOWN:{
                final int pointerIndex = MotionEventCompat.getActionIndex(event);
                final float x  = MotionEventCompat.getX(event, pointerIndex);
                final float y = MotionEventCompat.getY(event, pointerIndex);

                float mLastTouchX = x;
                float  mLastTouchY = y;
                mActivePointerId =MotionEventCompat.getPointerId(event, 0);
                break;



            }

        }
        return super.onTouchEvent(event);
    }


}
