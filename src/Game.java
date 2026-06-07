import javafx.scene.image.Image;

public abstract class Game {
    private String title;
    private Image image;
    private String beschreibung;

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Game(String title, Image image) {
        this.title = title;
        this.image = image;
    }

    public Game(String title) {
        this.title = title;
    }

    public abstract void play();
}
