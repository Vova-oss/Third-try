package com.example.sram1;

import android.graphics.Color;

import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

public class BKorol extends Figyra   {

    @Override
    public void moov() {

        request[tappedY][tappedX] = true;

        if (tappedY < 7 && cells[tappedY + 1][tappedX].getText() == "") {
            cells[tappedY + 1][tappedX].setText("\uD83D\uDD39");//Шаг вниз
        }

        if (tappedY < 7 && tappedX > 0 && cells[tappedY + 1][tappedX - 1].getText() == "") {
            cells[tappedY + 1][tappedX - 1].setText("\uD83D\uDD39");//Шаг влево, вниз
        }

        if (tappedX > 0 && cells[tappedY][tappedX - 1].getText() == "") {
            cells[tappedY][tappedX - 1].setText("\uD83D\uDD39");//Шаг влево
        }

        if (tappedX > 0 && tappedY > 0 && cells[tappedY - 1][tappedX - 1].getText() == "") {
            cells[tappedY - 1][tappedX - 1].setText("\uD83D\uDD39");//Шаг влево, вверх
        }

        if (tappedY >0 && cells[tappedY - 1][tappedX].getText() == "") {
            cells[tappedY - 1][tappedX].setText("\uD83D\uDD39");//Шаг вверх
        }

        if (tappedY>0&&tappedX<7&& cells[tappedY - 1][tappedX+1].getText()=="") {
            cells[tappedY - 1][tappedX+1].setText("\uD83D\uDD39");//Шаг вверх, вправо
        }

        if (tappedX<7&& cells[tappedY ][tappedX+1].getText()=="") {
            cells[tappedY ][tappedX+1].setText("\uD83D\uDD39");//Шаг вправо
        }

        if (tappedX<7&& tappedY<7&&cells[tappedY + 1][tappedX+1].getText()=="") {
            cells[tappedY + 1][tappedX+1].setText("\uD83D\uDD39");//Шаг вправо, вниз
        }

        if (tappedY<7&&tappedX>0&&sides[tappedY+1][tappedX-1]==0) {//враг слева, внизу
            cells[tappedY+1][tappedX-1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY+1][tappedX-1]=true;//код жертвы
        }

        if (tappedX > 0 && sides[tappedY][tappedX - 1]==0) {//враг слева
            cells[tappedY][tappedX-1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY][tappedX-1]=true;//код жертвы
        }

        if (tappedX > 0 && tappedY > 0 && sides[tappedY - 1][tappedX - 1]==0) {//враг слева, вверху
            cells[tappedY-1][tappedX-1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY-1][tappedX-1]=true;//код жертвы
        }

        if (tappedY >0 && sides[tappedY - 1][tappedX]==0) {//враг вверху
            cells[tappedY-1][tappedX].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY-1][tappedX]=true;//код жертвы
        }

        if (tappedY>0&&tappedX<7&& sides[tappedY - 1][tappedX+1]==0) {//враг справо, вверху
            cells[tappedY-1][tappedX+1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY-1][tappedX+1]=true;//код жертвы
        }

        if (tappedX<7&& sides[tappedY ][tappedX+1]==0) {//враг справо
            cells[tappedY][tappedX+1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY][tappedX+1]=true;//код жертвы
        }

        if (tappedX<7&& tappedY<7&&sides[tappedY + 1][tappedX+1]==0) {//враг справо, внизу
            cells[tappedY+1][tappedX+1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY+1][tappedX+1]=true;//код жертвы
        }

        if (tappedY < 7 && sides[tappedY + 1][tappedX]==0) {//враг внизу
            cells[tappedY+1][tappedX].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY+1][tappedX]=true;//код жертвы
        }
    }

    @Override
    public void danger() {

    }
}