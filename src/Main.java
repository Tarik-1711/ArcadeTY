import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private List<Game> games = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        stage.setTitle("ArcadeTY");

        FlowPane flow = new FlowPane();
        flow.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(flow, 600, 400));

        Label title = new Label("ArcadeTY");
        title.setStyle("-fx-font-size: 32px; -fx-text-alignment: center; -fx-alignment: center;");
        flow.getChildren().add(title);

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