package com.example.sram1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements OnClickListener, OnLongClickListener,Enemies,Search,Clrscr {
        public  int WIDTH = 8;
        public  int HEIGHT = 8;
        public String hod;
        int block;
        int bwin=0;
        int chwin=0;
        public static Button[][] cells;
        public static boolean[][] request=new boolean [8][8];
        public static int [][] sides=new int[8][8];
        public static int tappedY;
        public static int tappedX;
        public static boolean[][] gertva=new boolean[8][8];
       // public static boolean [][] danger=new boolean [8][8];
        CharSequence l;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window);
    }

    void makeCells () {
        block=0;
        hod="b";
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                request[i][j] = false;
                sides[i][j]=2;
                gertva[i][j]=false;
               // danger[i][j]=false;
                cellsLayout.addView(cells[i][j]);
            }
    }

    void generate () {
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                if ((i+j)%2==0){ cells[i][j].setBackgroundColor(Color.WHITE);}
                else{ cells[i][j].setBackgroundColor(Color.rgb(255,143,32));}
                cells[i][j].setText("");
                if(i==1){cells[i][j].setText("♙");}
                if(i==6){cells[i][j].setText("♟");}
                if(i==0&&(j==0||j==7)){cells[i][j].setText("♖");}
                if(i==0&&(j==1||j==6)){cells[i][j].setText("♘");}
                if(i==0&&(j==2||j==5)){cells[i][j].setText("♗");}
                if(i==0&&j==3){cells[i][j].setText("♔");}
                if(i==0&&j==4){cells[i][j].setText("♕");}
                if(i==7&&(j==0||j==7)){cells[i][j].setText("♜");}
                if(i==7&&(j==1||j==6)){cells[i][j].setText("♞");}
                if(i==7&&(j==2||j==5)){cells[i][j].setText("♝");}
                if(i==7&&j==3){cells[i][j].setText("♚");}
                if(i==7&&j==4){cells[i][j].setText("♛");}
                if(i==3){cells[i][j].setText("\uD83D\uDD39");}

            }

    }

    public void Obman(View view) {//Псевдобот

        setContentView(R.layout.activity_main);
    }

    public void Meny(View view) {//возвращает на главную панель

        setContentView(R.layout.window);

    }

    public void shah(View view){//генерирует поле
        setContentView(R.layout.shahimat);
        makeCells();
        generate();
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

    @Override
    public void search(){//находит, от какой фигуры был сделан запрос на поиск хода,запоминая ее, и уничтожает жертву
        for ( int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                if(request[i][j]){l=cells[i][j].getText();cells[i][j].setText("");request[i][j]=false;}
            }
        }
    }



    @Override
    public void enemies(){
        for (int i = 0; i < HEIGHT; i++){//белые будут иметь кодовый знак 1, черные 0. И это не потому что я белый. P.S. пустые клетки имеют символ 2
            for (int j = 0; j < WIDTH; j++) {
                if(cells[i][j].getText()=="♔"||cells[i][j].getText()=="♕"||cells[i][j].getText()=="♖"||cells[i][j].getText()=="♗"||cells[i][j].getText()=="♘"||cells[i][j].getText()=="♙"){sides[i][j]=1;}
                else if(cells[i][j].getText()=="♚"||cells[i][j].getText()=="♛"||cells[i][j].getText()=="♜"||cells[i][j].getText()=="♝"||cells[i][j].getText()=="♞"||cells[i][j].getText()=="♟"){sides[i][j]=0;}
                else {sides[i][j]=2;}
            }
        }
    }

    void useFigyr(Figyra figyra) {
        figyra.clrscr();
        figyra.presearch();
        figyra.moov();
    }

   /* void useFigyre(Figyra figyre){
        figyre.danger();
    }   */



   /* public void checkD() {
        for ( i = 0; i < HEIGHT; i++) {
            for ( j = 0; j < WIDTH; j++) {
                 if (cells[i][j].getText()=="♚") {;}//клик по черному королю
                else if (cells[i][j].getText()=="♔") {;}//клик по белому королю
                else if (cells[i][j].getText()=="♛") {;}//клик по черному ферзю
                else if (cells[i][j].getText()=="♕") {;}//клик по белому ферзю
                else if (cells[i][j].getText()=="♝") {;}//клик по черному слону
                else if (cells[i][j].getText()=="♗") {;}//клик по белому слону
                else if (cells[i][j].getText()=="♞") {;}//клик по черной лошадке
                else if (cells[i][j].getText()=="♘") {;}//клик по белой лошадке
                else if (cells[i][j].getText()=="♜") {;}//клик по черной ладье
                else if (cells[i][j].getText()=="♖") {useFigyre(bLadia);}//клик по белой ладье
                else if (cells[i][j].getText()=="♟") {;}//клик по черной пешке
                else if (cells[i][j].getText()=="♙") {;}//клик по белой пешке
            }
        }
    }
*/

    Figyra bKonyaka=new BKonyaka() ;
    Figyra bPeshka = new BPeshka();
    Figyra bLadia=new BLadia();
    Figyra bSlon=new BSlon();
    Figyra bFerz=new BFerz();
    Figyra bKorol=new BKorol();
    Figyra chKorol=new CHKorol();
    Figyra chFerz=new CHFerz();
    Figyra chSlon=new CHSlon();
    Figyra chLadia=new CHLadia();
    Figyra chPeshka=new CHPeshka();
    Figyra chKonyaka=new CHKonyaka();

    @Override
    public void onClick (View v) {

        Button tappedCell = (Button) v;
         tappedX = getX(tappedCell);
         tappedY = getY(tappedCell);
         enemies();
        if (gertva[tappedY][tappedX]&&block==0) {
            search();cells[tappedY][tappedX].setText(l);clrscr();
            if( hod.equals("b")){hod="ch";} else hod="b";
        }//клик по жертве

        else if (cells[tappedY][tappedX].getText()=="♚"&&block==0&& hod.equals("ch")) {useFigyr(chKorol);}//клик по черному королю
        else if (cells[tappedY][tappedX].getText()=="♔"&&block==0&& hod.equals("b")) {useFigyr(bKorol);}//клик по белому королю
        else if (cells[tappedY][tappedX].getText()=="♛"&&block==0&& hod.equals("ch")) {useFigyr(chFerz);}//клик по черному ферзю
        else if (cells[tappedY][tappedX].getText()=="♕"&&block==0&& hod.equals("b")) {useFigyr(bFerz);}//клик по белому ферзю
        else if (cells[tappedY][tappedX].getText()=="♝"&&block==0&& hod.equals("ch")) {useFigyr(chSlon);}//клик по черному слону
        else if (cells[tappedY][tappedX].getText()=="♗"&&block==0&& hod.equals("b")) {useFigyr(bSlon);}//клик по белому слону
        else if (cells[tappedY][tappedX].getText()=="♞"&&block==0&& hod.equals("ch")) {useFigyr(chKonyaka);}//клик по черной лошадке
        else if (cells[tappedY][tappedX].getText()=="♘"&&block==0&& hod.equals("b")) {useFigyr(bKonyaka);}//клик по белой лошадке
        else if (cells[tappedY][tappedX].getText()=="♜"&&block==0&& hod.equals("ch")) {useFigyr(chLadia);}//клик по черной ладье
        else if (cells[tappedY][tappedX].getText()=="♖"&&block==0&& hod.equals("b")) {useFigyr(bLadia);}//клик по белой ладье
        else if (cells[tappedY][tappedX].getText()=="♟"&&block==0&& hod.equals("ch")) {useFigyr(chPeshka);}//клик по черной пешке
        else if (cells[tappedY][tappedX].getText()=="♙"&&block==0&& hod.equals("b")) {useFigyr(bPeshka);}//клик по белой пешке

        else  if (cells[tappedY][tappedX].getText()=="\uD83D\uDD39"&&block==0) {
            search();cells[tappedY][tappedX].setText(l);clrscr();
            if( hod.equals("b")){hod="ch";} else hod="b";
        }//клик по шагу

        else clrscr();



        enemies();
        pobeda();

    }

    public void pobeda (){
        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++) {
                if (cells[i][j].getText()=="♔"){bwin=1;}
                if (cells[i][j].getText()=="♚"){chwin=1;}
            }
        }

        if (bwin==0){
            TextView ikto= findViewById(R.id.ikto);
            ikto.setText("Черные победили");
            block=1;
        }
        if (chwin==0){
            TextView ikto= findViewById(R.id.ikto);
            ikto.setText("Белые победили");
            block=1;
        }
        bwin=0;chwin=0;
    }

    int getX (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY (View v){
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }


}