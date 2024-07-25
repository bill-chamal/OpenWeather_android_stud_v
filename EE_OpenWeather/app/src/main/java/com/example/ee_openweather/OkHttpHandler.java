package com.example.ee_openweather;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler{

    private double celsius, feelLike;

    public  OkHttpHandler(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    public void execute(String url) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST",body).build();
        try {
            Response response = client.newCall(request).execute();
            String data = response.body().string();

            JSONObject json = new JSONObject(data);

            celsius     =   json.getJSONObject("main").getDouble("temp") - 273.15;
            feelLike    =   json.getJSONObject("main").getDouble("feels_like") - 273.15;

            int c =  (int)celsius*100;
            int fL =  (int)feelLike*100;

            celsius = (double)c/100;
            feelLike = (double)fL/100;

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFeelLike() {
        return feelLike;
    }

    public void setFeelLike(double feelLike) {
        this.feelLike = feelLike;
    }
}
