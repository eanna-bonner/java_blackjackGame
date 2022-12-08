import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame {
    public void init(){
        setTitle("Welcome to BlackJack");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        StartGame.startGame();
        Main blackjackInterface = new Main();
        blackjackInterface.init();





    }
}