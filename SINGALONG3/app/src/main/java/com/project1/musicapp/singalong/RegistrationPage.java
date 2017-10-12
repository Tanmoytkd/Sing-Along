package com.project1.musicapp.singalong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class RegistrationPage extends AppCompatActivity {
    Button register;
    EditText t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);

        register = (Button) findViewById(R.id.Regge);
        t1 = (EditText) findViewById(R.id.editText3);
        t2 = (EditText) findViewById(R.id.editText4);
        t3 = (EditText) findViewById(R.id.editText5);
        t4 = (EditText) findViewById(R.id.editText7);
        t5 = (EditText) findViewById(R.id.editText8);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t1.getText().toString().matches("") || t2.getText().toString().matches("") || t3.getText().toString().matches("") || t4.getText().toString().matches("") || t5.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(),
                            "WRONG", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Welcome,Buddy!!", Toast.LENGTH_SHORT).show();
                    gogo(view);
                }
            }
        });
    }

    public void gogo(View view) {
        Intent intent = new Intent(RegistrationPage.this, MainActivity.class);
        startActivity(intent);
    }

}