import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args) {
        String[] playerHand = new String[5];

        int quit = -1;
        Scanner scanner = new Scanner(System.in);
        while (quit != 1) {
            Player player = new Player("Éanna", playerHand);
            Dealer dealer = new Dealer();

            GameLogic.startGame(player, dealer);

            Menu.choosePlay(player, scanner);

            System.out.println(" ");

            if (!player.checkBust() && (player.getCardsReceived() != 5)) {
                dealer.finishHand(dealer);
                GameLogic.checkWinner(player, dealer);
            }

            quit = Menu.playAgain(scanner);
        }
        scanner.close();
    }
}
