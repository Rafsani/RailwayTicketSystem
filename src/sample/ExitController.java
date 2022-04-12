package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import util.NetworkUtil;


import java.io.IOException;

public class ExitController extends MenuController {

    NetworkUtil nc = new NetworkUtil("127.0.0.1", 33333);


    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;



    @FXML
    void NoPress(ActionEvent event) throws IOException {
        SceneChanger s = new SceneChanger();
        s.setSceneWithValue(event, "MyAccountPage.fxml", 1030, 574);
    }


    @FXML
    void YesPress(ActionEvent event) {
        nc.write("ClearFile");
        /*
        * Writing every user's Data to server and
        * server is instantly rewriting the user data file
        * */
       for(int h = 0; h<ClientReadThread.getList().size(); h++){
           nc.write(ClientReadThread.getList().get(h));
       }
        Stage stage = (Stage)yesButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        super.initialize();
        assert yesButton != null : "fx:id=\"yesButton\" was not injected: check your FXML file 'ExitPage.fxml'.";
        assert noButton != null : "fx:id=\"noButton\" was not injected: check your FXML file 'ExitPage.fxml'.";

    }
}
