package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Meals extends AppCompatActivity {
 SharedPreferences sharedPreferences , sharedPreferences2;
 TextView textView ;
 Button meals , Measure ,State , Profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        textView = findViewById(R.id.Hello);
        meals = findViewById(R.id.addMeals);
        Measure = findViewById(R.id.addMeasure);
        State = findViewById(R.id.State);
        Profile = findViewById(R.id.profile);
        sharedPreferences = getSharedPreferences("log" , Activity.MODE_PRIVATE);
        sharedPreferences2 = getSharedPreferences("Data" , Activity.MODE_PRIVATE);
        int id = sharedPreferences.getInt("id" , 8);
        textView.setText("Hello " + sharedPreferences2.getString("name" + id,""));
        meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Add_Meals.class);
                startActivity(intent);
            }
        });
        Measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Add_Measur.class);
                startActivity(intent);
            }
        });
        State.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Statistic.class);
                startActivity(intent);
            }
        });
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),YourProfile.class);
                startActivity(intent);
            }
        });
    }
}