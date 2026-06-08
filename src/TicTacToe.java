import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToe extends Game{
    private char[][] board= new char[3][3];
    private Button[][] btn= new Button[3][3];
    private Label status= new Label("X ist dran");
    private char current= 'X';

    public TicTacToe(String title, Image image) {
        super(title, image);
    }

    public TicTacToe(String title) {
        super(title);
    }

    @Override
    public void play() {
        start(new Stage());
    }



    public void start(Stage stage){
        BorderPane root= new BorderPane();
        GridPane gd= new GridPane();
        stage.setScene(new Scene(root, 600, 400));
        gd.setAlignment(Pos.CENTER);
        stage.setTitle("TicTacToe");
        Label titleH= new Label("Tic-Tac-Toe");
        titleH.setStyle("-fx-font-size: 32px; -fx-text-alignment: center; -fx-alignment: center;");
        BorderPane.setAlignment(titleH,Pos.CENTER);
        root.setTop(titleH);
        root.setCenter(gd);
        stage.show();
    }
}