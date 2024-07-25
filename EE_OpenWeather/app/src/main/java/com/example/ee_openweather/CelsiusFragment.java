package com.example.ee_openweather;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CelsiusFragment extends Fragment {



    TextView txtViC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_celsius, container, false);
        txtViC = view.findViewById(R.id.txtCelc);
        String loc = "";

        Bundle extras = getArguments();

        if (extras != null) {
            loc = extras.getString("location");
            double c = extras.getDouble("celsius");
            txtViC.setText("Here in " + loc + " is " + c + " degrees celsius");
        }

        return view;
    }
}