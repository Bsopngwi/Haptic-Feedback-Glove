package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.TextView;

import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button bFrequency;
Button bTimeburst;
Button bFingerS;
TextView tGloveC;
TextView popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //using findViewById to find the ID matching the button
        bFrequency=(Button) findViewById(R.id.frequency);
        bTimeburst= (Button) findViewById(R.id.timeBurst);
        bFingerS=(Button) findViewById(R.id.fingerSequencing);
        //same but for TextView
        tGloveC=(TextView) findViewById(R.id.glove_testView);
        popup=(TextView) findViewById(R.id.popup);
        bFrequency.setOnClickListener(this);
        bTimeburst.setOnClickListener(this);
        bFingerS.setOnClickListener(this);
        String text= getIntent().getStringExtra("key");

        if (text!=null){
            popup.setText(text);
        }
    }

    @Override
    public void onClick(View view) {
       //check which button the user is clicking
        //if the button that is being clicked on is equal to
        //a specific ID as below
       if (view.getId()==R.id.frequency) {
           //tGloveC.setText("Frequency is clicked!");
           Intent intent=new Intent(MainActivity.this,Frequency.class);
           startActivity(intent);

       }
       if (view.getId()==R.id.timeBurst){
           //tGloveC.setText("TimeBurst is clicked!");
           Intent intent=new Intent(MainActivity.this,TimeBurst.class);
           startActivity(intent);
       }
       if (view.getId()==R.id.fingerSequencing){
           //tGloveC.setText("Finger Sequencing is clicked!");
           Intent intent=new Intent(MainActivity.this,FingerSequencing.class);
           startActivity(intent);
       }
    }
}