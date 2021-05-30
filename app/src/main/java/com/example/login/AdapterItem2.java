package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.xml.transform.Templates;

public  class AdapterItem2 extends RecyclerView.Adapter<AdapterItem2.ViewHolder> {
    ArrayList<AddInfoMeasure> addInfoMeasureArrayList = new ArrayList<>();
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.addedMeals);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.add_meals_text,
                parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem2.ViewHolder holder, int position) {
        holder.textView.setText("Before Meals : " + addInfoMeasureArrayList.get(position).getBefore() +
                "\n After Meals : " + addInfoMeasureArrayList.get(position).getAfter()+ "\n Randomly : " +
                addInfoMeasureArrayList.get(position).getRandomly() + "\n Date : \\" +
                addInfoMeasureArrayList.get(position).getDay() + "\\" + addInfoMeasureArrayList.get(position).getMonth() + "\\" +
                addInfoMeasureArrayList.get(position).getYear());
    }
    @Override
    public int getItemCount() {
        return addInfoMeasureArrayList.size();
    }
        public void setList(ArrayList arrayList) {
            addInfoMeasureArrayList = arrayList;
        }


}
