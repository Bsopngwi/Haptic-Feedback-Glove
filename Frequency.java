package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.SeekBar;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;
import com.example.phoneapp.post_request;

public class Frequency extends AppCompatActivity implements View.OnClickListener {
Button prev;
Button save;

SeekBar seekbar;
TextView ratingpop;

String freqvalue;
post_request requesTs=new post_request();



    private String jsondata() {
        JSONObject data=new JSONObject();
        try {
            data.put("Frequency",freqvalue);
            Log.i("Data",data.toString());
            return data.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendpostrequest(){
        String jsonData= jsondata();
        String url= "https://2512-192-58-125-13.ngrok-free.app";

        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {

                try {
                    return requesTs.sendPost(url,jsonData);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }.execute();
    }
String value="Data is saved and sent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frequency);
        prev=(Button) findViewById(R.id.prev);
        save= (Button) findViewById(R.id.save);
        seekbar=(SeekBar) findViewById(R.id.seekBar);
        ratingpop=(TextView) findViewById(R.id.rating);

        prev.setOnClickListener(this);
        save.setOnClickListener(this);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                ratingpop.setText("Frequency= "+ String.valueOf(progress));
                freqvalue= ""+ progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.prev ){
            //tGloveC.setText("Frequency is clicked!");
            Intent intent=new Intent(Frequency.this,MainActivity.class);
            startActivity(intent);

            finish();
        }
        if (view.getId()==R.id.save ){
            sendpostrequest();


           // gfgThread.start();


//            try {
//                requesTs.sendPost(url,data.toString());
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
            Intent intent=new Intent(Frequency.this,MainActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);

        }

    }
}