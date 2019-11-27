package com.example.sram1;

import android.graphics.Color;

import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

 public class CHPeshka extends Figyra {

     @Override
    public void moov() {

        //проверка на прорыв в тыл
        if (tappedY==0) {
            cells[tappedY ][tappedX].setText("♛");//смена фигуры на ферзя
        }
        //просмотр хода вперед из начальной позиции
        if (tappedY==6&& cells[tappedY - 2][tappedX].getText()==""&& cells[tappedY - 1][tappedX].getText()=="") {
            cells[tappedY - 2][tappedX].setText("\uD83D\uDD39");//выполняется запрос от данной клетки
            request[tappedY][tappedX] = true;//запрос подтверждается
        }
        //просмотр хода вперед
        if (tappedY>0&& cells[tappedY - 1][tappedX].getText()=="") {
            cells[tappedY - 1][tappedX].setText("\uD83D\uDD39");//выполняется запрос от данной клетки
            request[tappedY][tappedX] = true;//запрос подтверждается
        }
        //отметка предполагаемой жертвы
        if (tappedY>0&&tappedX>0&&sides[tappedY-1][tappedX-1]==1) {//враг слева
            cells[tappedY-1][tappedX-1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY-1][tappedX-1]=true;//код жертвы
            request[tappedY][tappedX] = true;//запрос подтверждения
        }
        //отметка предполагаемой жертвы
        if (tappedY>0&&tappedX<7&&sides[tappedY-1][tappedX+1]==1) {//враг справа
            cells[tappedY-1][tappedX+1].setBackgroundColor(Color.parseColor("#FF0000"));
            gertva [tappedY-1][tappedX+1]=true;//код жертвы
            request[tappedY][tappedX] = true;//запрос подтверждения
        }
    }

   static CHPeshka got=new CHPeshka();


 }
