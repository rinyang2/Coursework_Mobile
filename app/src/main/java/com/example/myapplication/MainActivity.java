package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    double C;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button alculator = (Button)  findViewById(R.id.alculator);
        alculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAlculator = new Intent(getApplicationContext(), AlculatorActivity.class);
                startActivity(startAlculator);
            }
        });

        Button drinks = (Button)  findViewById(R.id.drinks);
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                //show how to pass information to another activity
                startIntent.putExtra("extraKey", "HELLO WORLD!");

                startActivity(startIntent);
            }
        });

    }

}