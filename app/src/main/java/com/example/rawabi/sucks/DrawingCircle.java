package com.example.rawabi.sucks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawingCircle extends View {




    int first =0, second =0;
    int nope,j;
    int start=0;
    int Ref =0;


    public DrawingCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

            canvas.drawARGB(200, 255, 190, 10);

            Paint p1 = new Paint();
            p1.setARGB(255, 255, 0, 0);
            canvas.drawArc(new RectF(first, second, 100 + first, second + 100), 0, 360, true, p1);
            if (Ref == 0)//first
            {
                if (first > this.getMeasuredWidth() - 100)
                    nope = 0;
                start = 1;
            }
            if (0 > first) {
                nope = 1;
            }

            if (start == 0) {
                first = first + 50;
                start = 1;
//
            } else if (nope == 0) {
                first = first - 50;
                second = second + 50;
            } else if (nope == 1) {
                first = first + 50;
                second = second + 50;

            }
            if ((second > this.getMeasuredHeight() - 100)) {
//
                Ref = 1;
            } else if (Ref == 1)
            {

                if (first > this.getMeasuredWidth() - 100) {
                    j = 0;

                } else if (0 > first) {
                    j = 1;
                }


                if (j == 0) {
                    first = first - 50;
                    second = second - 50;
                } else if (j == 1) {
                    first = first + 50;
                    second = second - 50;

                }
                if (second < 0) {
                    Ref = 0;
                }
            }




        invalidate();
    }

}
