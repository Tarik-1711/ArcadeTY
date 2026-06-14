import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TicTacToe extends Game{
    private Button[][] btn= new Button[3][3];
    private String current= "X";
    private String next = "O";

    private Stage stage = new Stage();
    private Boolean end = false;
    private Boolean vsComputer = false;

    public TicTacToe() {
        super("TicTacToe", "/resources/tictactoe.png","Klassisches TicTacToe bei dem man zwischen Computer oder gegen einen Freund lokal spielen kann.", Color.STEELBLUE);
    }

    @Override
    public void play() {
        start(stage);
    }

    /**
     * Erstellt die Stage/Scene.
     * Fügt einen Titel "Tic-Tac-Toe" hinzu.
     * @param stage
     */
    public void start(Stage stage){

        BorderPane root= new BorderPane();
        GridPane gd= new GridPane();
        stage.setScene(new Scene(root, 600, 400));
        gd.setAlignment(Pos.CENTER);

        stage.setTitle("TicTacToe");
        Label titleT= new Label("Tic-Tac-Toe");
        titleT.setStyle("-fx-font-size: 32px; -fx-text-alignment: center; -fx-alignment: center;");
        BorderPane.setAlignment(titleT,Pos.CENTER);
        root.setTop(titleT);

        root.setCenter(gd);
        createGrid(gd);
        askMode();

        if(vsComputer){
            playComp();
        }

        stage.show();
    }

    /**
     *Methode ist dazu da, um zu fragen, ob man gegen Mensch oder Computer spielen möchte.
     * Erstellt auch ein kleines Fenster mit den Buttons "Mensch" oder "Computer".
     * @return
     */
    private boolean askMode() {
        Stage w = new Stage();
        Button mensch = new Button("Mensch");
        Button computer = new Button("Computer");

        mensch.setOnAction(e -> {
            vsComputer = false;
            w.close();
        });

        computer.setOnAction(e -> {
            vsComputer = true;
            w.close();
        });

        HBox box = new HBox(20, mensch, computer);
        box.setAlignment(Pos.CENTER);
        w.setScene(new Scene(box, 250, 100));
        w.setTitle("Modus wählen");
        w.showAndWait();

        return vsComputer;
    }


    /**
     * Erstellt das Grid (Felder)
     * @param gd
     */
    private void createGrid(GridPane gd){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x =i;
                int y = j;
                btn[i][j] = new Button();
                btn[i][j].setPrefSize(100, 100);
                btn[i][j].setOnAction(e -> changeValue(x,y));
                gd.add(btn[i][j], j, i);
            }
        }
    }

    /**
     *Sorgt, dass das Feld nicht veränderbar ist.
     * Spieler setzt X oder O.
     * @param x
     * @param y
     */
    private void changeValue(int x, int y){
        if(!btn[x][y].getText().isEmpty()){
            return;
        }

        btn[x][y].setText(current);
        String o = current;
        current = next;
        next= o;
        checkWin();

        if(end) {
            stage.close();
        }
    }

    /**
     * Methode, um gegen Computer zu spielen.
     */
    private void playComp() {
        System.out.println("Computer gestartet");
    }

    /**
     * Methode, um zu prüfen, ob man gewonnen hat.
     * Reihen, Spalten und Diagonale werden geprüft.
     */
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

    /**
     * Methode, um zu prüfen, ob die drei Felder/Buttons alle gleich sind.
     * @param a
     * @param b
     * @param c
     * @return
     */
    private boolean same(Button a, Button b, Button c) {
        return !a.getText().isEmpty() && a.getText().equals(b.getText()) && b.getText().equals(c.getText());
    }
}