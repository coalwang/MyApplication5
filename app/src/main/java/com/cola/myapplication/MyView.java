package com.cola.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;
    private Region mRegion;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        //mPaint.setColor(Color.RED);
        mPath = new Path();
//        mPath.moveTo(100,100);
//        mPath.lineTo(200,200);
//        mPath.lineTo(500,300);
//        mPath.close();
//        mPath.moveTo(100,100);
//        mRectF = new RectF(100,100,500,500);
//        mPath.arcTo(mRectF,0,90);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.RED);
        canvas.save();
        canvas.clipRect(new Rect(100,100,200,200));
        canvas.drawColor(Color.GREEN);
        canvas.restore();
        canvas.drawColor(Color.GREEN);//

    }

    private void drawRegion(Canvas canvas,Region region,Paint paint){
        RegionIterator iterator = new RegionIterator(region);
        Rect rect = new Rect();
        int i = 0;
        while (iterator.next(rect)){
            i = i+1;
            System.out.println("========="+i);
            canvas.drawRect(rect,paint);
        }
    }
}
