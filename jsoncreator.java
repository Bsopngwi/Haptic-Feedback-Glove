package com.example.phoneapp;
import org.json.JSONException;
import org.json.JSONObject;

public class jsoncreator {
    JSONObject data=new JSONObject();
    public void frequencyData(String f) throws JSONException {

        data.put("Frequency",f);

    }
    public void timeBurst(String t) throws JSONException {
        data.put("Time Burst",t);
    }
    public void fingerSequencing(String fg) throws JSONException {
        data.put("Finger Sequency",fg);
    }
}
