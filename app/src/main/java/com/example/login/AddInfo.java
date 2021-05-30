package com.example.login;

import android.text.Editable;
import android.widget.EditText;

public class AddInfo {
String breakfast , lunch , dinner, snack , dessert ;
AddInfo(String Breakfast , String Lunch , String Dinner , String Snack, String Dessert)
{
    this.breakfast = Breakfast;
    this.lunch = Lunch;
    this.dinner = Dinner;
    this.snack = Snack;
    this .dessert = Dessert;
}
    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public String getSnack() {
        return snack;
    }

    public String getDessert() {
        return dessert;
    }
}
