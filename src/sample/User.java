package sample;

import java.io.Serializable;

public class User implements Serializable {
    private String User_name;
    private String Password;
    private String day;
    private String month;
    private String year;

    public User(String N, String P,String D, String M, String Y){
        User_name = N;
        Password = P;
        day = D;
        month = M;
        year = Y;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String str(){
        String s;
        s = User_name + "," + Password+ "," +day+ "," +month+ "," +year;
        return s;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_name='" + User_name + '\'' +
                ", Password='" + Password + '\'' +
                ", Day='" + day+ '\'' +
                ", Month='" + month + '\'' +
                ", Year='" + year + '\'' +
                '}';
    }
}
