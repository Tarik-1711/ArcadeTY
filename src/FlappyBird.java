import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FlappyBird extends Game{
    private Rectangle player;
    private Stage stage = new Stage();
    Button jump = new Button("Jump");
    Boolean jumped = false;

    public FlappyBird() {
        super("FlapppyBird", "/resources/flappybird.png", "flappybird", Color.SEAGREEN);
    }

    @Override
    public void play() {
        System.out.println("FlappyBird");
        Pane p = new Pane();
        stage.setScene(new Scene(p, 600, 400));
        stage.setTitle("FlappyBird wow");

        createPlayer();
        p.getChildren().add(player);

        jump.setOnAction(e -> {
            player.setLayoutY(player.getLayoutY() - 60);
            jumped = true;
        });

        p.getChildren().add(jump);

        stage.show();

        gameLoop();
    }

    public void createPlayer(){
        player = new Rectangle();
        player.setArcHeight(20);
        player.setArcWidth(20);

        player.setHeight(50);
        player.setWidth(80);

        player.setFill(Color.YELLOW);
    }

    public void gameLoop() {
        AnimationTimer loop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                updatePlayer();
            }
        };
        loop.start();
    }

    public void updatePlayer() {
        player.setLayoutY(player.getLayoutY()+1);
    }



}
