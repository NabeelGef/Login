package com.example.login;

public class Add_profile {
    String Name , Height , Weight , DayBirth , MonthBirth , YearBirth , DayDiab , MonthDiab ,
    YearDiab , Gender;

    public Add_profile(String name, String height, String weight, String dayBirth,
                       String monthBirth, String yearBirth, String dayDiab, String monthDiab,
                       String yearDiab , String gender) {
        Name = name;
        Height = height;
        Weight = weight;
        DayBirth = dayBirth;
        MonthBirth = monthBirth;
        YearBirth = yearBirth;
        DayDiab = dayDiab;
        MonthDiab = monthDiab;
        YearDiab = yearDiab;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }

    public String getDayBirth() {
        return DayBirth;
    }

    public String getMonthBirth() {
        return MonthBirth;
    }

    public String getYearBirth() {
        return YearBirth;
    }

    public String getDayDiab() {
        return DayDiab;
    }

    public String getMonthDiab() {
        return MonthDiab;
    }

    public String getYearDiab() {
        return YearDiab;
    }
    public String getGender() {
        return Gender;
    }
}
