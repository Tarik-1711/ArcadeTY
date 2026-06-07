import javafx.scene.image.Image;

public abstract class Game {
    public String title;
    public Image image;
    public String beschreibung;

    public Game(String title, Image image) {
        this.title = title;
        this.image = image;
    }

    public Game(String title) {
        this.title = title;
    }

    public abstract void play();
}
