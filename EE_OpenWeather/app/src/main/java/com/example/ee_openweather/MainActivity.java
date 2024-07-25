package com.example.ee_openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    EditText txtLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnGetWeather);
        txtLoc = findViewById(R.id.editTextText);

        Picasso.with(getApplicationContext()).load(Uri.parse("https://img.freepik.com/free-psd/3d-icon-weather-conditions-with-rain-sun_23-2150108737.jpg?size=338&ext=jpg&ga=GA1.1.2008272138.1721347200&semt=ais_user")).resize(300,0).into(((ImageView) findViewById(R.id.imgEU)));
    }

    public void setOnClickListener(View view) {
        String loc = txtLoc.getText().toString();
        Intent i = new Intent(MainActivity.this, WeatherForcastActivity.class);
        i.putExtra("location", loc);
        startActivity(i);
    }
}