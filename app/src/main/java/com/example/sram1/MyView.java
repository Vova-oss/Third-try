package com.example.sram1;

import java.lang.Override;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.lang.InterruptedException;
import static android.graphics.Color.rgb;

public class MyView extends View {
    public MyView(Context context) {
        super(context);for (int i = 0; i < N; i++){
            fillRandom(x,0,500);
            fillRandom(y,0,500);
            fillRandom(vx,0,1);
            fillRandom(vy,0,1);
            fillRandom(rr,0,30);

            k[i]=0;
            v[i]=0;
            g[i]=0;
            cc[i]=7;
            zz[i]=12;
            qq[i]=19;
            r[i]=20;
            c[i]=7;
            z[i]=12;
            q[i]=19;
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
    float[] cc = new float[N];
    float[] zz = new float[N];
    float[] qq = new float[N];
    float[] c = new float[N];
    float[] z = new float[N];
    float[] q = new float[N];
    int re=255,gr=0,bl=0;

    float rand(float min,float max){
        return (float)((Math.random()-min)/(max-min+1))+min;
    }
    void fillRandom(float [] array,float min, float max){
        for(int i=0;i<array.length;i++){
            array[i]=rand (min,max);
        }
    }

    void addValues(float[] array,float[] values){
        for (int i=0;i<array.length;i++){
            array[i]+= values[i];
        }
    }
    @Override

    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < N; i++) {
            paint.setColor(Color.rgb(re,gr,bl));
            canvas.drawCircle(x[i], y[i], r[i], paint);
        }



        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {
            addValues(x, vx);
            addValues(y, vy);
            if (x[i] < 0 || x[i] > this.getWidth()){ vx[i] = - vx[i]; }
            if (y[i] < 0 || y[i] > this.getHeight()){ vy[i] = - vy[i]; }


        if(r[i]<100&&g[i]==0){r[i] += rr[i];}else {g[i]=1;;while(r[i]>-100){r[i] -= rr[i];break;}if(r[i]<-95){g[i]=0;}}


    }
          if(re==255&&gr==0&&bl!=255){bl+=1;}
            else if(re==0&&gr!=255&&bl==255){gr+=1;}
            else if (re==0&&gr==255&&bl!=0){bl-=1;}
            else if (re!=255&&gr==255&&bl==0){re+=1;}
            else if (re==255&&gr!=0&&bl==0){gr-=1;}
            else if(re!=0&&gr==0&&bl==255){re-=1;}





        invalidate();
    }
}