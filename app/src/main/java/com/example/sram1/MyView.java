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
        float y = 0,x=0,z=0;
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);


        while (z < canvas.getHeight()){z +=1; }

        while (x<z*2){
            canvas.drawLine(x,0,0,y,paint);
            x+=30;
            y+=30;
        }
    }
}
