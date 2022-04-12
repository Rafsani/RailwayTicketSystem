package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class SettingsController extends MenuController {


    @FXML
    private Button DoneButton;

    @FXML
    private TextField PrevName;

    @FXML
    private TextField PrevPassword;

    @FXML
    private TextField NewName;

    @FXML
    private TextField NewPassword;

    @FXML
    private Label msgTxt;

    @FXML
    void DonePress(ActionEvent event) {

        int i;

        if(PrevName.getText().equals(Controller.Name) && PrevPassword.getText().equals(Controller.pass)) {

            for (i = 0; i < ClientReadThread.getList().size(); i++) {

                if (ClientReadThread.getList().get(i).getUser_name().equals(PrevName.getText()) && ClientReadThread.getList().get(i).getPassword().equals(PrevPassword.getText())) {
                   // Searching the index , username and password for the request
                    ClientReadThread.getList().get(i).setUser_name(NewName.getText());
                    ClientReadThread.getList().get(i).setPassword(NewPassword.getText());
                    Controller.pass = NewPassword.getText();
                    Controller.Name = NewName.getText();
                    System.out.println("Found");
                    msgTxt.setText("Done");
                    break;
                }

            }
        }

        else {
        msgTxt.setText("Invalid Password or UserName");
        }

    }

    @FXML
    void initialize() {
        super.initialize();
        assert DoneButton != null : "fx:id=\"DoneButton\" was not injected: check your FXML file 'Settings.fxml'.";
        assert PrevName != null : "fx:id=\"PrevName\" was not injected: check your FXML file 'SettingsPage.fxml'.";
        assert PrevPassword != null : "fx:id=\"PrevPassword\" was not injected: check your FXML file 'SettingsPage.fxml'.";
        assert NewPassword != null : "fx:id=\"NewPassword\" was not injected: check your FXML file 'SettingsPage.fxml'.";
        assert NewName != null : "fx:id=\"NewName\" was not injected: check your FXML file 'SettingsPage.fxml'.";
        assert msgTxt != null : "fx:id=\"msgTxt\" was not injected: check your FXML file 'SettingsPage.fxml'.";

    }
}

