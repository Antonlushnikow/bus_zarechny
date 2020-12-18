package com.tonych.bus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Trans extends AppCompatActivity {

    Button button126;
    Button button191;
    Button button108;
    Button button112;
    Button button24;
    public String Route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        Route = getIntent().getExtras().getString("Route");
        button126 = (Button) findViewById(R.id.button1);
        button126.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Trans.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "126";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button191 = (Button) findViewById(R.id.button2);
        button191.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Trans.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "191";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button108 = (Button) findViewById(R.id.button3);
        button108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Trans.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "108";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button112 = (Button) findViewById(R.id.button4);
        button112.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Trans.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "112";
                intent.putExtra("Route", Route);
                startActivity(intent);
            }
        });

        button24 = (Button) findViewById(R.id.button5);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(Trans.this, Schedule.class);
                Route = getIntent().getExtras().getString("Route");
                Route += "24";
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
            Intent intent = new Intent(Trans.this, About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
