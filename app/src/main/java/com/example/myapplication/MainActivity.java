package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//aaa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText firstNumEditText = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText secondNumEditText = (EditText) findViewById(R.id.editTextTextPersonName2);
                TextView resultTextView = (TextView) findViewById(R.id.resultText);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1+num2;
                resultTextView.setText(result+"");
            }
        });

        Button secondActivity = (Button)  findViewById(R.id.button2);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                //show how to pass information to another activity
                startIntent.putExtra("extraKey", "HELLO WORLD!");

                startActivity(startIntent);
            }
        });

        Button googleBtn = (Button) findViewById(R.id.google);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if(gotoGoogle.resolveActivity(getPackageManager())!=null){
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}