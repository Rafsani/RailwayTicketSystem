package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;
import util.NetworkUtil;


public class SignUpController {

    @FXML
    private AnchorPane signUpPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newAccount;

    @FXML
    private PasswordField userRegPass;

    @FXML
    private TextField userRegName;

    NetworkUtil nc = new NetworkUtil("127.0.0.1",33333);
    @FXML
    void NewAccountSelected(ActionEvent event) throws IOException    //After Sign Up goes back to LogIn page
    {
        for(User k:ClientReadThread.getList()){
            System.out.println(k);
        }
        ClientReadThread.getList().add(new User(userRegName.getText(),userRegPass.getText(),"00","00","00"));
        //User user = new User(userRegName.getText(),userRegPass.getText(),"00","00","00");
        //nc.write(user);

        // Goes Back to LogIn Page

        SceneChanger s =new SceneChanger();
        s.setScene(event, "finalLoginPage.fxml",1030,574);
    }

    @FXML
    void UserRegName(ActionEvent event) {

    }

    @FXML
    void UserRegPass(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert newAccount != null : "fx:id=\"newAccount\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert userRegPass != null : "fx:id=\"userRegPass\" was not injected: check your FXML file 'SignUp.fxml'.";
        assert userRegName != null : "fx:id=\"userRegName\" was not injected: check your FXML file 'SignUp.fxml'.";
    }
}
