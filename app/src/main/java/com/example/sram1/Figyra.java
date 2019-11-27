package com.example.sram1;
import android.graphics.Color;

import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;

public  abstract class Figyra implements Clrscr{



    private    int WIDTH ;
    private   int HEIGHT ;

    Figyra(){
        this.WIDTH=8;
        this.HEIGHT=8;
    }


     void presearch(){//снимает запрос с фигур(полезно, если игрок метается от фишки к фишке)

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                request[i][j]=false;
            }
        }
    }

    @Override
    public void clrscr(){
        for (int i = 0; i < HEIGHT; i++)
             for (int j = 0; j < WIDTH; j++) {
                 gertva[i][j]=false;
                 if (cells[i][j].getText() == "\uD83D\uDD39") {
                     cells[i][j].setText("");
                 }
                 if ((i+j)%2==0){ cells[i][j].setBackgroundColor(Color.WHITE);}
                 else{ cells[i][j].setBackgroundColor(Color.rgb(255,143,32));}
             }
    }


    public abstract void moov();


    public void danger() {

    }
}
