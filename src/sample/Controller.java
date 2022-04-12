package sample;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.org.apache.regexp.internal.RE;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private Button LoginButton;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private TextField NameTxt;
    @FXML
    private Label msgTxt;
    public static String Name,pass,Year,Month,Day;


    @FXML
    void loginPress(ActionEvent event) throws IOException
    {

        int i;

        for(i=0; i<ClientReadThread.getList().size(); i++)
        {
            if(ClientReadThread.getList().get(i).getUser_name().equals(NameTxt.getText()) && ClientReadThread.getList().get(i).getPassword().equals(passwordTxt.getText()))
            {
                System.out.println("Login Success");
                break;
            }

        }

        if(i == ClientReadThread.getList().size())
        {
            msgTxt.setText("Either The Password or UserName is Incorrect");
        }
        else {
            Name = ClientReadThread.getList().get(i).getUser_name();
            pass =ClientReadThread.getList().get(i).getPassword();
            Day = ClientReadThread.getList().get(i).getDay();
            Month = ClientReadThread.getList().get(i).getMonth();
            Year = ClientReadThread.getList().get(i).getYear();
            SceneChanger s =new SceneChanger();
            s.setSceneWithValue(event, "MyAccountPage.fxml",1030,574);
        }


        for(User a : ClientReadThread.getList())
        {
            System.out.println(a);
        }
    }



    @FXML
    void signUpPressed(ActionEvent event) throws Exception{
        SceneChanger s =new SceneChanger();
        s.setScene(event, "SignUp.fxml",1030,574);
    }

    @FXML
    void initialize() {
        assert signUpButton != null : "fx:id=\"signUpButton\" was not injected: check your FXML file 'finalLoginPage.fxml'.";
        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'finalLoginPage.fxml'.";
        assert passwordTxt != null : "fx:id=\"passwordTxt\" was not injected: check your FXML file 'finalLoginPage.fxml'.";
        assert NameTxt != null : "fx:id=\"NameTxt\" was not injected: check your FXML file 'finalLoginPage.fxml'.";
    }
}
