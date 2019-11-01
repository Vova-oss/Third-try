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
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        int y=0;
        while(y<getHeight()){
        canvas.drawLine(0, y, this.getWidth(), y,paint);
        y+=40;
        }
    }
}
