package com.example.marlon_pc.projectdesign2.Controlador;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ConexionWatson extends AsyncTask<String, Void, String>{
    protected String doInBackground(String... strings) {
        URL url = null;
        try {
            url = new URL(strings[0]);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("authorization", strings[2]);

            conn.setRequestMethod(strings[1]);
            conn.setRequestProperty("Content-Type","application/json");
            //Log.i("CODIGO REQUEST", String.valueOf(conn.getResponseCode()));
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuilder jsonResponse = new StringBuilder();
                BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String strLine = null;
                while ((strLine = input.readLine()) != null) {
                        jsonResponse.append(strLine);
                    }
                    input.close();
                    return jsonResponse.toString();
                }else{
                    return "Error";
                }

        } catch (MalformedURLException e) {
            //e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }

    }


}
