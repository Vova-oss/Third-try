package com.example.sram1;

import android.graphics.Color;

import static com.example.sram1.MainActivity.cells;
import static com.example.sram1.MainActivity.gertva;
import static com.example.sram1.MainActivity.request;
import static com.example.sram1.MainActivity.sides;
import static com.example.sram1.MainActivity.tappedX;
import static com.example.sram1.MainActivity.tappedY;

public class CHKonyaka extends Figyra {



    @Override
    public void moov(){
        request[tappedY][tappedX] = true;


        //предполагаемые шаги: начало
        if(tappedY-2>-1&&tappedX+1<8&&cells[tappedY-2][tappedX+1].getText()=="") {
            cells[tappedY - 2][tappedX + 1].setText("\uD83D\uDD39");
        }else if(tappedY-2>-1&&tappedX+1<8&&sides[tappedY-2][tappedX+1]==1){
            cells[tappedY-2][tappedX+1].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-2][tappedX+1]=true;
        }

        if(tappedY-1>-1&&tappedX+2<8&&cells[tappedY-1][tappedX+2].getText()==""){
            cells[tappedY-1][tappedX+2].setText("\uD83D\uDD39");
        }else if(tappedY-1>-1&&tappedX+2<8&&sides[tappedY-1][tappedX+2]==1){
            cells[tappedY-1][tappedX+2].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-1][tappedX+2]=true;
        }

        if(tappedY+1<8&&tappedX+2<8&&cells[tappedY+1][tappedX+2].getText()==""){
            cells[tappedY+1][tappedX+2].setText("\uD83D\uDD39");
        }else if(tappedY+1<8&&tappedX+2<8&&sides[tappedY+1][tappedX+2]==1){
            cells[tappedY+1][tappedX+2].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+1][tappedX+2]=true;
        }

        if(tappedY+2<8&&tappedX+1<8&&cells[tappedY+2][tappedX+1].getText()==""){
            cells[tappedY+2][tappedX+1].setText("\uD83D\uDD39");
        }else if(tappedY+2<8&&tappedX+1<8&&sides[tappedY+2][tappedX+1]==1){
            cells[tappedY+2][tappedX+1].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+2][tappedX+1]=true;
        }

        if(tappedY+2<8&&tappedX-1>-1&&cells[tappedY+2][tappedX-1].getText()==""){
            cells[tappedY+2][tappedX-1].setText("\uD83D\uDD39");
        }else if(tappedY+2<8&&tappedX-1>-1&&sides[tappedY+2][tappedX-1]==1){
            cells[tappedY+2][tappedX-1].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+2][tappedX-1]=true;
        }

        if(tappedY+1<8&&tappedX-2>-1&&cells[tappedY+1][tappedX-2].getText()==""){
            cells[tappedY+1][tappedX-2].setText("\uD83D\uDD39");
        }else if(tappedY+1<8&&tappedX-2>-1&&sides[tappedY+1][tappedX-2]==1){
            cells[tappedY+1][tappedX-2].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY+1][tappedX-2]=true;
        }

        if(tappedY-1>-1&&tappedX-2>-1&&cells[tappedY-1][tappedX-2].getText()==""){
            cells[tappedY-1][tappedX-2].setText("\uD83D\uDD39");
        }else if(tappedY-1>-1&&tappedX-2>-1&&sides[tappedY-1][tappedX-2]==1){
            cells[tappedY-1][tappedX-2].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-1][tappedX-2]=true;
        }

        if(tappedY-2>-1&&tappedX-1>-1&&cells[tappedY-2][tappedX-1].getText()==""){
            cells[tappedY-2][tappedX-1].setText("\uD83D\uDD39");
        }else if(tappedY-2>-1&&tappedX-1>-1&&sides[tappedY-2][tappedX-1]==1){
            cells[tappedY-2][tappedX-1].setBackgroundColor(Color.rgb(255,0,0));gertva[tappedY-2][tappedX-1]=true;
        }
        //предполагаемые шаги, конец
    }


}
