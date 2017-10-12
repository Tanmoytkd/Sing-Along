package com.project1.musicapp.singalong;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);





        Thread timer=new Thread(){
            public void run(){
                try
                {
                    sleep(5000);
                }
                catch (InterruptedException en)
                {
                    en.printStackTrace();
                }
                finally {
                    Intent i=new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                }
            }
        };
        timer.start();


    }
}
