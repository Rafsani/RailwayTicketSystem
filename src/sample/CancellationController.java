package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CancellationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NoButton;

    @FXML
    private Button YesButton;
    private static int inputPage;

    public static void setInputPage(int inputPage) {
        CancellationController.inputPage = inputPage;
    }

    @FXML
    void NoPress(ActionEvent event) throws IOException{
        SceneChanger s = new SceneChanger();
        if(inputPage == 0){
            s.setConfirmationSceneWithValue(event,"bKashPage.fxml",1030,574, PaymentController.original,PaymentController.fee,PaymentController.total);
        }
        else
            s.setConfirmationSceneWithValue(event,"CashOnDeliveryPage.fxml",1030,574, PaymentController.original,PaymentController.fee,PaymentController.total);
    }

    @FXML
    void YesPress(ActionEvent event)throws IOException {
        //ClientReadThread.getTrainList().removeAll(ClientReadThread.getTrainList());
        QueryController.SearchTrains.removeAll(QueryController.SearchTrains);
        SceneChanger s = new SceneChanger();
        s.setScene(event, "UserQueryPage.fxml",1030,574);
    }

    @FXML
    void initialize() {
        assert NoButton != null : "fx:id=\"NoButton\" was not injected: check your FXML file 'CancelBooking.fxml'.";
        assert YesButton != null : "fx:id=\"YesButton\" was not injected: check your FXML file 'CancelBooking.fxml'.";

    }
}

