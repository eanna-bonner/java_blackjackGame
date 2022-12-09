import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] playerHand = new String[5];

        int quit = -1;
        Scanner scanner = new Scanner(System.in);
        while (quit != 1) {
            Player player = new Player("Éanna", playerHand);
            Dealer dealer = new Dealer();

            GameLogic.startGame(player, dealer);
            new HomeGUI(dealer, player); // To play with GUI (Hit button adds cards to hand but does not display cards
                                         // :( )
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
