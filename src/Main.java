import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    private List<Game> games;

    @Override
    public void start(Stage stage) {

        stage.setTitle("ArcadeTY");

        FlowPane flow = new FlowPane();
        stage.setScene(new Scene(flow, 600, 400));

        Label title = new Label("ArcadeTY");

        for(Game g : games) {
            flow.getChildren().add(gameCard(g));
        }

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


    public VBox gameCard(Game g) {
        ImageView b = new ImageView(String.valueOf(g.getImage()));
        Label title = new Label(g.getTitle());
        Button play = new Button("Spielen");
        play.setOnAction(e -> g.play());
        return new VBox(b, title, play);
    }
}