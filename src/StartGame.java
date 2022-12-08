import java.util.Scanner;

public class StartGame {
    public static void startGame(){
        System.out.println("Welcome to BlackJack!! \nTo view the game rules, enter 1" +
                "\nTo play a game, enter 2");
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        if(entry ==1) {
            SeeRules.seeRules();
        }
        else if(entry ==2) {
            PlayGame.playGame();
        }
    }
}
