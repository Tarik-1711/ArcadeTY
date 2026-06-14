import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class FlappyBird extends Game implements Runnable{
    private final int gravity = 2;
    private final int jumpheight = 3;

    private int frames = 0;

    private Rectangle player;
    private Stage stage = new Stage();
    private Pane p = new Pane();
    private Button jump = new Button("Jump");

    private Thread gameThread;

    public FlappyBird() {
        super("FlapppyBird", "/resources/flappybird.png", "flappybird", Color.SEAGREEN);
    }

    @Override
    public void play() {
        System.out.println("FlappyBird");
        stage.setScene(new Scene(p, 600, 400));
        stage.setTitle("FlappyBird wow");
        stage.setOnCloseRequest(e -> {
            gameThread = null;
        });
        stage.setResizable(false);

        createPlayer();
        p.getChildren().add(player);

        jump.setOnAction(e -> {
            player.setLayoutY(player.getLayoutY() - 60);
        });

        jump.setPrefSize(200, 200);
        jump.setLayoutY(250);
        jump.setLayoutX(350);

        p.getChildren().add(jump);

        stage.show();

        startGameThread();

    }

    private void createPlayer(){
        player = new Rectangle();
        player.setArcHeight(20);
        player.setArcWidth(20);

        player.setHeight(40);
        player.setWidth(40);

        player.setFill(Color.YELLOW);
    }

    private void playerMovement() {
        player.setLayoutY(player.getLayoutY()-jumpheight);

        player.setRotate(45);
    }

    private void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        while(gameThread !=null) {
            Platform.runLater(() -> {
                frames++;
                if(frames%200==0){
                    generatePipes(p);
                }

                updatePipes();

                if (jump.isPressed()) playerMovement();
                else {
                    player.setLayoutY(player.getLayoutY() + gravity);
                    player.setRotate(-45);
                }
            });
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void generatePipes(Pane p){
        int gap = 150;
        int center = 100 + (int)(Math.random() * 200);

        Rectangle top = new Rectangle();
        top.setWidth(60);
        top.setHeight(center - gap/2);
        top.setLayoutX(600);
        top.setFill(Color.GREEN);

        Rectangle bottom = new Rectangle();
        bottom.setWidth(60);
        bottom.setHeight(400 - (center + gap/2));
        bottom.setLayoutX(600);
        bottom.setLayoutY(center + gap/2);
        bottom.setFill(Color.GREEN);

        p.getChildren().addAll(top,bottom);
    }

    private void updatePipes(){
        for(var node : p.getChildren()) {
            if(node instanceof Rectangle r && r != player) {
                r.setLayoutX(r.getLayoutX()-1);
            }
        }
    }
}
