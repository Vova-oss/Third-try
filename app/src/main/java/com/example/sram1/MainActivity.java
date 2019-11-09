package com.example.sram1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener,
        OnLongClickListener{
    int win=0;
    private int WIDTH = 7;
    private int HEIGHT = 10;
    int[][] mines;
    private Button[][] cells;
    private Button[][] colls;
    int[] Y1;
    int pov=0;
    int min = 1;
    int max = 5;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();
    }


    void makeCells () {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
        for (int i = HEIGHT-1; i < HEIGHT; i++)
            for (int j = 0; j < 1; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

    /*void makeColls () {
    colls = new Button[1][2];
    GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
    cellsLayout.removeAllViews();
    cellsLayout.setColumnCount(WIDTH);
    for (int i = HEIGHT; i < HEIGHT+1; i++)
    for (int j = 0; j < WIDTH; j++) {
    LayoutInflater inflater = (LayoutInflater) getApplicationContext()
    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    colls[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
    colls[i][j].setOnClickListener(this);
    colls[i][j].setOnLongClickListener(this);
    colls[i][j].setTag(i + "," + j);
    cellsLayout.addView(colls[i][j]);
    }
    }
    */
    void generate () {
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.WHITE);
                cells[i][j].setText("");
            }
        for (int i = HEIGHT-1; i < HEIGHT; i++)
            for (int j = 0; j < 1; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setBackgroundColor(Color.YELLOW);
                cells[i][j].setText("↺");
            }

        double num = Math.random();
        mines = new int[11][11];
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                mines[i][j] = 0;
            }
        for (int i = 0; i < HEIGHT-1; i++)
            for (int j = 0; j < WIDTH; j++) {
                if (num > 0.8) {
                    mines[i][j] = 1;

                   cells[i][j].setText("X");


                }
                num = Math.random();
            }
    }

    @Override
    public void onClick (View v){
        Button tappedCell = (Button) v;

//Получаем координтаты нажатой клетки
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        int numk = 0;
        int k=0;
        int yu=0;

        boolean tr=false;


        if (cells[tappedY][tappedX].getText() == "↺") {
            for (int i = 0; i < HEIGHT-1; i++)
                for (int j = 0; j < WIDTH; j++) {
                    cells[i][j].setText("");
                    win=0;
                    pov=0;
                }
            generate();
        }
        else if(win==0&&pov==1){ Toast.makeText(this, "ВЫ ПОБЕДИЛИ", Toast.LENGTH_LONG).show();}
        else if(win==1&&pov==0){ Toast.makeText(this, "ВЫ ПРОИГРАЛИ", Toast.LENGTH_LONG).show();}
        else if (mines[tappedY][tappedX] == 1){

            Toast.makeText(this, "ВЫ ПРОИГРАЛИ", Toast.LENGTH_LONG).show();

            for (int i = 0; i < HEIGHT-1; i++)
                for (int j = 0; j < WIDTH; j++) {win=1;
                    if(mines[i][j]==1){cells[i][j].setText("\uD83D\uDCA3");} }
/*
                    for ( i = tappedY - 1; i < tappedY + 2; i++)
                        for ( j = tappedX - 1; j < tappedX + 2; j++) {
                            if (i > -1 && j > -1 && i < 9 && j < 7 && mines[i][j] == 1) {
                                numk++;
                            }
                        }
                    String Num = String.valueOf(numk);
                    cells[tappedY][tappedX].setText(Num);
*/





        } else if (mines[tappedY][tappedX] == 0&&tappedY<9&&win==0){

            for (int i = tappedY - 1; i < tappedY + 2; i++)
                for (int j = tappedX - 1; j < tappedX + 2; j++) {
                    if (i > -1 && j > -1 && i < 9 && j < 7 && mines[i][j] == 1) {
                        numk++;
                    }
                }
            String Num = String.valueOf(numk);
            cells[tappedY][tappedX].setText(Num);

            for (int i = 0; i < HEIGHT-1; i++){
                for (int j = 0; j < WIDTH; j++){if (mines[i][j]==0&&cells[i][j].getText()==""){
                    k=1; break;}
                }if(k==1){break;}}

            if(k==0&&win==0){

                    Toast.makeText(this, "ВЫ ПОБЕДИЛИ", Toast.LENGTH_LONG).show();
                    pov=1;
                for (int i = 0; i < HEIGHT-1; i++)
                    for (int j = 0; j < WIDTH; j++) {
                        if(mines[i][j]==1){cells[i][j].setText("\uD83D\uDCA3");}}

               }

        }
    }




    int getX (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }


    @Override
    public boolean onLongClick (View v){
        Button tappedCell = (Button) v;
        String OB = "";
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        if (cells[tappedY][tappedX].getText() == "") {
            cells[tappedY][tappedX].setText("\uD83D\uDEA9");
        } else if (cells[tappedY][tappedX].getText() == "\uD83D\uDEA9")
            cells[tappedY][tappedX].setText(OB);


        return true;

    }


}