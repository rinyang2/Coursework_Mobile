package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class AlculatorActivity extends AppCompatActivity {
    double A=0;
    double C=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alculator);

        Intent wasted = new Intent(getApplicationContext(), WastedActivity.class);
        ToggleButton sex = (ToggleButton) findViewById(R.id.sex);
        EditText alcohol = (EditText) findViewById(R.id.alcohol);
        EditText weight = (EditText) findViewById(R.id.weight);
        ImageButton shot = (ImageButton) findViewById(R.id.shot);
        ImageButton glass = (ImageButton) findViewById(R.id.glass);
        ImageButton bottle = (ImageButton) findViewById(R.id.bottle);
        TextView alcPercentage = (TextView)  findViewById(R.id.alcPercentage);
        TextView eqBeer = (TextView)  findViewById(R.id.eqBeer);
        TextView eqSoju = (TextView)  findViewById(R.id.eqSoju);
        Button potentialCriminal = (Button) findViewById(R.id.potentialCriminal);
        ImageButton oneHourLater = (ImageButton) findViewById(R.id.onehourlater);

        oneHourLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(C>0.015) {
                    C -= 0.015;
                    alcPercentage.setText(String.format("%.3f %%", C));
                }
                else{
                    A=0;
                    C = 0;
                    alcPercentage.setText(String.format("%.3f %%", C));
                }
            }
        });

        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A = 0;
                C = 0;
                alcPercentage.setText(String.format("%.2f %%",C));
                eqBeer.setText(String.format("%.2f", 22.2*A ));
                eqSoju.setText(String.format("%.2f", A/8.64));
            }
        });

        shot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    A += 44 * (Double.parseDouble(alcohol.getText().toString()) / 100);
                    C= (A * 0.7894 *0.7) / (10 * Double.parseDouble(weight.getText().toString()) * R(sex.isChecked()));
                    if(C>0.5){startActivity(wasted);}
                    alcPercentage.setText(String.format("%.3f %%", C));
                    eqBeer.setText(String.format("%.2f", 22.2 * A));
                    eqSoju.setText(String.format("%.2f", A/8.64));
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }
            }
        });
        glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    A += 150 * (Double.parseDouble(alcohol.getText().toString()) / 100);
                    C = (A * 0.7894 *0.7) / (10 * Double.parseDouble(weight.getText().toString()) * R(sex.isChecked()));
                    if(C>0.5){startActivity(wasted);}
                    alcPercentage.setText(String.format("%.3f %%", C));
                    eqBeer.setText(String.format("%.2f", 22.2 * A));
                    eqSoju.setText(String.format("%.2f", A/8.64));
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }
            }
        });
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    A += 750 * (Double.parseDouble(alcohol.getText().toString()) / 100);
                    C = (A * 0.7894 * 0.7) / (10 * Double.parseDouble(weight.getText().toString()) * R(sex.isChecked()));
                    if(C>0.5){startActivity(wasted);}
                    alcPercentage.setText(String.format("%.3f %%", C));
                    eqBeer.setText(String.format("%.2f", 22.2 * A));
                    eqSoju.setText(String.format("%.2f", A/8.64));
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }
            }
        });

        potentialCriminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(C>0) {
                    Toast.makeText(getApplicationContext(), "Shame on you", Toast.LENGTH_LONG).show();
                    Intent gotoHell = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.addictioncenter.com/alcohol/drunk-driving/"));
                    startActivity(gotoHell);
                }
                else{
                    Toast.makeText(getApplicationContext(), "This application doesn't guarantee you anything. Always think before", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private double R(boolean b){
        if(b){
            return 0.64;//
        }
        else{
            return 0.86;
        }
    }
}
