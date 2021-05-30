package com.example.login;

public class AddInfoMeasure {
    String Before ,After ,Randomly , day ,month ,year ;
    AddInfoMeasure(String b , String a , String r, String d , String m , String y)
    {
        this.Before = b ;
        this.After = a;
        this.Randomly = r;
        this.day = d;
        this.month = m;
        this .year = y;
    }

    public String getBefore() {
        return Before;
    }

    public String getAfter() {
        return After;
    }

    public String getRandomly() {
        return Randomly;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
