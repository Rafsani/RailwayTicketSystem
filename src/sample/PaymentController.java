package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.IOException;

public class PaymentController extends MenuController {

    @FXML
    private Button bKashButton;

    @FXML
    private Button PaydeliveryButton;

    private int Quantity = Integer.parseInt(QueryController.getQuantity());

    private Train train;

    public void setTrain(Train train) {
        this.train = train;
    }
    static String original, fee, total;

    public static void sendTrainData(){
       // this.train.
    }

    @FXML
    void DeliveryPress(ActionEvent event) throws IOException{
        CancellationController.setInputPage(1);
        //Price Set
        double orgCPrice = Quantity * 150;
        double feeCPrice = 0;
        //double discountedPrice = (Quantity * 150 * 1.5)/100;
        double totalCPrice = orgCPrice + feeCPrice ;
        original = String.valueOf(orgCPrice);
        fee = String.valueOf(feeCPrice);
        total = String.valueOf(totalCPrice);

        SceneChanger s = new SceneChanger();
        s.setConfirmationSceneWithValue(event, "CashOnDeliveryPage.fxml",1030,574,original,fee,total);
    }


    @FXML
    void bKashPress(ActionEvent event)throws IOException {
       CancellationController.setInputPage(0);
        //Price Set
        double orgPrice = Quantity * 150;
        double feePrice = (Quantity * 150 * 10)/100;
        //double discountedPrice = (Quantity * 150 * 1.5)/100;
        double totalPrice = orgPrice + feePrice ;
        original = String.valueOf(orgPrice);
        fee = String.valueOf(feePrice);
        total = String.valueOf(totalPrice);


        SceneChanger s = new SceneChanger();
        s.setConfirmationSceneWithValue(event, "bKashPage.fxml",1030,574,original,fee,total);
    }

    @FXML
    void initialize() {
        super.initialize();
        assert bKashButton != null : "fx:id=\"bKashButton\" was not injected: check your FXML file 'Page.fxml'.";
        assert PaydeliveryButton != null : "fx:id=\"PaydeliveryButton\" was not injected: check your FXML file 'Page.fxml'.";

    }



}
