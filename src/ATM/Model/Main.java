package ATM.Model;

import ATM.Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/sample.fxml"));
        Pane pane = loader.load();
        Controller controller = loader.getController();

        ATM atm = new ATM();
        controller.setAtm(atm);
        controller.updateMoney();

        Scene scene = new Scene(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ATM");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
