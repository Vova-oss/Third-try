package com.example.sram1;

import android.graphics.Color;


import static com.example.sram1.MainActivity.cells;
//import static com.example.sram1.MainActivity.danger;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

public class BPeshka extends Figyra  {



    @Override
    public  void moov() {

        //проверка на прорыв в тыл
        if (cells[tappedY][tappedX].getText() == "♙"&&tappedY==7) {
            cells[tappedY ][tappedX].setText("♕");//смена фигуры на ферзя
        }
        //просмотр хода вперед из начальной позиции
        if (cells[tappedY][tappedX].getText() == "♙"&&tappedY==1&& cells[tappedY + 2][tappedX].getText()==""&& cells[tappedY + 1][tappedX].getText()=="") {
            cells[tappedY + 2][tappedX].setText("\uD83D\uDD39");//выполняется запрос от начальной клетки в сею
            request[tappedY][tappedX] = true;//запрос подтверждается
        }
        //просмотр хода вперед
        if (cells[tappedY][tappedX].getText() == "♙"&&tappedY<7&& cells[tappedY + 1][tappedX].getText()=="") {
            cells[tappedY + 1][tappedX].setText("\uD83D\uDD39");//выполняется запрос от данной клетки
            request[tappedY][tappedX] = true;//запрос подтверждается
        }
        //отметка предполагаемой жертвы
         if (cells[tappedY][tappedX].getText() == "♙"&&tappedY<7&&tappedX>0&&sides[tappedY+1][tappedX-1]==0) {//враг слева
             cells[tappedY+1][tappedX-1].setBackgroundColor(Color.parseColor("#FF0000"));
             gertva [tappedY+1][tappedX-1]=true;//код жертвы
             request[tappedY][tappedX] = true;//запрос подтверждения
        }
         //отметка предполагаемой жертвы
        if (cells[tappedY][tappedX].getText() == "♙"&&tappedX<7&&sides[tappedY+1][tappedX+1]==0&&tappedY<7) {//враг справа
            cells[tappedY+1][tappedX+1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY+1][tappedX+1]=true;//код жертвы
            request[tappedY][tappedX] = true;//запрос подтверждения
        }


    }


   /* @Override
    public void danger() {
       if(tappedY>0&&tappedY<7&&tappedX>0&&tappedX<7) danger[tappedY+1][tappedX+1]=true;
        if(tappedY>0&&tappedY<7&&tappedX>0&&tappedX<7)danger[tappedY+1][tappedX-1]=true;
    }*/
}
