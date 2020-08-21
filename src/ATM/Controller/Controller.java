package ATM.Controller;

import ATM.Model.ATM;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label result;
    @FXML
    private Label result1;
    @FXML
    private Label result2;
    @FXML
    private Label result3;
    @FXML
    private Label result4;
    @FXML
    private Label result5;
    @FXML
    private Label result6;
    @FXML
    private Label money;
    @FXML
    private Label money1;
    @FXML
    private Label money2;
    @FXML
    private Label money3;

    ATM atm;

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

}
