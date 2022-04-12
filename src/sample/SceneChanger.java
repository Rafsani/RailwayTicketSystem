package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;


public class SceneChanger {

    public void setScene(ActionEvent event, String fxmlFilename, double width, double height )throws IOException{

            Parent stage = FXMLLoader.load(getClass().getResource(fxmlFilename));
            Scene stageScene = new Scene(stage, width, height);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stageScene);
            window.show();

    }

    public void setSceneWithValue(ActionEvent event, String fxmlFilename, double width, double height )throws IOException{
        FXMLLoader kkl = new FXMLLoader(getClass().getResource(fxmlFilename));
        Parent par = (Parent) kkl.load();
        MyAccountController myAccountController = kkl.getController();
        myAccountController.MyNameTxt(Controller.Name, Controller.pass);
        Scene stageScene = new Scene(par,1030,574);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stageScene);
        window.show();
    }

    public void setConfirmationSceneWithValue(ActionEvent event, String fxmlFilename, double width, double height, String Org, String Fee, String Tot)throws IOException{
        FXMLLoader kkl = new FXMLLoader(getClass().getResource(fxmlFilename));
        Parent part = (Parent) kkl.load();
        ConfirmationController confirmationController = kkl.getController();
        confirmationController.Infoset(Org,Fee,Tot);
        Scene stageScene = new Scene(part,1030,574);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stageScene);
        window.show();
    }

    public void setHistoryWithValue(ActionEvent event, String fxmlFilename, double width, double height )throws IOException{
        FXMLLoader kkl = new FXMLLoader(getClass().getResource(fxmlFilename));
        Parent par = (Parent) kkl.load();
        HistoryController historyController = kkl.getController();
        historyController.SetDateTxt(Controller.Day,Controller.Month,Controller.Year,Controller.Name,Controller.pass);
        Scene stageScene = new Scene(par,1030,574);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stageScene);
        window.show();
    }

}
