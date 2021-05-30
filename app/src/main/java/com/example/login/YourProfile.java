package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.ArrayList;

public class YourProfile extends AppCompatActivity {
private  ArrayList<Add_profile> add_profiles;
private  AdapterProfile adapterProfile;
private RecyclerView recyclerView;
SharedPreferences LogId , Data ;
int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profile);
        Data = getSharedPreferences("Data" , Activity.MODE_PRIVATE);
        LogId = getSharedPreferences("log" , Activity.MODE_PRIVATE);
        recyclerView = findViewById(R.id.recycle_profile);
        id = LogId.getInt("id" , 100);
        add_profiles = new ArrayList<>();
        add_profiles.add(new Add_profile(Data.getString("name" + id, ""),
                Data.getString("height" +id, ""),Data.getString("weight"+id,""),
                Data.getString("dayBirth"+ id,""),Data.getString("monthBirth"+ id,""),
                Data.getString("yearBirth"+id,""),Data.getString("dayDiab"+ id,""),
                Data.getString("monthDiab"+ id,""),Data.getString("yearDiab"+ id,""),
                Data.getString("Gender" + id ,"")));
        adapterProfile = new AdapterProfile();
        adapterProfile.setList(add_profiles);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterProfile);
    }
}