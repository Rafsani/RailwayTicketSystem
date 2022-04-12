package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.NetworkUtil;

import javax.swing.*;

import static sample.QueryController.SearchTrains;

public class FeedBackController {
   NetworkUtil nc = new NetworkUtil("127.0.0.1",33333);

   @FXML
   private Button goBack;

   @FXML
   private Button select;
   @FXML
   private Label ResultCounterTxt;

   @FXML
   private TableView<Train> trainTableView;

   @FXML
   private TableColumn<Train, String> trainNameColumn = new TableColumn<>("TrainName");


   @FXML
   private TableColumn<Train, String> departureTxtColumn;

   @FXML
   private TableColumn<Train, String > arrivalTxtColumn;

   @FXML
   private TableColumn<Train,String > timeTxtColumn;

   @FXML
   private Label validSeat;

   @FXML
   private TableColumn<Train, String > ratingTxtColumn;
   private static Train t;

   public static Train getT() {
      return t;
   }

   @FXML
   void goBackpressed(ActionEvent event) throws Exception
   {
      SceneChanger s = new SceneChanger();
      s.setScene(event,"UserQueryPage.fxml",1030,574);
      SearchTrains.removeAll(ClientReadThread.getTrainList());
     // trains.removeAll(trains);
   }

 //  private TableView<Train> taview = trainTableView;
   private static String id;

   public static String getId() {
      return id;
   }
   private static String Departuretime;
   public static String getDeparturetime(){
      return Departuretime;
   }

   @FXML
   void selectTrainPressed(ActionEvent event)throws IOException {
      Train train = trainTableView.getSelectionModel().getSelectedItem();
      if (train != null) {
         t = train;
         TrainRequest req = new TrainRequest();
         req.setDate(QueryController.getTemp());
         req.setRequiredSeat(Integer.parseInt(QueryController.getQuantity()));
         req.setSeatClass(QueryController.seatClass);
         req.setTrainID(t.getTrainID());
         id = t.getTrainID();
         Departuretime = t.getDepartureTime();
         nc.write(req);
         while (true) {
            Object o = nc.read();
            if (o instanceof String) {
               String obj = (String) o;
               System.out.println(obj);
               if (obj.equals("SeatAvailable")) {
                  SceneChanger s = new SceneChanger();
                  s.setScene(event, "PaymentPage.fxml", 1030, 574);
                  System.out.println(train);
               } else if (obj.equals("NoSeatAvailable")) {
                  validSeat.setText("No Seat in This Train");
               }
               System.out.println("hoise");
               break;
            }
         }
      }
      else{
         validSeat.setText("Please Select a Train");
      }
   }


   @FXML
   void initialize() {
      assert ResultCounterTxt != null : "fx:id=\"ResultCounterTxt\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert trainTableView != null : "fx:id=\"trainTableView\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert trainNameColumn != null : "fx:id=\"trainNameColumn\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert departureTxtColumn != null : "fx:id=\"departureTxtColumn\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert arrivalTxtColumn != null : "fx:id=\"arrivalTxtColumn\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert timeTxtColumn != null : "fx:id=\"timeTxtColumn\" was not injected: check your FXML file 'feedbackPage.fxml'.";
      assert ratingTxtColumn != null : "fx:id=\"ratingTxtColumn\" was not injected: check your FXML file 'feedbackPage.fxml'.";

      assert validSeat != null : "fx:id=\"validSeat\" was not injected: check your FXML file 'feedbackPage.fxml'.";

      trainNameColumn.setCellValueFactory(new PropertyValueFactory<> ("Train_Name"));
      departureTxtColumn.setCellValueFactory(new PropertyValueFactory<> ("DepartureStation"));
      arrivalTxtColumn.setCellValueFactory(new PropertyValueFactory<> ("ArrivalStation"));
      timeTxtColumn.setCellValueFactory(new PropertyValueFactory<> ("ArrivalTime"));
      ratingTxtColumn.setCellValueFactory(new PropertyValueFactory<> ("trainID"));
      ObservableList<Train> os = FXCollections.observableArrayList(SearchTrains);
      trainTableView.setItems(os);
      ResultCounterTxt.setText(String.valueOf(SearchTrains.size()));
   }
}
