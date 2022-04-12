package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HistoryController extends MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DayTxt;

    @FXML
    private Label MonthTxt;

    @FXML
    private Label YearTxt;


    public void SetDateTxt(String DAY, String MON, String YR, String Name, String Password){
        //Checking for the user data with user name & password

        for (int i = 0; i < ClientReadThread.getList().size(); i++) {
            if (ClientReadThread.getList().get(i).getUser_name().equals(Name) && ClientReadThread.getList().get(i).getPassword().equals(Password))
            {
                ClientReadThread.getList().get(i).setDay(String.valueOf(QueryController.getTemp().getDay()));
                ClientReadThread.getList().get(i).setMonth(String.valueOf(QueryController.getTemp().getMonth()));
                ClientReadThread.getList().get(i).setYear(String.valueOf(QueryController.getTemp().getYear()));
                System.out.println(ClientReadThread.getList().get(i));
                System.out.println("History Done");
                break;
            }

        }
    }


    @FXML
    void initialize() {
        super.initialize();
        assert DayTxt != null : "fx:id=\"DayTxt\" was not injected: check your FXML file 'HistoryPage.fxml'.";
        assert MonthTxt != null : "fx:id=\"MonthTxt\" was not injected: check your FXML file 'HistoryPage.fxml'.";
        assert YearTxt != null : "fx:id=\"YearTxt\" was not injected: check your FXML file 'HistoryPage.fxml'.";
        DayTxt.setText(String.valueOf(QueryController.getTemp().getDay()));
        MonthTxt.setText(String.valueOf(QueryController.getTemp().getMonth()));
        YearTxt.setText(String.valueOf(QueryController.getTemp().getYear()));
    }
}
