import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Game {
    private String title;
    private Image image;
    private String beschreibung;
    private static int index = 0;

    Color[] colors = new Color[] {
            Color.STEELBLUE,
            Color.SEAGREEN,
            Color.ORANGE,
            Color.CRIMSON,
            Color.MEDIUMPURPLE,
            Color.DARKORANGE,
            Color.FORESTGREEN,
            Color.DARKRED,
            Color.ORCHID,
            Color.SANDYBROWN,
            Color.DARKVIOLET,
            Color.LIGHTGRAY,
            Color.DIMGRAY,
            Color.BLACK
    };

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public Color getColor() {
        return colors[index];
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Game(String title, String imagepath, String beschreibung) {
        index++;
        this.title = title;
        this.image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagepath)));
        this.beschreibung = beschreibung;
    }

    public Game(String title) {
        this.title = title;
    }

    public abstract void play();
}
