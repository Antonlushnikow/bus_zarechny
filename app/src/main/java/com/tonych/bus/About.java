package com.tonych.bus;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView TextView_About = (TextView) findViewById(R.id.textView);
        TextView_About.setText("Данное приложение не является разработкой ООО Белоярская АЭС-Авто или других компаний-перевозчиков и использует данные из открытых источников. Если вы обнаружили ошибку в расписании, сообщите об этом по адресу antonlushnikow@gmail.com");

    }

}
