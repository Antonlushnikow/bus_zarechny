package com.tonych.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Route extends AppCompatActivity {

   Button button17;
   Button button18;
   Button button19;
   Button button21;
   Button buttonIRM;
   public String Route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Route = getIntent().getExtras().getString("Route");
        button17 = (Button) findViewById(R.id.button1);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Route.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "17";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button18 = (Button) findViewById(R.id.button2);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Route.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "18";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button19 = (Button) findViewById(R.id.button3);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Route.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "19";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button21 = (Button) findViewById(R.id.button4);
        if (Route.equals("SH")) { button21.setVisibility(View.GONE);}


        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Route.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "21";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        buttonIRM = (Button) findViewById(R.id.button5);
        buttonIRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Route.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "IRM";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(Route.this, About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
