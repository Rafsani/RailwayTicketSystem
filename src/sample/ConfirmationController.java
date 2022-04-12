package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import util.NetworkUtil;

import java.io.IOException;

public class ConfirmationController extends MenuController {
    private NetworkUtil nc = new NetworkUtil("127.0.0.1",33333);
    @FXML
    private Button CancelButton;

    @FXML
    private Button ConfirmButton;
    @FXML
    private  Label OriginalPrice;

    @FXML
    private Label FeePrice;

    @FXML
    private Label TotalPrice;

    @FXML
    private Label DiscountPrice;

    public void Infoset(String org, String fee, String tot ){
        OriginalPrice.setText(org);
        FeePrice.setText(fee);
        TotalPrice.setText(tot);
        //System.out.println(org+","+fee+","+discount+","+tot);
    }
    private static String seatNo;

    public static String getSeatNo() {
        return seatNo;
    }

    @FXML
    void CancelPress(ActionEvent event)throws IOException {

        SceneChanger s = new SceneChanger();
        s.setScene(event,"CancelBooking.fxml",1030,574);
    }

    @FXML
    void ConfirmPress(ActionEvent event) throws  Exception
    {
        ConfirmationRequest req = new ConfirmationRequest(QueryController.seatClass,Integer.parseInt(QueryController.getQuantity()),FeedBackController.getId(),QueryController.getTemp());
        nc.write("ConfirmSeat");
        nc.write(req);
        while (true){
          Object obj = nc.read();
          if(obj instanceof  String){
              String t =( String ) obj;
              seatNo = t;
              break;
          }
        }
        SceneChanger s = new SceneChanger();
        s.setScene(event, "TicketPage.fxml", 1030, 574);
    }

    @FXML
    void initialize() {
        super.initialize();
        assert ConfirmButton != null : "fx:id=\"ConfirmButton\" was not injected: check your FXML file 'bKashPage.fxml'.";
        assert CancelButton != null : "fx:id=\"CancelButton\" was not injected: check your FXML file 'bKashPage.fxml'.";
        assert TotalPrice != null : "fx:id=\"TotalPrice\" was not injected: check your FXML file 'bKashPage.fxml'.";
        assert OriginalPrice != null : "fx:id=\"OriginalPrice\" was not injected: check your FXML file 'bKashPage.fxml'.";
        assert FeePrice != null : "fx:id=\"FeePrice\" was not injected: check your FXML file 'bKashPage.fxml'.";
        assert DiscountPrice != null : "fx:id=\"DiscountPrice\" was not injected: check your FXML file 'bKashPage.fxml'.";
    }

}
