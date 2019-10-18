package com.example.cagairsidemonitoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Staff;
    private EditText PIN;
    private TextView Info;
    private Button Enter;
    private int counter = 5;
hi hi hi hi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Staff = (EditText) findViewById(R.id.etStaff);
        PIN = (EditText) findViewById(R.id.etPIN);
        Info = (TextView) findViewById(R.id.tvInfo);
        Enter = (Button) findViewById(R.id.btnEnter);

        Info.setText("Number of attempts remaining: 5");

        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Staff.getText().toString(), PIN.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPIN) {
        if ((userName.equals("user")) && (userPIN.equals("0000"))) {
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
        } else {

                   counter--;
                   Info.setText("Number of attempts remaining: " + String.valueOf(counter));

                   if (counter == 0) {
                       Enter.setEnabled(false);
                   }


                }




        }
    }