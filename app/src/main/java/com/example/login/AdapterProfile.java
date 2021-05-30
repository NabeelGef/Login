package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProfile extends RecyclerView.Adapter<AdapterProfile.ViewHolder> {
   ArrayList<Add_profile> add_profiles = new ArrayList<>();
    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.addedMeals);
        }
    }
    @NonNull
    @Override
    public AdapterProfile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.add_meals_text,
                parent,false));
    }
    public  void setList( ArrayList  add_profiles)
    {
        this.add_profiles  = add_profiles;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterProfile.ViewHolder holder, int position) {
        int x = 0;
        try{
             x = 2021 - Integer.parseInt(add_profiles.get(position).getYearBirth());
        }catch (Exception e){
            System.out.println("Error is : " + e);
        }
      holder.textView.setText("Name : " + add_profiles.get(position).getName()+"\n Gender is :" + add_profiles.get(position).getGender()
              + "\n Age is : " + x + "\n Date Birth: \\" + add_profiles.get(position).getDayBirth() + "\\" +
              add_profiles.get(position).getMonthBirth() + "\\" + add_profiles.get(position).getYearBirth() +
              "\n Height :" + add_profiles.get(position).getHeight() +"cm" +"\n Weight :" + add_profiles.get(position).getWeight()
              +"KG"+ "\n Diabetes since :\\" + add_profiles.get(position).getDayDiab()+ "\\"
              + add_profiles.get(position).getMonthDiab() + "\\" + add_profiles.get(position).getYearDiab());
       }

    @Override
    public int getItemCount() {
        return add_profiles.size();
    }


}
