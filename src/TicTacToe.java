import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private Stage stage = new Stage();

    private Boolean end = false;

    private Boolean vsCom = false;

    public TicTacToe() {
        super("TicTacToe", "/resources/tictactoe.png","Klassisches TicTacToe bei dem man zwischen Computer oder gegen einen Freund lokal spielen kann.");
    }

    @Override
    public void play() {
        start(stage);
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
        createGrid(gd);
        askMode(stage);
        if(vsCom) playComp();
        stage.show();
    }

    private boolean askMode(Stage parent) {
        Stage w = new Stage();
        w.initOwner(parent);

        Button mensch = new Button("Mensch");
        Button computer = new Button("Computer");


        mensch.setOnAction(e -> {
            vsCom = false; w.close();
        });

        computer.setOnAction(e -> {
            vsCom = true; w.close();
        });

        HBox box = new HBox(20, mensch, computer);
        box.setAlignment(Pos.CENTER);
        w.setScene(new Scene(box, 250, 100));
        w.setTitle("Modus wählen");
        w.showAndWait();

        return vsCom;
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
        if(!btn[x][y].getText().isEmpty()) return;
        btn[x][y].setText(current);
        String o = current;
        current = next;
        next= o;
        checkWin();
        if(end) stage.close();
    }

    private void playComp() {
        System.out.println("Computer gestartet");
    }

    private void checkWin(){
            // Reihen
            for (int i = 0; i < 3; i++) {
                if (same(btn[i][0], btn[i][1], btn[i][2])) {
                    System.out.println(next + " hat gewonnen!");
                    end = true;
                }
            }

            // Spalten
            for (int j = 0; j < 3; j++) {
                if (same(btn[0][j], btn[1][j], btn[2][j])) {
                    end = true;
                    System.out.println(next + " hat gewonnen!");
                }
            }

            // Diagonalen
            if (same(btn[0][0], btn[1][1], btn[2][2])) {
                end = true;
                System.out.println(next + " hat gewonnen!");
            }
            if (same(btn[0][2], btn[1][1], btn[2][0])) {
                end = true;
                System.out.println(next + " hat gewonnen!");
            }

            System.out.println("Unentschieden");

    }

    private boolean same(Button a, Button b, Button c) {
        return !a.getText().isEmpty() &&
                a.getText().equals(b.getText()) &&
                b.getText().equals(c.getText());
    }
}