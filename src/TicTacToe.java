import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TicTacToe extends Game{
    private Button[][] btn= new Button[3][3];
    private Label status= new Label("X ist dran");
    private String current= "X";
    private String next = "O";

    public TicTacToe() {
        super("TicTacToe");
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

        askMode(stage);

        GridPane gd= new GridPane();
        stage.setScene(new Scene(root, 600, 400));
        gd.setAlignment(Pos.CENTER);
        stage.setTitle("TicTacToe");
        Label titleH= new Label("Tic-Tac-Toe");
        titleH.setStyle("-fx-font-size: 32px; -fx-text-alignment: center; -fx-alignment: center;");
        BorderPane.setAlignment(titleH,Pos.CENTER);
        root.setTop(titleH);
        root.setCenter(gd);
        createGrid(gd);
        stage.show();
    }

    private boolean askMode(Stage parent) {
        Stage w = new Stage();
        w.initOwner(parent);

        Button mensch = new Button("Mensch");
        Button computer = new Button("Computer");

        final boolean[] vsComputer = {false};

        mensch.setOnAction(e -> {
            vsComputer[0] = false; w.close();
        });

        computer.setOnAction(e -> {
            vsComputer[0] = true; w.close();
        });

        HBox box = new HBox(20, mensch, computer);
        box.setAlignment(Pos.CENTER);
        w.setScene(new Scene(box, 250, 100));
        w.setTitle("Modus wählen");
        w.showAndWait();

        return vsComputer[0];
    }


    private void createGrid(GridPane gd){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x =i, y = j;
                btn[i][j] = new Button();
                btn[i][j].setPrefSize(100, 100);
                btn[i][j].setOnAction(e -> changeValue(x,y));
                gd.add(btn[i][j], j, i);
            }
        }
    }

    private void changeValue(int x, int y){
        btn[x][y].setText(current);
        String o = current;
        current = next;
        next= o;
    }
}