package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.security.Key;
import java.util.ArrayList;
import java.util.Map ;
import java.lang.String;
import java.util.Set;
import java.util.Vector;

public class Login_in extends AppCompatActivity {
    SharedPreferences sharedPreferences , logId;
    EditText Name , Password ;
    Button Next;
    int Size ;
    boolean f = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_in);
        Name = findViewById(R.id.nameLog);
        Password = findViewById(R.id.passwordLog);
        Next = findViewById(R.id.nextLog);
        sharedPreferences = getSharedPreferences("Data", Activity.MODE_PRIVATE);
         logId = getSharedPreferences("log", Activity.MODE_PRIVATE);
        Size = sharedPreferences.getInt("size",0);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f =false;
                if(Name.getText().toString().equals("")||Password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please fill the Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    for (int i = 0; i < Size; i++) {
                        if (Name.getText().toString().equals(sharedPreferences.getString("name" + i, "")) &&
                                Password.getText().toString().equals(sharedPreferences.getString("password" + i, ""))) {
                            SharedPreferences.Editor editor = logId.edit();
                            editor.putInt("id", i);
                            editor.apply();
                            f = true;
                            Intent intent = new Intent(getApplicationContext(), Meals.class);
                            startActivity(intent);
                        }
                    }
                    if (!f) {
                        Toast.makeText(getApplicationContext(), "You are not registered ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}