package com.project1.musicapp.singalong;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity{
        public static final String EXTRA_MESSAGE = "com.project1.musicapp.singalong.MESSAGE";
    Button b1,b2;
    EditText edit1,edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        edit1 = (EditText) findViewById(R.id.editText);
        edit2 = (EditText) findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.button:
                        if (edit1.getText().toString().matches("") && edit2.getText().toString().matches("")) {
                            Toast.makeText(getApplicationContext(),
                                    "WRONG", Toast.LENGTH_SHORT).show();}
                         else {
                            Toast.makeText(getApplicationContext(), "Please Wait....", Toast.LENGTH_SHORT).show();
                            sendMessage(view);
                        }
                                                break;
                    case R.id.button2:
                        sendMessage2(view);
                        break;
                }

            //if (edit1.getText().toString().matches("") && edit2.getText().toString().matches("")) {
                //Toast.makeText(getApplicationContext(),
                        //"WRONG", Toast.LENGTH_SHORT).show();
            //} else {
                //Toast.makeText(getApplicationContext(), "Please Wait....", Toast.LENGTH_SHORT).show();
           // }

        }
        });
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, Regpage.class);
        startActivity(intent);
    }
    public void sendMessage2(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrationPage.class);
        startActivity(intent);
    }
}

