import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private List<Game> games = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        games.add(new TicTacToe());
        games.add(new FlappyBird());
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


    public StackPane gameCard(Game g) {
        Button play = new Button();
        play.setOnAction(e -> g.play());
        play.setPrefSize(100,100);
        play.setOpacity(0);
        StackPane sp = new StackPane();
        if(g.getImage() != null) {
            ImageView b = new ImageView(g.getImage());
            b.setFitHeight(100);
            b.setFitWidth(100);
            b.setPreserveRatio(true);

            Rectangle clip = new Rectangle(
                    b.getFitWidth(),
                    b.getFitHeight()
            );

            clip.setArcWidth(20);
            clip.setArcHeight(20);

            b.setClip(clip);
            sp.getChildren().add(b);
        }

        sp.getChildren().add(play);

        DropShadow sh = new DropShadow();
        sh.setColor(g.getColor());
        sh.setRadius(10);
        sh.setOffsetX(0);
        sh.setOffsetY(10);

        sp.setEffect(sh);
        sp.setOnMouseEntered(e -> sp.setTranslateY(-10));
        sp.setOnMouseExited(e -> sp.setTranslateY(0));
        return sp;

    }
}