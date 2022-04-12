package sample;

import java.io.Serializable;

public class ConfirmationRequest implements Serializable{
    String SeatClass;
    int seatReq;
    String TrainId;
    DateClass trainDate;

    public ConfirmationRequest(String seatClass, int seatReq, String trainId, DateClass trainDate) {
        SeatClass = seatClass;
        this.seatReq = seatReq;
        TrainId = trainId;
        this.trainDate = trainDate;
    }

    public String getSeatClass() {
        return SeatClass;
    }

    public void setSeatClass(String seatClass) {
        SeatClass = seatClass;
    }

    public int getSeatReq() {
        return seatReq;
    }

    public void setSeatReq(int seatReq) {
        this.seatReq = seatReq;
    }

    public String getTrainId() {
        return TrainId;
    }

    public void setTrainId(String trainId) {
        TrainId = trainId;
    }

    public DateClass getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(DateClass trainDate) {
        this.trainDate = trainDate;
    }

    @Override
    public String toString() {
        return "ConfirmationRequest{" +
                "SeatClass='" + SeatClass + '\'' +
                ", seatReq=" + seatReq +
                ", TrainId='" + TrainId + '\'' +
                ", trainDate=" + trainDate +
                '}';
    }
}
