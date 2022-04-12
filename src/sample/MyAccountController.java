package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class MyAccountController extends MenuController {

    @FXML
    private Label MyNameTxt;

    @FXML
    private Label MyPasswordTxt;


    public void MyNameTxt(String name, String pas){
        MyPasswordTxt.setText(pas);
        MyNameTxt.setText(name);
    }


    @FXML
    void initialize() {
        super.initialize();
        assert MyNameTxt != null : "fx:id=\"MyNameTxt\" was not injected: check your FXML file 'MyAccountPage.fxml'.";
        assert MyPasswordTxt != null : "fx:id=\"MyPasswordTxt\" was not injected: check your FXML file 'MyAccountPage.fxml'.";
    }

}
