import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private List<Game> games = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        games.add(new TicTacToe());
        stage.setTitle("ArcadeTY");

        BorderPane bord = new BorderPane();

        Label title = new Label("ArcadeTY");
        title.setStyle("-fx-font-size: 32px; -fx-text-alignment: center; -fx-alignment: center;");
        bord.setTop(title);
        FlowPane flow = new FlowPane();
        bord.setCenter(flow);
        flow.setAlignment(Pos.CENTER);
        flow.setHgap(20);
        stage.setScene(new Scene(bord, 600, 400));

        BorderPane.setAlignment(title,Pos.CENTER);

        for(Game g : games) {
            flow.getChildren().add(gameCard(g));
        }

        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


    public VBox gameCard(Game g) {
        Label title = new Label(g.getTitle());
        Button play = new Button("Spielen");
        play.setOnAction(e -> g.play());
        if(g.getImage() != null) {
            ImageView b = new ImageView(String.valueOf(g.getImage()));
            VBox v = new VBox(title, play, b);
            v.setPadding(new Insets(20));
            v.setStyle("-fx-background-color: gray;");
            return v;
        }

        else{
            VBox v = new VBox(title, play);
            v.setPadding(new Insets(20));
            v.setStyle("-fx-background-color: gray;");
            return v;
        }
    }
}