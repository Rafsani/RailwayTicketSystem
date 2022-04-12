package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryController {

    @FXML
    private Label ErrorTxt;

    @FXML
    private TextField DepartureTxt;

    @FXML
    private TextField ArrivalTxt;

    @FXML
    private TextField DepartureTimeTxt;

    @FXML
    private TextField DepartureDateTxt;

    @FXML
    private TextField QuantityTxt;
    private static String quantity;

    public static String getQuantity() {
        return quantity;
    }

    @FXML
    private TextField ClassTxt;

    @FXML
    private DatePicker Date;

    @FXML
    private Button SearchButton;

    @FXML
    private Button AboutButton;

    @FXML
    private Button GoBackButton;

    @FXML
    private RadioButton firstClass;

    @FXML
    private ToggleGroup MyClass;

    @FXML
    private RadioButton SecondClass;

    @FXML
    private RadioButton ThirdClass;
    public static String seatClass;

    @FXML
    void SecondClassPressed(ActionEvent event) {
        seatClass = SecondClass.getText();
        System.out.println(seatClass);
    }

    @FXML
    void ThirdClassPressed(ActionEvent event) {
        seatClass = ThirdClass.getText();
        System.out.println(seatClass);
    }

    @FXML
    void firstClassPressed(ActionEvent event) {
        seatClass = firstClass.getText();
        System.out.println(seatClass);
    }

    @FXML
    void AboutPress(ActionEvent event) throws IOException {
        // Takes You to Help Page
        SceneChanger s = new SceneChanger();
        s.setScene(event, "HelpPage.fxml", 1030, 574);
    }

    private static final String Filename1 = "TrainInfo";
    // public static List<Train> trains = new ArrayList();
    public static List<Train> SearchTrains = new ArrayList();

    @FXML
    void SearchPress(ActionEvent event) throws IOException {

        int i;
        quantity =QuantityTxt.getText();
            for (i = 0; i < ClientReadThread.getTrainList().size(); i++) {
                if (ClientReadThread.getTrainList().get(i).getDepartureStation().equalsIgnoreCase(DepartureTxt.getText()) && ClientReadThread.getTrainList().get(i).getArrivalStation().equalsIgnoreCase(ArrivalTxt.getText())) {
                    System.out.println(i);
                    System.out.println("Search Successful");
                    SearchTrains.add(ClientReadThread.getTrainList().get(i));
                }
            }

            //Going to Feedback page
            SceneChanger s = new SceneChanger();
            s.setScene(event, "feedbackPage.fxml", 1030, 574);
            System.out.println(ClientReadThread.getTrainList().size());
        }

    @FXML
    void GoBackPress(ActionEvent event) throws IOException{
        SceneChanger s =new SceneChanger();
        s.setSceneWithValue(event, "MyAccountPage.fxml",1030,574);
    }
    private static LocalDate date;

    public static LocalDate getDate() {
        return date;
    }


    private static DateClass temp = new DateClass(Integer.parseInt(Controller.Year),Integer.parseInt(Controller.Month),Integer.parseInt(Controller.Day));

    public static DateClass getTemp() {
        return temp;
    }

    @FXML
    void DateSelected(ActionEvent event) {
        System.out.println("pressed");
       // Calendar now = Calendar.getInstance();
        System.out.println(Date.getValue().getYear());
        date = Date.getValue();
        // getting date from localDate to dateclass
        temp.setYear(Date.getValue().getYear());
        temp.setMonth(Date.getValue().getMonthValue());
        temp.setDay(Date.getValue().getDayOfMonth());
        System.out.println(temp);
    }

    @FXML
    void initialize() {
        assert DepartureDateTxt != null : "fx:id=\"DepartureDateTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert AboutButton != null : "fx:id=\"AboutButton\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert GoBackButton != null : "fx:id=\"GoBackButton\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert DepartureTxt != null : "fx:id=\"DepartureTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert ArrivalTxt != null : "fx:id=\"ArrivalTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert QuantityTxt != null : "fx:id=\"QuantityTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert DepartureTimeTxt != null : "fx:id=\"DepartureTimeTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert DepartureDateTxt != null : "fx:id=\"DepartureDateTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
        assert ClassTxt != null : "fx:id=\"ClassTxt\" was not injected: check your FXML file 'UserQueryPage.fxml'.";
    }

}