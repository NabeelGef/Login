package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class AddedMeals extends AppCompatActivity {
private ArrayList<AddInfo> create;
private AdapterItem adapter;
private RecyclerView recyclerView;
SharedPreferences LogId , Data ;
int id , SizeMeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_meals);
           recyclerView = findViewById(R.id.recycler);
        LogId = getSharedPreferences("log" , Activity.MODE_PRIVATE);
        Data = getSharedPreferences("Data" , Activity.MODE_PRIVATE);
        id = LogId.getInt("id" , 100);
        SizeMeal = Data.getInt("size_meal"+id,0);
        create = new ArrayList<>();
        for(int i=0;i<SizeMeal;i++)
        {
            create.add(new AddInfo(Data.getString("breakfast" + id + i ,""),
                    Data.getString("lunch" + id + i , "") , Data.getString("dinner" +
                    id + i , ""),Data.getString("snack" +id + i,""),Data.
                    getString("dessert" + id + i , "")));
        }
        adapter = new AdapterItem();
        adapter.setList(create);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
       recyclerView.setAdapter(adapter);
    }
}