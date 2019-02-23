package com.example.balldemo;

import android.view.ScaleGestureDetector;

public class ScaleLintener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private float mScaleFactor = 1.f;

    @Override
    public boolean onScale(ScaleGestureDetector detector) {

       mScaleFactor *= detector.getScaleFactor();
        mScaleFactor = Math.max(0.1f,Math.min(mScaleFactor,10.0f));
        //invalidate();
        //adding new commit
        return true;
    }
}
