package sample;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Train implements Serializable
{
    private String Train_Name;
    private String DepartureStation;
    private String DepartureTime;
    private String DepartureAP;
    private String ArrivalStation;
    private String ArrivalTime;
    private String ArrivalAP;
    int First;
    int Second;
    int Third;
    private String trainID;

    public Train(String train_Name, String departureStation, String departureTime, String departureAP, String arrivalStation, String arrivalTime, String arrivalAP, int seatsFirst, int seatsSecond, int seatsThird, String rating) {
        Train_Name = train_Name;
        DepartureStation = departureStation;
        DepartureTime = departureTime;
        DepartureAP = departureAP;
        ArrivalStation = arrivalStation;
        ArrivalTime = arrivalTime;
        ArrivalAP = arrivalAP;
        First = seatsFirst;
        Second = seatsSecond;
        Third = seatsThird;
        trainID = rating;
    }

    public String getTrain_Name() {
        return Train_Name;
    }

    public void setTrain_Name(String train_Name) {
        Train_Name = train_Name;
    }

    public String getDepartureStation() {
        return DepartureStation;
    }

    public void setDepartureStation(String departureStation) {
        DepartureStation = departureStation;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }

    public String getDepartureAP() {
        return DepartureAP;
    }

    public void setDepartureAP(String departureAP) {
        DepartureAP = departureAP;
    }

    public String getArrivalStation() {
        return ArrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        ArrivalStation = arrivalStation;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getArrivalAP() {
        return ArrivalAP;
    }

    public void setArrivalAP(String arrivalAP) {
        ArrivalAP = arrivalAP;
    }

    public int getSeatsFirst() {
        return First;
    }

    public void setSeatsFirst(int seatsFirst) {
        First = seatsFirst;
    }

    public int getSeatsSecond() {
        return Second;
    }

    public void setSeatsSecond(int seatsSecond) {
        Second = seatsSecond;
    }

    public int getSeatsThird() {
        return Third;
    }

    public void setSeatsThird(int seatsThird) {
        Third = seatsThird;
    }


    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    @Override
    public String toString() {
        return "Train{" +
                "Train_Name='" + Train_Name + '\'' +
                ", DepartureStation='" + DepartureStation + '\'' +
                ", DepartureTime='" + DepartureTime + '\'' +
                ", DepartureAP='" + DepartureAP + '\'' +
                ", ArrivalStation='" + ArrivalStation + '\'' +
                ", ArrivalTime='" + ArrivalTime + '\'' +
                ", ArrivalAP='" + ArrivalAP + '\'' +
                ", First=" + First +
                ", Second=" + Second +
                ", Third=" + Third +
                ", trainID='" + trainID + '\'' +
                '}';
    }
}
