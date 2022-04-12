package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private static final String Filename="User.txt";
   public static Stage ac;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("finalLoginPage.fxml"));
        ac=primaryStage;
        ac.initStyle(StageStyle.UNDECORATED);

        ac.setScene(new Scene(root, 1030, 574));
        ac.show();
    }
    public static void main(String[] args) throws IOException {
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
            new ClientReadThread(nc);
        } catch(Exception e) {
            System.out.println (e);
        }
        launch(args);
    }

}
