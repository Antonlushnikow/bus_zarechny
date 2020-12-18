package com.tonych.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonHS;
    Button buttonSH;
    Button buttonZE;
    Button buttonEZ;
    Button buttonZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonHS = (Button) findViewById(R.id.button1);
        buttonSH = (Button) findViewById(R.id.button2);
        buttonZE = (Button) findViewById(R.id.button3);
        buttonEZ = (Button) findViewById(R.id.button4);
        buttonZ = (Button) findViewById(R.id.button5);

        buttonHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, Route.class);
                intent.putExtra("Route", "HS");
                startActivity(intent);
            }
        });

        buttonSH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, Route.class);
                intent.putExtra("Route", "SH");
                startActivity(intent);
            }
        });

        buttonZE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, Trans.class);
                intent.putExtra("Route", "ZE");
                startActivity(intent);
            }
        });

        buttonEZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, Trans.class);
                intent.putExtra("Route", "EZ");
                startActivity(intent);
            }
        });

        buttonZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                intent.putExtra("Route", "Z23");
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
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
