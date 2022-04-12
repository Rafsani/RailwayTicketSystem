package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class ReserveFileData implements Serializable
{
    DateClass trainDate;
    int firstClassSeat;
    int SecondClassSeat;
    int ThirdClassSeat;
    String TrainId;

    public DateClass getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(DateClass trainDate) {
        this.trainDate = trainDate;
    }

    public int getFirstClassSeat() {
        return firstClassSeat;
    }

    public void setFirstClassSeat(int firstClassSeat) {
        this.firstClassSeat = firstClassSeat;
    }

    public int getSecondClassSeat() {
        return SecondClassSeat;
    }

    public void setSecondClassSeat(int seconClassSteat) {
        SecondClassSeat = seconClassSteat;
    }

    public int getThirdClassSeat() {
        return ThirdClassSeat;
    }

    public void setThirdClassSeat(int thirdClassSeat) {
        ThirdClassSeat = thirdClassSeat;
    }

    public String getTrainId() {
        return TrainId;
    }

    public void setTrainId(String trainId) {
        TrainId = trainId;
    }

    public ReserveFileData(DateClass trainDate, int firstClassSeat, int secondClassSeat, int thirdClassSeat, String trainId) {
        this.trainDate = trainDate;
        this.firstClassSeat = firstClassSeat;
        SecondClassSeat = secondClassSeat;
        ThirdClassSeat = thirdClassSeat;
        TrainId = trainId;
    }

    public ReserveFileData() {
    }

public String str(){
return this.getTrainDate().toString()+","+this.getFirstClassSeat()+","+this.getSecondClassSeat()+","+this.getThirdClassSeat()+","+this.getTrainId() ;
}

    @Override
    public String toString() {
        return "ReserveFileData{" +
                "trainDate=" + trainDate +
                ", firstClassSeat=" + firstClassSeat +
                ", SeconClassSteat=" + SecondClassSeat +
                ", ThirdClassSeat=" + ThirdClassSeat +
                ", TrainId='" + TrainId + '\'' +
                '}';
    }
}
