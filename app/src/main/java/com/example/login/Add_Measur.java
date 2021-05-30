package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.icu.util.Measure;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Measur extends AppCompatActivity {
    TextView textView;
    int id, SizeMeasure;
    EditText beforeMeal, afterMeal, randomMeal;
    CheckBox before, after, random;
    Button Save;
    int DayMeasure ,MonthMeasure ,YearMeasure , DayDiab , MonthDiab , YearDiab;
    Spinner day, month, year;
    ArrayAdapter<Integer> arrayAdapter, arrayAdapter2, arrayAdapter3;
    List<Integer> items, items1, items2;
    SharedPreferences sharedPreferences, LogId, DateMeasure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__measur);
        textView = findViewById(R.id.YourMeasur);
        day = findViewById(R.id.dayMeas);
        month = findViewById(R.id.monthMeas);
        year = findViewById(R.id.yearMeas);
        sharedPreferences = getSharedPreferences("Data", Activity.MODE_PRIVATE);
        LogId = getSharedPreferences("log", Activity.MODE_PRIVATE);
        DateMeasure = getSharedPreferences("DateMeasure" , Activity.MODE_PRIVATE);
        id = LogId.getInt("id", 100);
        textView.setText("Add Measurement ,  " + sharedPreferences.getString("name" + id, ""));
        beforeMeal = findViewById(R.id.MeasureBefore);
        afterMeal = findViewById(R.id.MeasureAfter);
        randomMeal = findViewById(R.id.MeasureRandomly);
        before = findViewById(R.id.Before);
        after = findViewById(R.id.After);
        random = findViewById(R.id.Randomly);
        YearDiab = Integer.parseInt(sharedPreferences.getString("yearDiab" + id, "2000"));
        MonthDiab = Integer.parseInt(sharedPreferences.getString("monthDiab" + id, "2000"));
        DayDiab = Integer.parseInt(sharedPreferences.getString("dayDiab" + id, "2000"));
        Save = findViewById(R.id.save_measure);
        dateMeasurement();
        proccesCheakBox(); // Cheak if edit text is fill and cheakbox is enable and save Data
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (beforeMeal.getText().toString().equals("") || afterMeal.getText().toString().equals("") || randomMeal.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill the fields", Toast.LENGTH_SHORT).show();
                }
                else if (YearMeasure < YearDiab || YearMeasure == YearDiab && MonthMeasure < MonthDiab
                            || YearMeasure == YearDiab && MonthMeasure == MonthDiab && DayMeasure < DayDiab) {
                        Toast.makeText(getApplicationContext(), "Error In Date Measurement ", Toast.LENGTH_SHORT).show();
                    }
                else {
                    SharedPreferences.Editor editor2 = DateMeasure.edit();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    SizeMeasure = sharedPreferences.getInt("Measure" + id, 0);
                    editor.putString("Before" + id + SizeMeasure, beforeMeal.getText().toString());
                    editor.putString("After" + id + SizeMeasure, afterMeal.getText().toString());
                    editor.putString("Random" + id + SizeMeasure, randomMeal.getText().toString());
                    editor2.putString("DayMeas"  + id + SizeMeasure , String.valueOf(DayMeasure));
                    editor2.putString("MonthMeas" +id + SizeMeasure , String.valueOf(MonthMeasure));
                    editor2.putString("YearMeas" +id + SizeMeasure, String.valueOf(YearMeasure));
                    SizeMeasure++;
                    editor.putInt("Measure" + id, SizeMeasure);
                    editor.apply();
                    editor2.apply();
                    Toast.makeText(getApplicationContext(), "Saved Succeeded", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    private void proccesCheakBox() {
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (before.isChecked()) {
                    beforeMeal.setEnabled(true);
                } else {
                    beforeMeal.getText().clear();
                    beforeMeal.setEnabled(false);
                }
            }
        });
        after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (after.isChecked()) {
                    afterMeal.setEnabled(true);
                } else {
                    afterMeal.getText().clear();
                    afterMeal.setEnabled(false);
                }

            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (random.isChecked()) {
                    randomMeal.setEnabled(true);
                } else {
                    randomMeal.getText().clear();
                    randomMeal.setEnabled(false);
                }
            }
        });
    }

    private void dateMeasurement() {
        items = new ArrayList<>();
        items1 = new ArrayList<>();
        items2 = new ArrayList<>();
        items.add(0, 1);
        items1.add(0, 1);
        items2.add(0, 1940);
        for (int i = 1941; i <= 2018; i++) {
            items2.add(i);
        }
        for (int i = 2; i <= 31; i++) {
            items.add(i);
            if (i < 13) {
                items1.add(i);
            }
        }
        arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, items);
        arrayAdapter2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        arrayAdapter3 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        day.setAdapter(arrayAdapter);
        month.setAdapter(arrayAdapter2);
        year.setAdapter(arrayAdapter3);
        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DayMeasure =   (int) parent.getItemAtPosition(position);
                //editor.putString("dayMeas" , String.valueOf(parent.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        month .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MonthMeasure = (int) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                YearMeasure = (int) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}