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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    int ticks = 0;
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

        Button hidden = (Button)  findViewById(R.id.hiddenbutton);
        ImageView bluy= (ImageView) findViewById(R.id.bluy);
        hidden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ticks++;
                if(ticks>10){
                    bluy.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}