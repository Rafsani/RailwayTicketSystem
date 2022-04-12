package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpController{

    @FXML
    private Button DoneButton;

    @FXML
    void DonePress(ActionEvent event)throws IOException {
        //Takes You Back to Information Page

        Parent query1 = FXMLLoader.load(getClass().getResource("UserQueryPage.fxml"));
        Scene QueryScene1 = new Scene(query1,1030,574);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(QueryScene1);
        window.show();
    }

    @FXML
    void initialize() {
        assert DoneButton!= null : "fx:id=\"AboutButton\" was not injected: check your FXML file 'HelpPage.fxml'.";
    }

}
