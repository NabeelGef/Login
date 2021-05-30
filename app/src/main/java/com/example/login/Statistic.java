package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class Statistic extends AppCompatActivity {
ArrayList <AddInfoMeasure> addInfoMeasureArrayList;
private AdapterItem2 adapterItem2;
private RecyclerView recyclerView;
    SharedPreferences LogId , Data , DateMeas;
    int id , SizeMeasure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        recyclerView = findViewById(R.id.statstic);
        LogId = getSharedPreferences("log" , Activity.MODE_PRIVATE);
        Data = getSharedPreferences("Data" , Activity.MODE_PRIVATE);
        DateMeas = getSharedPreferences("DateMeasure" , Activity.MODE_PRIVATE);
        id = LogId.getInt("id" , 100);
        SizeMeasure = Data.getInt("Measure"+id,0);
        addInfoMeasureArrayList = new ArrayList<>();
        for (int i=0 ;i < SizeMeasure ;i++)
        {
            addInfoMeasureArrayList.add(new AddInfoMeasure(Data.getString("Before" + id +i,""),
                    Data.getString("After"+id +i,""),Data.getString("Random"+id +i,""),
                    DateMeas.getString("DayMeas"+id+i,""),DateMeas.getString("MonthMeas"+id+i,""),
                    DateMeas.getString("YearMeas"+id+i,"")));
        }
        adapterItem2 = new AdapterItem2();
        adapterItem2.setList(addInfoMeasureArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterItem2);
    }
}