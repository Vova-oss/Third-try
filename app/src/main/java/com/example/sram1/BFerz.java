package com.example.sram1;

import android.graphics.Color;
import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

public class BFerz extends Figyra  {

    @Override
    public void moov() {
        request[tappedY][tappedX] = true;

        for (int j=1;j+tappedX<8&&j+tappedY<8;j++){//диагональ вниз, вправо
            if(cells[tappedY+j][tappedX+j].getText()==""){cells[tappedY+j][tappedX+j].setText("\uD83D\uDD39");}
            else if(sides[tappedY+j][tappedX+j]==0){cells[tappedY+j][tappedX+j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+j][tappedX+j]=true;break;}
            else break;
        }

        for (int j=1;tappedX-j>-1&&j+tappedY<8;j++){//диагональ вниз влево
            if(cells[tappedY+j][tappedX-j].getText()==""){cells[tappedY+j][tappedX-j].setText("\uD83D\uDD39");}
            else if(sides[tappedY+j][tappedX-j]==0){cells[tappedY+j][tappedX-j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+j][tappedX-j]=true;break;}
            else break;
        }

        for (int j=1;j+tappedX<8&&tappedY-j>-1;j++){//диагональ вверх, вправо
            if(cells[tappedY-j][tappedX+j].getText()==""){cells[tappedY-j][tappedX+j].setText("\uD83D\uDD39");}
            else if(sides[tappedY-j][tappedX+j]==0){cells[tappedY-j][tappedX+j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-j][tappedX+j]=true;break;}
            else break;
        }

        for (int j=1;tappedX-j>-1&&tappedY-j>-1;j++){//диагональ вверх, влево
            if(cells[tappedY-j][tappedX-j].getText()==""){cells[tappedY-j][tappedX-j].setText("\uD83D\uDD39");}
            else if(sides[tappedY-j][tappedX-j]==0){cells[tappedY-j][tappedX-j].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-j][tappedX-j]=true;break;}
            else break;
        }

        for(int i=tappedY+1;i<8;i++){//просмотр шагов ладьи вниз
            if(cells[i][tappedX].getText()==""){cells[i][tappedX].setText("\uD83D\uDD39");}
            else if(sides[i][tappedX]==0){cells[i][tappedX].setBackgroundColor(Color.rgb(255,0,0));gertva[i][tappedX]=true;break;}
            else break;
        }

        for(int i=tappedY-1;i>-1;i--){//просмотр шагов ладьи вверх
            if(cells[i][tappedX].getText()==""){cells[i][tappedX].setText("\uD83D\uDD39");}
            else if(sides[i][tappedX]==0){cells[i][tappedX].setBackgroundColor(Color.rgb(255,0,0));gertva[i][tappedX]=true;break;}
            else break;
        }

        for(int i=tappedX+1;i<8;i++){//просмотр шагов ладьи вправо
            if(cells[tappedY][i].getText()==""){cells[tappedY][i].setText("\uD83D\uDD39");}
            else if(sides[tappedY][i]==0){cells[tappedY][i].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY][i]=true;break;}
            else break;
        }

        for(int i=tappedX-1;i>-1;i--){//просмотр шагов ладьи влево
            if(cells[tappedY][i].getText()==""){cells[tappedY][i].setText("\uD83D\uDD39");}
            else if(sides[tappedY][i]==0){cells[tappedY][i].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY][i]=true;break;}
            else break;
        }
    }

    @Override
    public void danger() {

    }
}
