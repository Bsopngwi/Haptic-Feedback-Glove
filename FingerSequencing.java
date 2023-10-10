package com.example.phoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
public class FingerSequencing extends AppCompatActivity implements View.OnClickListener  {
    Button prev;
    Button save;

    EditText fingerSequencing;

    String fingerSequence;

    post_request requesTs=new post_request();

    String value="Data is saved and sent";

    private String jsondata() {
        JSONObject data=new JSONObject();
        try {
            data.put("Finger Sequencing",fingerSequence);
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
        setContentView(R.layout.activity_finger_sequencing);
        prev=(Button) findViewById(R.id.prev);
        save= (Button) findViewById(R.id.save);
        fingerSequencing=(EditText) findViewById(R.id.editFSequencing) ;


        prev.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.prev ){

            Intent intent=new Intent(FingerSequencing.this,MainActivity.class);
            startActivity(intent);

            finish();
        }
        if (view.getId()==R.id.save ){
            fingerSequence=fingerSequencing.getText().toString();
            sendpostrequest();
            Intent intent=new Intent(FingerSequencing.this,MainActivity.class);
            intent.putExtra("key",value);
            startActivity(intent);

        }

    }
}