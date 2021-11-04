package bank;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Bank extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLDocument.fxml"));
        Scene scene = new Scene(root, 1084, 677);
        stage.setMinWidth(1084.0);
        stage.setMinHeight(677.0);
        stage.setMaxWidth(1084.0);
        stage.setMaxHeight(677.0);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
