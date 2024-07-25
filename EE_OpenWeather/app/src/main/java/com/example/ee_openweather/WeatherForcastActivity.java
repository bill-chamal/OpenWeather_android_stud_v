package com.example.ee_openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WeatherForcastActivity extends AppCompatActivity {

    private final String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String url2 = "&APPID=<<!YOUR API KEY FROM OPEN WEATHER!>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forcast);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            String loc = b.getString("location");

            OkHttpHandler ok = new OkHttpHandler();

            ok.execute(url1 + loc + url2);
            double celsius =   ok.getCelsius();
            double feel_like = ok.getFeelLike();


            Bundle fb = new Bundle();
            fb.putString("location", loc);
            fb.putDouble("celsius", celsius);

            CelsiusFragment celsiusFragment = new CelsiusFragment();
            celsiusFragment.setArguments(fb);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2, celsiusFragment, "NaN").commit();

            ((TextView)findViewById(R.id.txtWeatherDetails)).setText("Feels like " + feel_like);
        }

    }
}