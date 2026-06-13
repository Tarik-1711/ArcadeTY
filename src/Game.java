import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Game {
    private String title;
    private Image image;
    private String beschreibung;
    private Color color;

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public Color getColor() {
        return color;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Game(String title, String imagepath, String beschreibung, Color color) {
        this.title = title;
        this.image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagepath)));
        this.beschreibung = beschreibung;
        this.color = color;
    }

    public Game(String title) {
        this.title = title;
    }

    public abstract void play();
}
