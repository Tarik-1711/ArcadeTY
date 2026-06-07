import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("ArcadeTY");

        BorderPane flow = new BorderPane();
        stage.setScene(new Scene(flow, 600, 400));

        Label title = new Label("ArcadeTY");

        Button flappybird = new Button("FLAPPYBIRD");
        Button tictacto = new Button("TIC TAC TOE");

        flow.setTop(title);
        flow.setCenter(flappybird);
        flow.setCenter(tictacto);
        flow.getChildren().add(flappybird);


        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}