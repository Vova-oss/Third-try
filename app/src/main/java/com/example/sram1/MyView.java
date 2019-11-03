package com.example.sram1;

import java.lang.Override;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import static android.graphics.Color.rgb;

public class MyView extends View {
    public MyView(Context context) {
        super(context);for (int i = 0; i < N; i++){
            x[i] = (float)(Math.random() );
            y[i] = (float)(Math.random() );
            vx[i] = (float)(Math.random()*10 );
            vy[i] = (float)(Math.random()*10 );
            rr[i]=(float)(Math.random() );
            k[i]=0;
            v[i]=0;
            g[i]=0;
            r[i]=20;
        }
    }

    Paint paint = new Paint();
    int N = 50;

    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    float[] k = new float[N];
    float[] v = new float[N];
    float[] r = new float[N];
    float[] rr=new float[N];
    float[] g = new float[N];
    @Override

    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(i*7,i*12,i*19));
            canvas.drawCircle(x[i], y[i], r[i], paint);
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            if(x[i]<this.getWidth()&&k[i]==0){x[i] += vx[i];}else {k[i]=1;;while(x[i]>0){x[i] -= vx[i];break;}if(x[i]<5){k[i]=0;}}
            if(y[i]<this.getHeight()&&v[i]==0){y[i] += vy[i];}else {v[i]=1;;while(y[i]>0){y[i] -= vy[i];break;}if(y[i]<5){v[i]=0;}}
            if(r[i]<50&&g[i]==0){r[i] += rr[i];}else {g[i]=1;;while(r[i]>0){r[i] -= rr[i];break;}if(r[i]<5){g[i]=0;}}
        }

        invalidate();
    }
}