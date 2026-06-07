import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    private List<Game> games;

    @Override
    public void start(Stage stage) {

        stage.setTitle("ArcadeTY");

        BorderPane flow = new BorderPane();
        stage.setScene(new Scene(flow, 600, 400));

        Label title = new Label("ArcadeTY");

        for(Game g : games) {

        }

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}