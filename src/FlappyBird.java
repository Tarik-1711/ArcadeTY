import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlappyBird extends Game{
    private Rectangle player;

    public FlappyBird() {
        super("FlapppyBird", "/resources/flappybird.png", "flappybird", Color.SEAGREEN);
    }

    @Override
    public void play() {
        System.out.println("FlappyBird");
    }

}
