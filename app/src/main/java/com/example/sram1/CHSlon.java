package com.example.sram1;

import android.graphics.Color;

import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

public class CHSlon extends Figyra {
    @Override
    public void moov() {

        request[tappedY][tappedX] = true;
        for (int j=1;j+tappedX<8&&j+tappedY<8;j++){//диагональ вниз, вправо
            if(cells[tappedY+j][tappedX+j].getText()==""){cells[tappedY+j][tappedX+j].setText("\uD83D\uDD39");}
            else if(sides[tappedY+j][tappedX+j]==1){cells[tappedY+j][tappedX+j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+j][tappedX+j]=true;break;}
            else break;
        }


        for (int j=1;tappedX-j>-1&&j+tappedY<8;j++){//диагональ вниз влево
            if(cells[tappedY+j][tappedX-j].getText()==""){cells[tappedY+j][tappedX-j].setText("\uD83D\uDD39");}
            else if(sides[tappedY+j][tappedX-j]==1){cells[tappedY+j][tappedX-j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+j][tappedX-j]=true;break;}
            else break;
        }

        for (int j=1;j+tappedX<8&&tappedY-j>-1;j++){//диагональ вверх, вправо
            if(cells[tappedY-j][tappedX+j].getText()==""){cells[tappedY-j][tappedX+j].setText("\uD83D\uDD39");}
            else if(sides[tappedY-j][tappedX+j]==1){cells[tappedY-j][tappedX+j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-j][tappedX+j]=true;break;}
            else break;
        }

        for (int j=1;tappedX-j>-1&&tappedY-j>-1;j++){//диагональ вверх, влево
            if(cells[tappedY-j][tappedX-j].getText()==""){cells[tappedY-j][tappedX-j].setText("\uD83D\uDD39");}
            else if(sides[tappedY-j][tappedX-j]==1){cells[tappedY-j][tappedX-j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-j][tappedX-j]=true;break;}
            else break;
        }
    }
}
