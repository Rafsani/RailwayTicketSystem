package sample;


import java.io.Serializable;

public class TrainRequest implements Serializable
{
    DateClass date ;
    String SeatClass;
    int requiredSeat;
    String trainID;

    public DateClass getDate() {
        return date;
    }

    public void setDate(DateClass date) {
        this.date = date;
    }

    public String getSeatClass() {
        return SeatClass;
    }

    public void setSeatClass(String seatClass) {
        SeatClass = seatClass;
    }

    public int getRequiredSeat() {
        return requiredSeat;
    }

    public void setRequiredSeat(int requiredSeat) {
        this.requiredSeat = requiredSeat;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    @Override
    public String toString() {
        return "TrainRequest{" +
                "date=" + date +
                ", SeatClass='" + SeatClass + '\'' +
                ", requiredSeat=" + requiredSeat +
                ", trainID='" + trainID + '\'' +
                '}';
    }
}
