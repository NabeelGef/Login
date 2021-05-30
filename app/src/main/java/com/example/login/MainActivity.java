package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   Button sign,login;
   SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        sharedPreferences = getSharedPreferences("MyData" , Context.MODE_PRIVATE);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 SignUp();
                    }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }
    private void SignUp(){
        Intent intent = new Intent(getApplicationContext(),Sign_Up.class);
        startActivity(intent);
    }
    private void Login(){
        Intent intent = new Intent(getApplicationContext(),Login_in.class);
            startActivity(intent);
        }
    }