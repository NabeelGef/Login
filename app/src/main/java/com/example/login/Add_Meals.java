package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class Add_Meals extends AppCompatActivity {
 SharedPreferences LogId , Data ;
 TextView textView ;
 Button save , SeeAddedMeals;
 int id , Size_Meal;
 CheckBox breakfast , lunch , dinner , snack , dessert ;
 EditText edit_breakfast , edit_lunch , edit_dinner , edit_snack , edit_dessert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__meals);
        textView = findViewById(R.id.Hello2);
        save = findViewById(R.id.save);
        SeeAddedMeals= findViewById(R.id.seeAddMeals);
        LogId = getSharedPreferences("log" , Activity.MODE_PRIVATE);
        Data = getSharedPreferences("Data" , Activity.MODE_PRIVATE);
        id = LogId.getInt("id" , 100);
        textView.setText("Please enter your meals " + Data.getString("name" + id,""));
        breakfast  = findViewById(R.id.breakfast);
        edit_breakfast = findViewById(R.id.edit_breakfast);
        lunch = findViewById(R.id.lunch);
        edit_lunch = findViewById(R.id.edit_lunch);
        dinner = findViewById(R.id.dinner);
        edit_dinner = findViewById(R.id.edit_dinner);
        snack = findViewById(R.id.snack);
        edit_snack = findViewById(R.id.edit_snack);
        dessert = findViewById(R.id.dessert);
        edit_dessert = findViewById(R.id.edit_dessert);
        proccess_enable(); // Enable edit Text when you click cheackBox and save Data
        SeeAddedMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddedMeals.class);
                startActivity(intent);
            }
    });
}
    private void proccess_enable()
    {
        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(breakfast.isChecked())
                {
                    edit_breakfast.setEnabled(true);
                }
                else
                {
                    edit_breakfast.getText().clear();
                    edit_breakfast.setEnabled(false);
                }
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lunch.isChecked())
                {
                    edit_lunch.setEnabled(true);
                }
                else
                {
                    edit_lunch.getText().clear();
                    edit_lunch.setEnabled(false);
                }
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dinner.isChecked())
                {
                    edit_dinner.setEnabled(true);
                }
                else
                {
                    edit_dinner.getText().clear();
                    edit_dinner.setEnabled(false);
                }
            }
        });
        snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(snack.isChecked())
                {
                    edit_snack.setEnabled(true);
                }
                else
                {
                    edit_snack.getText().clear();
                    edit_snack.setEnabled(false);
                }
            }
        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dessert.isChecked())
                {
                    edit_dessert.setEnabled(true);
                }
                else
                {
                    edit_dessert.getText().clear();
                    edit_snack.setEnabled(false);
                }
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor1 = Data .edit();
                Size_Meal = Data.getInt("size_meal"+ id,0);
                if(edit_breakfast.getText().toString().equals(""))
                {
                    editor1.putString("breakfast" + id + Size_Meal  , "NoThing");
                }
                else
                {
                    editor1.putString("breakfast" + id + Size_Meal  , edit_breakfast.getText().toString());

                }
                if(edit_lunch.getText().toString().equals(""))
                {
                    editor1.putString("lunch" + id + Size_Meal,"NoThing");
                }
                else
                {
                    editor1.putString("lunch" + id + Size_Meal,edit_lunch.getText().toString());
                }
                if(edit_dinner.getText().toString().equals(""))
                {
                    editor1.putString("dinner" + id + Size_Meal,"NoThing");
                }
                else
                {
                    editor1.putString("dinner" + id + Size_Meal,edit_dinner.getText().toString());
                }
                if(edit_snack.getText().toString().equals(""))
                {
                    editor1.putString("snack" + id + Size_Meal, "No Thing");
                }
                else
                {
                    editor1.putString("snack" + id + Size_Meal, edit_snack.getText().toString());
                }
                if(edit_dessert.getText().toString().equals(""))
                {
                    editor1.putString("dessert" + id +Size_Meal,"No Thing");
                }
                else
                {
                    editor1.putString("dessert" + id +Size_Meal,edit_dessert.getText().toString());
                }
                Size_Meal++;
                editor1.putInt("size_meal" + id,Size_Meal);
                editor1.apply();
            }
        });
    }
}