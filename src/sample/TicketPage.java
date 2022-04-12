package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static sample.QueryController.SearchTrains;

public class TicketPage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BookingButton;

    @FXML
    private Button HistoryButton;

    @FXML
    private Button AboutButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button SettingsButton;

    @FXML
    private Button OkButton;
    @FXML
    private Label date;

    @FXML
    private Label seatNo;

    @FXML
    private Label time;

    @FXML
    private Label seatClass;


    @FXML
    void AboutPress(ActionEvent event) {

    }

    @FXML
    void BookingPress(ActionEvent event) {

    }

    @FXML
    void ExitPress(ActionEvent event) {

    }

    @FXML
    void HistoryPress(ActionEvent event) {

    }

    @FXML
    void OkPressed(ActionEvent event) {
        SceneChanger s = new SceneChanger();
        try {
            s.setSceneWithValue(event,"MyAccountPage.fxml",1030.0,574);
            SearchTrains.removeAll(SearchTrains);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void SettingsPress(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BookingButton != null : "fx:id=\"BookingButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        assert HistoryButton != null : "fx:id=\"HistoryButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        assert AboutButton != null : "fx:id=\"AboutButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        assert SettingsButton != null : "fx:id=\"SettingsButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        assert OkButton != null : "fx:id=\"OkButton\" was not injected: check your FXML file 'TicketPage.fxml'.";
        date.setText(QueryController.getDate().toString());
        seatClass.setText(QueryController.seatClass);
        time.setText(FeedBackController.getDeparturetime());
        seatNo.setText(ConfirmationController.getSeatNo());
    }
}
