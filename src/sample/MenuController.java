package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;

public class MenuController {

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
    void AboutPress(ActionEvent event) throws IOException  {
        SceneChanger s =new SceneChanger();
        s.setScene(event, "AboutPage.fxml",1030,574);
    }

    @FXML
    void BookingPress(ActionEvent event) throws IOException {
        SceneChanger s =new SceneChanger();
        s.setScene(event, "UserQueryPage.fxml",1030,574);

    }

    @FXML
    void ExitPress(ActionEvent event)throws IOException {
        SceneChanger s = new SceneChanger();
        s.setScene(event, "ExitPage.fxml", 1030, 574);

    }

    @FXML
    void HistoryPress(ActionEvent event) throws IOException{
        SceneChanger s = new SceneChanger();
        s.setHistoryWithValue(event,"HistoryPage.fxml",1030,574);
    }

    @FXML
    void SettingsPress(ActionEvent event) throws IOException {
        SceneChanger s =new SceneChanger();
        s.setScene(event, "Settings.fxml",1030,574);

    }

    @FXML
    void initialize() {
        assert BookingButton != null : "fx:id=\"BookingButton\" was not injected: check your FXML file 'Page.fxml'.";
        assert HistoryButton != null : "fx:id=\"HistoryButton\" was not injected: check your FXML file 'Page.fxml'.";
        assert AboutButton != null : "fx:id=\"AboutButton\" was not injected: check your FXML file 'Page.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'Page.fxml'.";
        assert SettingsButton != null : "fx:id=\"SettingsButton\" was not injected: check your FXML file 'Page.fxml'.";

    }

}


