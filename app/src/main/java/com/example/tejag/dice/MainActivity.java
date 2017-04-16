package com.example.tejag.dice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int usero=0;
    int userturn=0;
    int cpuo=0;
    int cputurn=0;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Roll(View view) {
        Random r=new Random();
        score= r.nextInt(7);
        TextView info=(TextView)findViewById(R.id.textView);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        switch(score){
            case 1:
                userturn=0;
                score=r.nextInt(7);
                delay();
                cpuo = cpuo + cputurn;
                cputurn = 0;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice1);
                break;
            case 2:
                userturn=userturn+score;
                image.setImageResource(R.drawable.dice2);
                break;
            case 3:
                userturn=userturn+score;
                image.setImageResource(R.drawable.dice3);
                break;
            case 4:
                userturn=userturn+score;
                image.setImageResource(R.drawable.dice4);
                break;
            case 5:
                userturn=userturn+score;
                image.setImageResource(R.drawable.dice5);
                break;
            case 6:
                userturn=userturn+score;
                image.setImageResource(R.drawable.dice6);
                break;
        }
        info.setText(" user score: "+usero+" user turn score: "+userturn+" computer score: "+cpuo);
    }

    public void reset(View view) {
        TextView info=(TextView)findViewById(R.id.textView);
        info.setText("");
        userturn=0;
        usero=0;
        cpuo=0;
        cputurn=0;
        Toast.makeText(getApplicationContext(),"reset completed!",Toast.LENGTH_SHORT).show();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageDrawable(null);
    }

    public void hold(View view) {
        Random r=new Random();
        score=r.nextInt(7);
            delay();
        TextView info = (TextView) findViewById(R.id.textView);
        info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
    }
    public void delay(){
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Button btn=(Button)findViewById(R.id.button);
                Button btn2=(Button)findViewById(R.id.button2);
                if(usero>100){
                    Toast.makeText(getApplicationContext(),"you win!",Toast.LENGTH_SHORT).show();
                    TextView info=(TextView)findViewById(R.id.textView);
                    info.setText("");
                    userturn=0;
                    usero=0;
                    cpuo=0;
                    cputurn=0;
                    //Toast.makeText(getApplicationContext(),"reset completed!",Toast.LENGTH_SHORT).show();
                    ImageView image = (ImageView) findViewById(R.id.imageView);
                    image.setImageDrawable(null);

                }
                else if(cpuo>100){
                    Toast.makeText(getApplicationContext(),"cpu win!",Toast.LENGTH_SHORT).show();
                    TextView info=(TextView)findViewById(R.id.textView);
                    info.setText("");
                    userturn=0;
                    usero=0;
                    cpuo=0;
                    cputurn=0;
                    //Toast.makeText(getApplicationContext(),"reset completed!",Toast.LENGTH_SHORT).show();
                    ImageView image = (ImageView) findViewById(R.id.imageView);
                    image.setImageDrawable(null);

                }
                if(score!=1 && cputurn<20) {
                    Toast.makeText(getApplicationContext(),"computer's turn!",Toast.LENGTH_SHORT).show();
                    cpuplay();
                    btn.setClickable(false);
                    btn2.setClickable(false);
                }
                else {
                    Toast.makeText(getApplicationContext(), "user's turn!", Toast.LENGTH_SHORT).show();
                    btn.setClickable(true);
                    btn2.setClickable(true);
                    cpuo = cpuo + cputurn;
                    cputurn = 0;
                }
            }
        },500);

    }
    public void cpuplay() {
        ImageView image = (ImageView) findViewById(R.id.imageView);
        usero = usero + userturn;
        userturn = 0;
        Random r = new Random();
        TextView info = (TextView) findViewById(R.id.textView);

        delay();
        score = r.nextInt(7);
        switch (score) {
            case 1:
                cputurn = 0;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice1);
                //Toast.makeText(getApplicationContext(),"user's turn!",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                cputurn = cputurn + score;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice2);
                break;
            case 3:
                cputurn = cputurn + score;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice3);
                break;
            case 4:
                cputurn = cputurn + score;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice4);
                break;
            case 5:
                cputurn = cputurn + score;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice5);
                break;
            case 6:
                cputurn = cputurn + score;
                info.setText(" user score: " + usero + " computer score: " + cpuo + " computer turn score: " + cputurn);
                image.setImageResource(R.drawable.dice6);
                break;
        }
    }

}
