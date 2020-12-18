package com.tonych.bus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Schedule extends AppCompatActivity {

    Button button_buy;
    LinearLayout relativeLayout;
    boolean Last;
    boolean neg;
    String Today;
    String Hour;
    String Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        Today = formatter.format(date);

        String Route = getIntent().getExtras().getString("Route");
        Integer[] Schedule={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Integer CountSchedule = 0;
        String Station = "";
        TextView TextView_Name = (TextView)findViewById(R.id.textView2);
        TextView TextView_Route1 = (TextView)findViewById(R.id.textView13);
        TextView TextView_Route2 = (TextView)findViewById(R.id.textView14);
        TextView TextView_Closest = (TextView)findViewById(R.id.textView4);//место для ближайшего
        TextView TextView_Hour = (TextView)findViewById(R.id.textView6);//для часа
        TextView TextView_Min = (TextView)findViewById(R.id.textView8);//для минуты
        TextView TextView_Schedule = (TextView)findViewById(R.id.textView15);// Расписание
        TextView TextView_Schedule2 = (TextView)findViewById(R.id.textView16);// Расписание2
        TextView TextView_Note = (TextView)findViewById(R.id.textView17);// Сноска
        TextView TextView_Price = (TextView) findViewById(R.id.textView11); //цена

        String ScheduleStr;// Перевод массива в расписание
        ScheduleStr="";
        String ScheduleStr2;// Перевод массива в расписание
        ScheduleStr2="";


        Calendar newCal = Calendar.getInstance();
        int today = getIntent().getExtras().getInt("today");
        if (today==0) today = newCal.get(Calendar.DAY_OF_WEEK);


        Last = false;

// Расписание ГОРОДСКОГО ------------------------------------------- 23 --------------------------------------
        switch (Route) {
            case "Z23":
                Schedule[0]=430;
                Schedule[1]=450;
                Schedule[2]=470;
                Schedule[3]=490;
                Schedule[4]=505;
                Schedule[5]=522;
                Schedule[6]=540;
                Schedule[7]=640;
                Schedule[8]=660;
                Schedule[9]=680;
                Schedule[10]=697;
                Schedule[11]=717;
                Schedule[12]=740;
                Schedule[13]=760;
                Schedule[14]=780;
                Schedule[15]=870;
                Schedule[16]=890;
                Schedule[17]=907;
                Schedule[18]=930;
                Schedule[19]=948;
                Schedule[20]=968;
                Schedule[21]=995;
                Schedule[22]=1015;
                Schedule[23]=1035;
                Schedule[24]=1055;
                Schedule[25]=1075;
                CountSchedule = 26;
                TextView_Name.setText("23 (по городу)");
                TextView_Route1.setText("Площадь - Аквариум - Дом торговли - Гостиница - Парикмахерская (танк) - Флагман - Галактика - ГИБДД - Почта - Поликлиника - Площадь");
                TextView_Price.setText("20 руб.");
                Last = false;
                break;

// Расписание ГОРОДСКОГО ------------------------------------------- 24 ---ИЗ ИЗ ИЗ--------
            case "ZE24":
                Schedule[0]=430;
                Schedule[1]=685;
                Schedule[2]=-1070;
                Schedule[3]=1095;

                CountSchedule = 4;
                TextView_Name.setText("24 (в Муранитный)");
                TextView_Route1.setText("Автостанция - Муранитный");
                TextView_Route2.setText("Почта - Муранитный");
                TextView_Price.setText("20 руб.");
                Last = false;
                break;
// Расписание ГОРОДСКОГО ------------------------------------------- 24 ---В  В  В--------
            case "EZ24":
                Schedule[0]=440;
                Schedule[1]=700;
                Schedule[2]=-1060;


                CountSchedule = 3;
                TextView_Name.setText("24 (в Заречный)");
                TextView_Route1.setText("Муранитный - Автостанция - Площадь");
                TextView_Route2.setText("Муранитный - Автостанция");
                TextView_Price.setText("20 руб.");
                Last = false;
                break;
 // Расписание МЕЖГОРОДА ------------------------------------------- 126 ---ИЗ ИЗ ИЗ--------
                case "ZE126":
                Schedule[0]=370;
                Schedule[1]=430;
                Schedule[2]=465;
                Schedule[3]=525;
                Schedule[4]=600;
                Schedule[5]=720;
                Schedule[6]=750;
                Schedule[7]=780;
                Schedule[8]=900;
                Schedule[9]=990;
                Schedule[10]=1035;
                Schedule[11]=1095;
                CountSchedule = 12;
                TextView_Name.setText("126 (на Северный АВ)");
                TextView_Route1.setText("Автовокзал - Площадь - Аквариум - Почта - Простоквашино - Екатеринбург (Северный автовокзал)");
                TextView_Price.setText("135 руб.");
                Last = false;
                break;

// Расписание МЕЖГОРОДА ------------------------------------------- 126 ---В   В   В--------
            case "EZ126":
                Schedule[0]=500;
                Schedule[1]=590;
                Schedule[2]=640;
                Schedule[3]=680;
                Schedule[4]=770;
                Schedule[5]=860;
                Schedule[6]=910;
                Schedule[7]=960;
                Schedule[8]=1046;
                Schedule[9]=1123;
                Schedule[10]=1200;
                Schedule[11]=1270;
                CountSchedule = 12;
                TextView_Name.setText("126 (в Заречный)");
                TextView_Route1.setText("Екатеринбург (Северный автовокзал) - Простоквашино - Ленинградская - Почта - Поликлиника - Площадь");
                TextView_Price.setText("135 руб.");
                Last = false;
                //ДОБАВЛЯЕМ КНОПКУ
                Button b = new Button(getApplicationContext());
                relativeLayout = (LinearLayout) findViewById(R.id.linearLayout);
                b.setText("КУПИТЬ БИЛЕТ");
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.gravity = Gravity.CENTER_HORIZONTAL;

                relativeLayout.addView(b, params);

                //ОБРАБОТЧИК КНОПКИ КУПИТЬ
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        Intent intent;
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://avtovokzal-ekb.ru/?from=%D0%95%D0%BA%D0%B0%D1%82%D0%B5%D1%80%D0%B8%D0%BD%D0%B1%D1%83%D1%80%D0%B3+%D0%A1%D0%B5%D0%B2%D0%B5%D1%80%D0%BD%D1%8B%D0%B9+%D0%90%D0%92&to=%D0%97%D0%B0%D1%80%D0%B5%D1%87%D0%BD%D1%8B%D0%B9+%D0%90%D0%A1&when="+Today));
                        startActivity(intent);
                    }
                });
                break;

// Расписание МЕЖГОРОДА ------------------------------------------- 191 ---ИЗ   ИЗ   ИЗ--------
            case "ZE191":
                Schedule[0]=370;
                Schedule[1]=430;
                Schedule[2]=460;
                Schedule[3]=500;
                Schedule[4]=625;
                Schedule[5]=720;
                Schedule[6]=805;
                Schedule[7]=850;
                Schedule[8]=920;
                Schedule[9]=1010;
                Schedule[10]=1090;
                Schedule[11]=1135;
                CountSchedule = 12;
                TextView_Name.setText("191 (на Южный автовокзал)");
                TextView_Route1.setText("Радиотовары - Екатеринбург (Южный автовокзал)");
                TextView_Price.setText("135 руб.");
                Last = false;
                break;
// Расписание МЕЖГОРОДА ------------------------------------------- 191 ---В   В   В--------
            case "EZ191":
                Schedule[0]=539;
                Schedule[1]=599;
                Schedule[2]=659;
                Schedule[3]=739;
                Schedule[4]=779;
                Schedule[5]=879;
                Schedule[6]=959;
                Schedule[7]=999;
                Schedule[8]=1039;
                Schedule[9]=1119;
                Schedule[10]=1199;
                Schedule[11]=1239;
                CountSchedule = 12;
                TextView_Name.setText("191 (в Заречный)");
                TextView_Route1.setText("Екатеринбург (Южный автовокзал) - Заречный");
                TextView_Price.setText("135 руб.");
                //ДОБАВЛЯЕМ КНОПКУ
                b = new Button(getApplicationContext());
                relativeLayout = (LinearLayout) findViewById(R.id.linearLayout);
                b.setText("КУПИТЬ БИЛЕТ");
                params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.gravity = Gravity.CENTER_HORIZONTAL;

                relativeLayout.addView(b, params);

                //ОБРАБОТЧИК КНОПКИ КУПИТЬ
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        Intent intent;
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.autovokzal.org/"));
                        startActivity(intent);
                    }
                });
                Last = false;
                break;

        }


        //БАЭСовские на выходные
        if (today==7 || today==1)
        {
            switch (Route) {
                case "SHIRM":
                    CountSchedule = 1;
                    TextView_Name.setText("ИРМ (в Заречный)");
                    TextView_Route1.setText("-");
                    ScheduleStr="Сегодня рейсов нет";
                    TextView_Price.setText("0 руб.");
                    Last=true;
                    break;
                case "SH17":
                    Schedule[0] = 440;
                    Schedule[1] = 470;
                    Schedule[2] = 500;
                    Schedule[3] = 885;
                    Schedule[4] = 930;
                    Schedule[5] = 975;
                    Schedule[6] = 1365;
                    Schedule[7] = 1410;
                    Schedule[8] = 1455;
                    CountSchedule = 9;
                    TextView_Name.setText("17 (в Заречный)");
                    TextView_Route1.setText("КПП ПиТ - БАЭС - Площадь - Аквариум - Гостиница - Радиотовары - РУС");
                    TextView_Price.setText("0 руб.");
                    Last = false;
                    break;
                case "SH18":

                    CountSchedule = 1;
                    TextView_Name.setText("18 (в Заречный)");
                    TextView_Route1.setText("-");
                    ScheduleStr="Сегодня рейсов нет";
                    TextView_Price.setText("0 руб.");
                    Last = true;
                    break;
                case "SH19":
                    Schedule[0] = 450;
                    Schedule[1] = 1170;
                    CountSchedule = 2;
                    TextView_Name.setText("19 (в Заречный)");
                    TextView_Route1.setText("КПП ПиТ - БАЭС - Площадь - Аквариум - Радиотовары - Галактика - Профилакторий");
                    TextView_Price.setText("0 руб.");
                    Last = false;
                    break;

                case "HSIRM":

                    CountSchedule = 1;
                    TextView_Name.setText("ИРМ (на работу)");
                    TextView_Route1.setText("-");
                    ScheduleStr="Сегодня рейсов нет";
                    TextView_Price.setText("0 руб.");
                    Last=true;
                    break;
                case "HS17":
                    Schedule[0] = 410;
                    Schedule[1] = 425;
                    Schedule[2] = 455;
                    Schedule[3] = 485;
                    Schedule[4] = 870;
                    Schedule[5] = 903;
                    Schedule[6] = 1185;
                    Schedule[7] = 1350;
                    Schedule[8] = 1380;
                    CountSchedule = 9;
                    TextView_Name.setText("17 (на работу)");
                    TextView_Route1.setText("Гостиница - Радиотовары - РУС - Поликлиника - Лермонтова - БАЭС - КПП ПиТ");
                    TextView_Price.setText("0 руб.");
                    Last = false;
                    break;
                case "HS18":
                    CountSchedule = 1;
                    TextView_Name.setText("18 (на работу)");
                    TextView_Route1.setText("-");
                    ScheduleStr="Сегодня рейсов нет";
                    TextView_Price.setText("0 руб.");
                    Last = true;
                    break;
                case "HS19":

                    Schedule[0] = 480;
                    Schedule[1] = 1200;
                    CountSchedule = 2;
                    TextView_Name.setText("19 (на работу)");
                    TextView_Route1.setText("Профилакторий - Ленинградская - Курчатова - Поликлиника - Лермонтова - БАЭС - КПП ПиТ");
                   // TextView_Route2.setText("Все рейсы - через Магнит");
                    //ScheduleStr = "9.20 (до площади), 14.00 (по субботам), 16:55, 18:25 (до площади), 20.35 (через Флагман) ";
                    TextView_Price.setText("0 руб.");

                    Last = false;
                    break;
                case "HS21":

                    CountSchedule = 1;
                    TextView_Name.setText("21 (на работу)");
                    TextView_Route1.setText("-");
                    ScheduleStr="Сегодня рейсов нет";
                    TextView_Price.setText("0 руб.");
                    Last = true;
                    break;


            }
        }
        //на будние дни
        else {
            switch (Route) {
                case "SHIRM":
                    Schedule[0] = 770;
                    Schedule [1] = -770;
                    CountSchedule = 2;

                    Station = "ИРМ";
                    TextView_Name.setText("ИРМ (в Заречный)");
                    TextView_Route1.setText("ИРМ - Площадь - Аквариум - Дом торговли - Гостиница - Радиотовары - РУС");
                    TextView_Route2.setText("ИРМ - Курчатова, 29 - Магнит - Ленинградская, 23 - Галактика - Ленина, 30");
                    TextView_Price.setText("0 руб.");
                    break;
                case "SH17":
                    Schedule[0]=485;
                    Schedule[1]=495;
                    Schedule[2]=515;
                    Schedule[3]=570;
                    Schedule[4]=663;
                    Schedule[5]=685;
                    Schedule[6]=695;
                    Schedule[7]=714;
                    Schedule[8]=721;
                    Schedule[9]=780;
                    Schedule[10]=840;
                    Schedule[11]=-885;
                    Schedule[12]=-905;
                    Schedule[13]=-930;
                    Schedule[14]=-960;
                    Schedule[15]=-970;
                    Schedule[16]=-980;
                    Schedule[17]=-990;
                    Schedule[18]=-992;
                    Schedule[19]=-995;
                  //  Schedule[20]=-997;
                    Schedule[20]=-999;
                    Schedule[21]=-1006;
                    Schedule[22]=-1010;
                    Schedule[23]=-1015;
                    Schedule[24]=-1025;
                    Schedule[25]=-1027;
                 //   Schedule[27]=-1029;
                 //   Schedule[28]=-1033;
                    Schedule[26]=-1035;
                    Schedule[27]=-1043;
                    Schedule[28]=-1045;
                    Schedule[29]=-1050;
                    Schedule[30]=-1067;
                    Schedule[31]=-1110;
                    Schedule[32]=-1140;
                    Schedule[33]=-1365;
                    Schedule[34]=-1410;
                    Schedule[35]=-1455;
                    CountSchedule = 36;
                    TextView_Name.setText("17 (в Заречный)");
                    TextView_Route1.setText("КПП ПиТ - БАЭС - Площадь - Аквариум - Гостиница - Радиотовары - РУС");
                    TextView_Route2.setText("КПП ПиТ (УТЦ) - ИРМ - БАЭС - Площадь - Аквариум - Дом торговли - Радиотовары - РУС");
                    TextView_Note.setText("");
                    TextView_Price.setText("0 руб.");
                    break;
                case "SH18":
                    Schedule[0]=480;
                    Schedule[1]=491;
                    Schedule[2]=655;
                    Schedule[3]=685;
                    Schedule[4]=720;
                    Schedule[5]=925;
                    Schedule[6]=945;
                    Schedule[7]=965;
                    Schedule[8]=970;
                    Schedule[9]=975;
                    Schedule[10]=985;
                    Schedule[11]=996;
                    Schedule[12]=1000;
                    Schedule[13]=1005;
                    Schedule[14]=1010;
                    Schedule[15]=1020;
                    Schedule[16]=1025;
                    Schedule[17]=1030;
                    Schedule[18]=1040;
                    Schedule[19]=1047;
                    Schedule[20]=1050;
                    Schedule[21]=1060;
                    CountSchedule = 22;
                    TextView_Name.setText("18 (в Заречный)");
                    TextView_Route1.setText("КПП ПиТ - БАЭС - Десантник - Магнит - Ленинградская, 23 - Галактика - Ленина, 30 - РУС");
                    TextView_Price.setText("0 руб.");
                    break;
                case "SH19":
                    Schedule[0]=450;
                    Schedule[1]=1170;
                    CountSchedule = 2;
                    TextView_Name.setText("19 (в Заречный)");
                    TextView_Route1.setText("КПП ПиТ - БАЭС - Площадь - Аквариум - Радиотовары - Галактика - Профилакторий");
                    //ScheduleStr="6:35 (от площади), 7:30, 8:30, 11:35, 13:00, 16:15, 17:25, 20:05";
                    TextView_Price.setText("0 руб.");
                    break;
                case "HSIRM":
                    Schedule[0] = 815;
                    Schedule[1] = -815;
                    CountSchedule = 7;
                    TextView_Name.setText("ИРМ (на работу)");
                    TextView_Route1.setText("Дом торговли - Гостиница - Радиотовары - РУС - Поликлинника - Лермонтова - ИРМ");
                    TextView_Route2.setText("Курчатова, 29 - Магнит - Ленинградская, 23 - Галактика - Ленина, 30 - ИРМ");
                    TextView_Price.setText("0 руб.");
                    break;
                case "HS17":
                    Schedule[0]=390;
                    Schedule[1]=400;
                    Schedule[2]=410;
                    Schedule[3]=415;
                    Schedule[4]=420;
                    Schedule[5]=425;
                    Schedule[6]=430;
                    Schedule[7]=435;
                    Schedule[8]=440;
                    Schedule[9]=445;
                    Schedule[10]=450;
                    Schedule[11]=455;
                    Schedule[12]=460;
                    Schedule[13]=465;
                    Schedule[14]=470;
                    Schedule[15]=475;
                    Schedule[16]=480;
                    Schedule[17]=485;
                    Schedule[18]=-492;
                    Schedule[19]=-560;

                    Schedule[20]=-710;
                    Schedule[21]=-762;
                    Schedule[22]=-765;
                    Schedule[23]=-825;
                    Schedule[24]=-870;
                    Schedule[25]=-903;
                    Schedule[26]=-1095;
                    Schedule[27]=-1185;
                    Schedule[28]=-1350;
                    Schedule[29]=-1380;
                    CountSchedule = 30;
                    TextView_Name.setText("17 (на работу)");
                    TextView_Route1.setText("Гостиница - Радиотовары - РУС - БАЭС - ИРМ - КПП ПиТ");
                    TextView_Route2.setText("Гостиница - Радиотовары - РУС - Поликлиника - Лермонтова - БАЭС - КПП ПиТ");
                    TextView_Price.setText("0 руб.");
                    break;
                case "HS18":
                    Schedule[0]=390;
                    Schedule[1]=400;
                    Schedule[2]=410;
                    Schedule[3]=415;
                    Schedule[4]=425;
                    Schedule[5]=440;
                    Schedule[6]=445;
                    Schedule[7]=450;
                    Schedule[8]=460;
                    Schedule[9]=480;
                    Schedule[10]=485;
                    Schedule[11]=495;
                    Schedule[12]=702;
                    Schedule[13]=765;
                    Schedule[14]=915;
                    Schedule[15]=930;
                    CountSchedule = 16;
                    TextView_Name.setText("18 (на работу)");
                    TextView_Route1.setText("Магнит - Ленинградская, 23 - Галактика - Ленина, 30 - БАЭС - КПП ПиТ");
                    ScheduleStr="6:30, 6:40, 6:50, 6:55, 7:05, 7:20, 7:25, 7:30, 7:40, 8:00, 8:05, 8:15, 11:42 (от Десантника), 12:45 (от Десантника), 15:15, 15:30";
                    TextView_Price.setText("0 руб.");
                    break;
                case "HS19":
                    Schedule[0] = 480;
                    Schedule[1] = 1010;
                    Schedule[2] = 1200;
                    CountSchedule = 3;
                    TextView_Name.setText("19 (на работу)");
                    TextView_Route1.setText("Профилакторий - Ленинградская - Курчатова - Поликлиника - Лермонтова - БАЭС - КПП ПиТ");
                    //TextView_Route2.setText("Через Магнит");
                    TextView_Price.setText("0 руб.");
                    break;
                case "HS21":
                    Schedule[0]=400;
                    Schedule[1]=410;
                    Schedule[2]=420;
                    Schedule[3]=430;
                    Schedule[4]=440;
                    Schedule[5]=450;
                    Schedule[6]=460;
                    Schedule[7]=470;
                    Schedule[8]=480;
                    Schedule[9]=490;
                    Schedule[10]=500;
                    Schedule[11]=510;
                    Schedule[12]=520;
                    CountSchedule = 13;
                    TextView_Name.setText("21 (на работу)");
                    TextView_Route1.setText("Курчатова - Лермонтова - БАЭС - ИРМ");
                    TextView_Price.setText("0 руб.");
                    break;

            }
        }

        //108 и 112

        if (today==7 || today==1) {
            switch (Route) {
                case "ZE108":
                    Schedule[0] = 375;
                    Schedule[1] = 390;
                    Schedule[2] = 410;
                    Schedule[3] = 435;
                    Schedule[4] = 460;
                    Schedule[5] = 490;
                    Schedule[6] = 510;
                    Schedule[7] = 525;
                    Schedule[8] = 550;
                    Schedule[9] = 595;
                    Schedule[10] = 630;
                    Schedule[11] = 675;
                    Schedule[12] = 705;
                    Schedule[13] = 720;
                    Schedule[14] = 745;
                    Schedule[15] = 765;
                    Schedule[16] = 795;
                    Schedule[17] = 815;
                    Schedule[18] = 835;
                    Schedule[19] = 855;
                    Schedule[20] = 890;
                    Schedule[21] = 915;
                    Schedule[22] = 950;
                    Schedule[23] = 980;
                    Schedule[24] = 1000;
                    Schedule[25] = 1030;
                    Schedule[26] = 1060;
                    Schedule[27] = 1075;
                    Schedule[28] = 1090;
                    Schedule[29] = 1110;
                    Schedule[30] = 1160;
                    Schedule[31] = 1235;
                    CountSchedule = 32;
                    TextView_Name.setText("108 (в Белоярский)");
                    TextView_Route1.setText("Автовокзал - Площадь - Аквариум - Почта - ГИБДД - Простоквашино - Сады - Сельхозхимия - Мельзавод - Фабрика - Инструментальный - Сельэнерго - Бутаково - Универмаг - Центр - Белоярский");
                    ScheduleStr="6:15, 6:30*, 6:50, 7:15, 7:40, 8:10, 8:30*, 8:45, 9:10, 9:55*, 10:30, 11:15, 11:45*, 12:00, 12:25, 12:45, 13:15*, 13:35, 13:55, 14:15, 14:50*, 15:15, 15:50, 16:20, 16:40*, 17:10, 17:40, 17:55, 18:10*, 18:30, 19:20, 20:35";
                    TextView_Note.setText("* - только в субботу \n \n ВНИМАНИЕ! В связи с пандемией коронавирусной инфекции расписание автобусов меняется еженедельно! Проверяйте местные СМИ");
                    TextView_Price.setText("до 40 руб.");
                    break;
                case "EZ108":
                    Schedule[0]=375;
                    Schedule[1]=450;
                    Schedule[2]=465;
                    Schedule[3]=485;
                    Schedule[4]=505;
                    Schedule[5]=530;
                    Schedule[6]=560;
                    Schedule[7]=585;
                    Schedule[8]=600;
                    Schedule[9]=635;
                    Schedule[10]=670;
                    Schedule[11]=720;
                    Schedule[12]=750;
                    Schedule[13]=775;
                    Schedule[14]=790;
                    Schedule[15]=810;
                    Schedule[16]=835;
                    Schedule[17]=855;
                    Schedule[18]=875;
                    Schedule[19]=900;
                    Schedule[20]=930;
                    Schedule[21]=960;
                    Schedule[22]=990;
                    Schedule[23]=1020;
                    Schedule[24]=1055;
                    Schedule[25]=1070;
                    Schedule[26]=1100;
                    Schedule[27]=1115;
                    Schedule[28]=1130;
                    Schedule[29]=1150;
                    Schedule[30]=1200;
                    Schedule[31]=1270;
                    CountSchedule = 32;
                    TextView_Name.setText("108 (в Заречный)");
                    TextView_Route1.setText("Белоярский АВ - Центр - Универмаг - Бутаково - Сельэнерго - Инструментальный - Фабрика - Мельзавод - Сельхозхимия - Сады - Простоквашино - ГИБДД - Почта - Аквариум - Автовокзал Заречный");
                    ScheduleStr="6:55, 7:30, 7:45*, 8:05, 8:25, 8:50, 9:20, 9:45*, 10:00, 10:35*, 11:10, 12:00, 12:30*, 12:55, 13:10, 13:30, 13:55*, 14:15, 14:35, 15:00, 15:30*, 16:00, 16:30, 17:00, 17:35*, 17:50, 18:20, 18:35, 18:50*, 19:10, 20:00, 21:10";
                    TextView_Note.setText("* - только в субботу \n \n ВНИМАНИЕ! В связи с пандемией коронавирусной инфекции расписание автобусов меняется еженедельно! Проверяйте местные СМИ");
                    TextView_Price.setText("до 40 руб.");
                    break;

                case "ZE112":
                    Schedule[0]=410;
                    Schedule[1]=490;
                    Schedule[2]=575;
                    Schedule[3]=660;
                    Schedule[4]=830;
                    Schedule[5]=960;
                    Schedule[6]=1040;
                    Schedule[7]=1120;
                    Schedule[8]=1210;
                    CountSchedule = 9;
                    TextView_Name.setText("112 (в Боярку)");
                    TextView_Route1.setText("Площадь - Аквариум - Дом торговли - Гостиница - Парикмахерская (танк) - Флагман - Галактика - ГИБДД - Сады - Сельхозхимия - Мельзавод - Мезенское - Санаторий - Гагарина (Курманка) - Толмачева - Проезжая - Клубная (Гагарка) - Титова - Перекресток - 8 марта - Боярка");
                    TextView_Price.setText("до 40 руб.");
                     break;

                case "EZ112":
                    Schedule[0]=440;
                    Schedule[1]=530;
                    Schedule[2]=620;
                    Schedule[3]=705;
                    Schedule[4]=870;
                    Schedule[5]=1000;
                    Schedule[6]=1080;
                    Schedule[7]=1160;
                    CountSchedule = 8;
                    TextView_Name.setText("112 (в Заречный)");
                    TextView_Route1.setText("Боярка - 8 марта - Перекресток - Титова (Гагарка) - Клубная - Проезжая (Курманка) - Толмачева - Гагарина - Санаторий - Мезенское - Мельзавод - Сельхозхимия - Сады - Простоквашино - ГИБДД - Почта - Поликлиника - Площадь");
                    TextView_Price.setText("до 40 руб.");
                    break;
            }

        }
        else
        { switch (Route) {
            case "ZE108":
                Schedule[0]=375;
                Schedule[1]=390;
                Schedule[2]=410;
                Schedule[3]=435;
                Schedule[4]=460;
                Schedule[5]=490;
                Schedule[6]=510;
                Schedule[7]=525;
                Schedule[8]=550;
                Schedule[9]=595;
                Schedule[10]=630;
                Schedule[11]=675;
                Schedule[12]=705;
                Schedule[13]=720;
                Schedule[14]=745;
                Schedule[15]=765;
                Schedule[16]=795;
                Schedule[17]=815;
                Schedule[18]=835;
                Schedule[19]=855;
                Schedule[20]=890;
                Schedule[21]=915;
                Schedule[22]=950;
                Schedule[23]=980;
                Schedule[24]=1000;
                Schedule[25]=1030;
                Schedule[26]=1060;
                Schedule[27]=1075;
                Schedule[28]=1090;
                Schedule[29]=1110;
                Schedule[30]=1160;
                Schedule[31]=1235;
                CountSchedule = 32;
                TextView_Name.setText("108 (в Белоярский)");
                TextView_Route1.setText("Автовокзал - Площадь - Аквариум - Почта - ГИБДД - Простоквашино - Сады - Сельхозхимия - Мельзавод - Фабрика - Инструментальный - Сельэнерго - Бутаково - Универмаг - Центр - Белоярский");
                TextView_Price.setText("до 40 руб.");
                TextView_Note.setText("ВНИМАНИЕ! В связи с пандемией коронавирусной инфекции расписание автобусов меняется еженедельно! Проверяйте местные СМИ");
                break;
            case "EZ108":
                Schedule[0]=375;
                Schedule[1]=450;
                Schedule[2]=465;
                Schedule[3]=485;
                Schedule[4]=505;
                Schedule[5]=530;
                Schedule[6]=560;
                Schedule[7]=585;
                Schedule[8]=600;
                Schedule[9]=635;
                Schedule[10]=670;
                Schedule[11]=720;
                Schedule[12]=750;
                Schedule[13]=775;
                Schedule[14]=790;
                Schedule[15]=810;
                Schedule[16]=835;
                Schedule[17]=855;
                Schedule[18]=875;
                Schedule[19]=900;
                Schedule[20]=930;
                Schedule[21]=960;
                Schedule[22]=990;
                Schedule[23]=1020;
                Schedule[24]=1055;
                Schedule[25]=1070;
                Schedule[26]=1100;
                Schedule[27]=1115;
                Schedule[28]=1130;
                Schedule[29]=1150;
                Schedule[30]=1200;
                Schedule[31]=1270;
                CountSchedule = 32;
                TextView_Name.setText("108 (в Заречный)");
                TextView_Route1.setText("Белоярский АВ - Центр - Универмаг - Бутаково - Сельэнерго - Инструментальный - Фабрика - Мельзавод - Сельхозхимия - Сады - Простоквашино - ГИБДД - Почта - Аквариум - Автовокзал Заречный");
                TextView_Price.setText("до 40 руб.");
                TextView_Note.setText("ВНИМАНИЕ! В связи с пандемией коронавирусной инфекции расписание автобусов меняется еженедельно! Проверяйте местные СМИ");
                break;

            case "ZE112":
                Schedule[0]=410;
                Schedule[1]=490;
                Schedule[2]=575;
                Schedule[3]=660;
                Schedule[4]=745;
                Schedule[5]=830;
                Schedule[6]=910;
                Schedule[7]=960;
                Schedule[8]=1040;
                Schedule[9]=1120;
                Schedule[10]=1210;
                CountSchedule = 11;
                TextView_Name.setText("112 (в Боярку)");
                TextView_Route1.setText("Площадь - Аквариум - Дом торговли - Гостиница - Парикмахерская (танк) - Флагман - Галактика - ГИБДД - Сады - Сельхозхимия - Мельзавод - Мезенское - Санаторий - Гагарина (Курманка) - Толмачева - Проезжая - Клубная (Гагарка) - Титова - Перекресток - 8 марта - Боярка");
                TextView_Price.setText("до 40 руб.");
                break;
            case "EZ112":
                Schedule[0]=380;
                Schedule[1]=440;
                Schedule[2]=505;
                Schedule[3]=530;
                Schedule[4]=620;
                Schedule[5]=705;
                Schedule[6]=785;
                Schedule[7]=870;
                Schedule[8]=1000;
                Schedule[9]=1080;
                Schedule[10]=1160;

                CountSchedule = 11;
                TextView_Name.setText("112 (в Заречный)");
                TextView_Route1.setText("Боярка - 8 марта - Перекресток - Титова (Гагарка) - Клубная - Проезжая (Курманка) - Толмачева - Гагарина - Санаторий - Мезенское - Мельзавод - Сельхозхимия - Сады - Простоквашино - ГИБДД - Почта - Поликлиника - Площадь");
                TextView_Price.setText("до 40 руб.");
                break;
        }

        }


        if (ScheduleStr.equals("")) {
            for (int i = 0; i < Schedule.length; i++) {
                if (Schedule[i] != 0) {
                    if (Schedule[i] < 0) {
                        neg = true;
                        Schedule[i] = -Schedule[i];
                    } else neg = false;
                    Hour = Integer.toString(Schedule[i] / 60);
               //     if ((Schedule[i] / 60) == 24) Hour = "0";

                    Minute = Integer.toString(Schedule[i] % 60);
                    if (Minute.length() == 1) Minute = "0" + Minute;
                    if (Hour.equals("24")) Hour = "0";

                    if (neg) {
                        ScheduleStr2 = ScheduleStr2 + Hour + ":" + Minute + ", ";
                    } else                     ScheduleStr = ScheduleStr + Hour + ":" + Minute + ", ";
                }
            }
            ScheduleStr = ScheduleStr.substring(0, ScheduleStr.length()-2);
           if (ScheduleStr2.length()>1)             ScheduleStr2 = ScheduleStr2.substring(0, ScheduleStr2.length()-2);
        }





        TextView_Schedule.setText(ScheduleStr);
      TextView_Schedule2.setText(ScheduleStr2);

        Calendar calendar = Calendar.getInstance();//Получение времени
        int Hours = (calendar.get(Calendar.HOUR_OF_DAY))%24;
        int Minutes = calendar.get(Calendar.MINUTE);
        int curTime = Hours*60+Minutes;

        Integer Closest = Schedule[0];//Нахождение ближайшего рейса

        int Diff=0;
        for (int i=0;i<CountSchedule;i++) {
            if (curTime > Schedule[i] && i != CountSchedule - 1)

                Closest = Schedule[i+1];
        }
        Hour=Integer.toString(Closest/60);//Перевод в часы и минуты
        Minute=Integer.toString(Closest%60);
        if (Minute.length()==1) Minute="0"+Minute;
        String ClosestStr = Hour+":"+Minute;


        if (curTime > Schedule[CountSchedule-1])//Рейс последний?
            Last=true;

        Diff = Closest-curTime;

        if (Minute.length()==1) Minute="0"+Minute;



        if (Last) {
            TextView_Closest.setText("Сегодня рейсов нет");
            TextView_Hour.setText("-");
            TextView_Min.setText("-");
        }
        else {
            TextView_Closest.setText(String.valueOf(ClosestStr));
            TextView_Hour.setText(String.valueOf(Integer.toString(Diff/60)));
            TextView_Min.setText(String.valueOf(Integer.toString(Diff%60)));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Schedule.this, About.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings3) {
            Intent intent = new Intent(Schedule.this, Schedule.class);
            String Route = getIntent().getExtras().getString("Route");
            intent.putExtra("Route", Route);
            intent.putExtra("today", 0);
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();//6
            overridePendingTransition(0, 0);
            startActivity(intent);
            return true;

        }  else if (id == R.id.action_settings4) {
            Intent intent = new Intent(Schedule.this, Schedule.class);
            String Route = getIntent().getExtras().getString("Route");
            intent.putExtra("Route", Route);
            intent.putExtra("today", 3);
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();//6
            overridePendingTransition(0, 0);
            startActivity(intent);
            return true;

        }  else if (id == R.id.action_settings5) {
            Intent intent = new Intent(Schedule.this, Schedule.class);
            String Route = getIntent().getExtras().getString("Route");
            intent.putExtra("Route", Route);
            intent.putExtra("today", 7);
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();//6
            overridePendingTransition(0, 0);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);



    }

}
