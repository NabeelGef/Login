package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Sign_Up extends AppCompatActivity {
   EditText Name , Password , Height , Weight ;
   SharedPreferences sharedPreferences , additional , LogId ;
   int Size , DayBirth , MonthBirth , YearBirth , DayDiab , MonthDiab , YearDiab ;
   Button Next , Clear;
   String Gender ;
   RadioButton Male , Female , Other;
   Spinner day , month , year , dayDiab , monthDiab , yearDiab;
   List<Integer> items , items2 , items3;
   ArrayAdapter<Integer> arrayAdapter , arrayAdapter2 , arrayAdapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        init(); // for initial values with it id >>>
        dateAgeAndDiabetic(); // for put Date in you Age and date in your first have Diabetes>>>
        sharedPreferences = getSharedPreferences("Data", Activity.MODE_PRIVATE);
        additional = getSharedPreferences("ADD", Activity.MODE_PRIVATE);
        LogId = getSharedPreferences("log", Activity.MODE_PRIVATE);
        clickNext(); //when you clicking next button>>>
        clickClear(); // when you clicking clear button>>>
    }
    private  void  init(){
        Name = findViewById(R.id.name);
        Next = findViewById(R.id.next);
        Clear = findViewById(R.id.clear);
        Password = findViewById(R.id.password);
        Height = findViewById(R.id.height);
        Weight = findViewById(R.id.weight);
        day = findViewById(R.id.day);
        dayDiab = findViewById(R.id.dayDiab);
        month = findViewById(R.id.month);
        monthDiab = findViewById(R.id.monthDiab);
        year = findViewById(R.id.year);
        yearDiab = findViewById(R.id.yearDiab);
        Male = findViewById(R.id.male);
        Female = findViewById(R.id.female);
        Other = findViewById(R.id.other);
    }
    private void dateAgeAndDiabetic(){
        items = new ArrayList<>();
        items2 = new ArrayList<>();
        items3 = new ArrayList<>();
        items.add(0,1);
        items2.add(0,1);
        items3.add(0,1940);
        for(int i = 1941 ; i<=2018;i++)
        {
            items3.add(i);
        }
        for(int i=2;i<=31;i++)
        {
            items.add(i);
            if(i<13)
            {
                items2.add(i);
            }
        }
        arrayAdapter = new ArrayAdapter<Integer>(this , android.R.layout.simple_spinner_dropdown_item,items);
        arrayAdapter2 = new ArrayAdapter<Integer>(this , android.R.layout.simple_spinner_dropdown_item,items2);
        arrayAdapter3 = new ArrayAdapter<Integer>(this , android.R.layout.simple_spinner_dropdown_item,items3);
        day.setAdapter(arrayAdapter);
        dayDiab.setAdapter(arrayAdapter);
        month.setAdapter(arrayAdapter2);
        monthDiab.setAdapter(arrayAdapter2);
        year.setAdapter(arrayAdapter3);
        yearDiab.setAdapter(arrayAdapter3);
        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DayBirth = (int) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        dayDiab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DayDiab = (int) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MonthBirth = (int) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        monthDiab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MonthDiab = (int) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                YearBirth = (int) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        yearDiab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                YearDiab = (int) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private  boolean check() {
        for(int i=0 ;i < Size ; i++)
        {
            if(additional.getString("name","").equals(sharedPreferences
                    .getString("name"+i,""))&&additional.getString("password","").
                    equals(sharedPreferences.getString("password"+i,"")))
            {
                SharedPreferences.Editor editor = additional.edit();
                editor.clear();
                editor.apply();
                return false;
            }
        }
        SharedPreferences.Editor editor = additional.edit();
        editor.clear();
        editor.apply();
        return true;
    }
    private  void clickNext(){
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                SharedPreferences.Editor editorAdd =  additional.edit();
                if(Name.getText().toString().equals("")||Password.getText().toString().equals("")||
                        Height.getText().toString().equals("")||Weight.getText().toString().equals("")||
                        (!Male.isChecked()&&!Female.isChecked()&&!Other.isChecked()))
                {
                    Toast.makeText(getApplicationContext(),"Please fill the Fields " , Toast.LENGTH_SHORT).show();
                }
                else if(YearBirth>YearDiab||YearBirth==YearDiab&&MonthBirth>MonthDiab||YearBirth==YearDiab&&
                MonthBirth==MonthDiab&&DayBirth>DayDiab)
                {
                    Toast.makeText(getApplicationContext(),"Error in Date of Daibetic",Toast.LENGTH_SHORT)
                            .show();
                }
                else
                {
                    if (!Name.getText().toString().equals("")&&!Password.getText().toString().equals(""))
                    {
                        editorAdd.putString("name",Name.getText().toString());
                        editorAdd.putString("password",Password.getText().toString());
                        editorAdd.apply();
                    }
                    if(!check()){ // this check() for checking if the user is already registered >>>
                            Toast.makeText(getBaseContext(), "User is already Registered",Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                            Size = sharedPreferences.getInt("size" , 0);
                            if ( Male.isChecked())
                                Gender = "Male";
                            else if (Female.isChecked())
                                Gender = "Female";
                            else if (Other.isChecked())
                                Gender = "Other";
                            editor.putString("name"+ Size,Name.getText().toString());
                            editor.putString("password"+ Size,Password.getText().toString());
                            editor.putString("height"+ Size,Height.getText().toString());
                            editor.putString("weight"+ Size,Weight.getText().toString());
                            editor.putString("dayBirth" + Size , String.valueOf(DayBirth));
                            editor.putString("monthBirth" + Size , String.valueOf(MonthBirth));
                            editor.putString("yearBirth" + Size , String.valueOf(YearBirth));
                            editor.putString("dayDiab" + Size , String.valueOf(DayDiab));
                            editor.putString("monthDiab" + Size , String.valueOf(MonthDiab));
                            editor.putString("yearDiab" + Size , String.valueOf(YearDiab));
                            editor.putString("Gender" + Size ,Gender);
                            Size++;
                            editor.putInt("size",Size);
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext() ,Login_in.class);
                            startActivity(intent);
                        }
                }
            }
        });
    }
    private void clickClear(){
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences .Editor editor = sharedPreferences.edit();
                SharedPreferences .Editor editor1 = additional.edit();
                SharedPreferences .Editor editor2 = LogId.edit();
                editor.clear();
                editor1.clear();
                editor2.clear();
                Size = 0;
                editor.apply();
                editor1.apply();
                editor2.apply();

            }
        });
    }

}