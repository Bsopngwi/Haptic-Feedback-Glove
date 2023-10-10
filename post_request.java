package com.example.phoneapp;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class post_request {
    public String sendPost(String url, String json) throws Exception {
        //HttpPost post= new HttpPost(url);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Set the request method to POST
        con.setRequestMethod("POST");

        // Set the request headers
        //con.setRequestProperty("Content-Type", "application/json");

        // Enable output and input for the connection
        con.setDoOutput(true);
        con.setDoInput(true);

        // Create the JSON data to send
        byte[] postDataBytes = json.getBytes("UTF-8");

        // Write the JSON data to the connection's output stream
        OutputStream os = con.getOutputStream();
        os.write(postDataBytes);
        os.flush();
        os.close();

//        // Get the response code
        int responseCode = con.getResponseCode();
//
//        // Read the response from the connection's input stream
        String code="go";
        return code;
    }
}
