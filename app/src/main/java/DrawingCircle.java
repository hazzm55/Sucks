import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawingCircle extends View {




    int x=0, y=0;
    int i,j;
    int start=0;
    int res=0;


    public DrawingCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            Paint p1 = new Paint();
            p1.setARGB(255, 0, 0, 255);
            canvas.drawArc(new RectF(x, y, 100 + x, y + 100), 0, 360, true, p1);
            if (res == 0)//x
            {
                if (x > this.getMeasuredWidth() - 100)
                    i = 0;
                start = 1;
            }
            if (0 > x) {
                i = 1;
            }

            if (start == 0) {
                x = x + 50;
                start = 1;
//
            } else if (i == 0) {
                x = x - 50;
                y = y + 50;
            } else if (i == 1) {
                x = x + 50;
                y = y + 50;

            }
            if ((y > this.getMeasuredHeight() - 100)) {
//
                res = 1;
            } else if (res == 1)
            {
//
                if (x > this.getMeasuredWidth() - 100) {
                    j = 0;

                } else if (0 > x) {
                    j = 1;
                }


                if (j == 0) {
                    x = x - 50;
                    y = y - 50;
                } else if (j == 1) {
                    x = x + 50;
                    y = y - 50;

                }
                if (y < 0) {
                    res = 0;
                }
            }




        invalidate();
    }

    }
