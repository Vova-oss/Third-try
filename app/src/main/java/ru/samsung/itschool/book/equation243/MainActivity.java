package ru.samsung.itschool.book.equation243;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.window);
    }

    public void Wind1(View view) {

            setContentView(R.layout.activity_main1);
        }

    public void Wind2(View view) {

        setContentView(R.layout.activity_main);
    }

    public void Meny(View view) {

        setContentView(R.layout.window);
    }
    /** Вызывается при нажатии пользователем на кнопку Решить */
        public void solveEquation(View view) {
             // ax+b=c
           double a = Double.parseDouble( ((EditText) findViewById(R.id.coefficient_a)).getText().toString());
            double b = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_b)).getText().toString());
            double c = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_c)).getText().toString());
            TextView result = (TextView) findViewById(R.id.result);
            result.setText("Ответ: " + String.valueOf((c - b) / a));
        }


    public void solveEquation1(View view) {
// ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.coefficient_c)).getText().toString());
        if (a == 0)
        {
            if (b == 0)
            {
                if (c == 0)
                {
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText("" + String.valueOf("любое число"));
                }
                else
                {
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText("" + String.valueOf("Решений нет"));
                }
            }
            else
            {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("" + String.valueOf((-c/b)));
            }
        }
        else
        {
            double D = b * b - 4 * a * c;
            if (D < 0)
            {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("" + String.valueOf("Решений нет"));

            }
            else if (D == 0)
            {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("" + String.valueOf(-b / 2 * a));
            }
            else
            {
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b -  Math.sqrt(D)) / (2 * a);
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("" + String.valueOf(x1)+" "+String.valueOf(x2));
            }
        }

    }




}
