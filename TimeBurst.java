package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import com.example.phoneapp.post_request;
public class TimeBurst extends AppCompatActivity implements View.OnClickListener {
    Button prev;
    Button save;
    EditText burst_number;
    TextView burstView;

    String value="Data is saved and sent";

    String burstvalue;
    JSONObject data=new JSONObject();
    post_request requesTs=new post_request();


    private String jsondata() {
        JSONObject data=new JSONObject();
        try {
            data.put("Time Burst",burstvalue);
            Log.i("Data",data.toString());
            return data.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendpostrequest(){
        String jsonData= jsondata();
        String url="https://2512-192-58-125-13.ngrok-free.app";

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_burst);
        prev=(Button) findViewById(R.id.prev);
        save= (Button) findViewById(R.id.save);
        burst_number=(EditText) findViewById(R.id.editTextNumber) ;
        burstView=(TextView)findViewById(R.id.setTimeBurst);


        prev.setOnClickListener(this);
        save.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.prev ){
            //tGloveC.setText("Frequency is clicked!");
            Intent intent=new Intent(TimeBurst.this,MainActivity.class);
            startActivity(intent);

            finish();
        }
        if (view.getId()==R.id.save ){

            burstvalue=burst_number.getText().toString();
            sendpostrequest();

            Intent intent=new Intent(TimeBurst.this,MainActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);

        }

    }
}