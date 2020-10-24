package com.example.rawabi.sucks;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

class Drawpic extends View {

    boolean x1= true;
    boolean y1 = true;
    boolean x2= false;
    boolean y2 = false;

    int x_start = 0;
    int y_start = 0;
    int x_end = 0;
    int y_end = 0;

    int xx = 0;
    int yy = 0;


    public Drawpic(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p1 = new Paint();
        p1.setARGB(255,255,255,0);

        Paint p2 = new Paint();
        p2.setARGB(255,255,0,0);

        int x = canvas.getWidth();
        int y = canvas.getHeight();

         x_start = x/20+50;
         y_start = y/20+50;
         x_end = x-x/20-50;
         y_end = y-y/20-50;

        canvas.drawRect(x_start - 50,y_start - 50,x_end + 50,y_end + 50,p1);
        canvas.drawCircle(x_start + xx,y_start + yy,50, p2);

        int velocity = 80;

        if(x1 && x2){
            xx += velocity;
            if(x_start + xx > x_end){
                xx = x_end - x_start;

            }
            x2 = false;

        }
        else if(x2)
        {
            xx -= velocity;
            if(xx + x_start < x_start ){
                xx = 0;

            }
            x2 = false;
        }

        if(y1 && y2){
            yy += velocity;
            if(y_start + yy > y_end){
                yy = y_end - y_start;

            }
            y2 = false;
        }
        else if(y2)
        {
            yy -= velocity;
            if(yy + y_start < y_start ){
                yy = 0;


            }
            y2 = false;
        }

        invalidate();






        //canvas.drawRoundRect(new RectF(100,100,350,350),250,125,p1);

        /*Bitmap test = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.abc),200,200,true);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.abc);
        canvas.drawBitmap(bitmap,0,0,null);*/




    }




    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        Log.d("Saqer","x:" + x +"/n y:"+ y);

        if(x > x_start + xx){
            x1 = true;
            x2 = true;
        }
        else
        {
            x2 = true;

        }

        if(y > y_start + yy){
            y1 = true;
            y2 = true;
        }
        else
        {
            y2 = true;

        }

        return super.onTouchEvent(event);

}

}

