package ATM.Controller;

import ATM.Model.ATM;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {
    @FXML
    private TextField withdrawMoney;
    @FXML
    private TextField withdrawMoney1;
    @FXML
    private TextField withdrawMoney2;
    @FXML
    private TextField withdrawMoney3;
    @FXML
    private TextField withdrawMoney4;
    @FXML
    private TextField withdrawMoney5;
    @FXML
    private TextField withdrawMoney6;
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
    Timeline withdrawals;
    Background green = new Background(new BackgroundFill(Color.rgb(0, 255, 0, 0.4), new CornerRadii(0), new Insets(0)));
    Background red = new Background(new BackgroundFill(Color.rgb(255, 0, 0, 0.4), new CornerRadii(0), new Insets(0)));
    Background grey = new Background(new BackgroundFill(Color.rgb(192, 192,  192, 0.4), new CornerRadii(0), new Insets(0)));

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public void updateMoney(){
        int[] mon = atm.getMoney();
        money.setText(Integer.toString(mon[0]));
        money1.setText(Integer.toString(mon[1]));
        money2.setText(Integer.toString(mon[2]));
        money3.setText(Integer.toString(mon[3]));
    }

    private void progress(Label label, int withdrawal) {
        updateMoney();
        String[] s = new String[]{"3", "2", "1", ""};
        withdrawals = new Timeline(new KeyFrame(Duration.millis(333), new EventHandler<>() {
            private int i = 0;
            @Override
            public void handle(ActionEvent event) {
                label.setText(s[i]);
                if (i == 3 && s[i].equals(Boolean.toString(true))) {
                    label.setBackground(green);
                } else if (i == 3 && s[i].equals(Boolean.toString(false))) {
                    label.setBackground(red);
                } else {
                    label.setBackground(grey);
                }
                i++;
            }
        }));

        try {
            withdrawals.setCycleCount(s.length);
            s[3] = Boolean.toString(atm.withdraw(withdrawal));
            withdrawals.play();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start(){
        if (!result.getText().equals("")){
            if (withdrawals.getStatus() == Animation.Status.RUNNING){
                withdrawals.stop();
            }
            atm = new ATM();
            Label[] labels = new Label[]{result, result1, result2, result3, result4, result5, result6};
            for (Label l:labels) {
                l.setText("");
                l.setBackground(Background.EMPTY);
            }

        }
        progress(result, Integer.parseInt(withdrawMoney.getText()));
        withdrawals.setOnFinished(actionEvent1 -> {
            progress(result1, Integer.parseInt(withdrawMoney1.getText()));
            withdrawals.setOnFinished(actionEvent2 -> {
                progress(result2, Integer.parseInt(withdrawMoney2.getText()));
                withdrawals.setOnFinished(actionEvent3 -> {
                    progress(result3, Integer.parseInt(withdrawMoney3.getText()));
                    withdrawals.setOnFinished(actionEvent4 -> {
                        progress(result4, Integer.parseInt(withdrawMoney4.getText()));
                        withdrawals.setOnFinished(actionEvent5 -> {
                            progress(result5, Integer.parseInt(withdrawMoney5.getText()));
                            withdrawals.setOnFinished(actionEvent6 -> progress(result6, Integer.parseInt(withdrawMoney6.getText())));
                        });
                    });
                });
            });
        });
    }
}
