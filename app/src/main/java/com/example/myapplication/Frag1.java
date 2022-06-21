package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Frag1 extends Fragment {

    double d=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToggleButton sex = (ToggleButton) getView().findViewById(R.id.sex);
        EditText alcohol = (EditText) getView().findViewById(R.id.alcohol);
        EditText weight = (EditText) getView().findViewById(R.id.weight);
        ImageButton shot = (ImageButton) getView().findViewById(R.id.shot);
        ImageButton glass = (ImageButton) getView().findViewById(R.id.glass);
        ImageButton bottle = (ImageButton) getView().findViewById(R.id.bottle);
        TextView alcPercentage = (TextView)  getView().findViewById(R.id.alcPercentage);
        TextView eqBeer = (TextView)  getView().findViewById(R.id.eqBeer);
        TextView eqSoju = (TextView)  getView().findViewById(R.id.eqSoju);

        shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alcPercentage.setText(String.format("%.2f",d));
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag1, container, false);
    }
}