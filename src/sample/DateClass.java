package sample;

import java.io.Serializable;

public class DateClass implements Serializable
{
    int Year;
    int month;
    int day;

    public DateClass(int year, int month, int day) {
        this.Year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public boolean equalDate(DateClass obj){
        if(this.Year == obj.Year && this.month == obj.month && this.day == obj.day){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return (Year + "-"+ month+"-"+ day);
    }
}
