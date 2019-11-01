package com.example.sram1;

import java.lang.Override;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 2000, paint);
        float y=0,x=0;
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        while (y<getHeight()){
            canvas.drawLine(x,0,0,y,paint);
            x+=30;
            y+=30;
        }
        float w=0,t=0;
        while (w<getHeight()){
            canvas.drawLine(0,w,t,0,paint);
            w+=30;
            t+=30;
        }
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(760, 1263, 320, paint);

    }

}
