package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.util.ArrayList;
import java.util.List;

public class AdapterItem extends RecyclerView.Adapter <AdapterItem.ViewHolder> {
    private ArrayList<AddInfo> arrayList = new ArrayList<>();
    public static class ViewHolder extends RecyclerView.ViewHolder {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      holder.textView.setText("Your breakfast: " + arrayList.get(position).getBreakfast() +
              "\n Your lunch: " + arrayList.get(position).getLunch() + "\n Your dinner: " +
              arrayList.get(position).getDinner() + "\n Your snack: " + arrayList.get(position)
      .getSnack() + " \n Your dessert: " + arrayList.get(position).getDessert() +
              " \n _________________________" );
    }
    public void setList(ArrayList <AddInfo> addInfos)
    {
        this.arrayList = addInfos;
        System.out.println("Hello Im Here");
        //notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
