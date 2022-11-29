import java.util.Scanner;

public class Menu {

    public static void choosePlay(Player player, Scanner scanner) {

        int input = -1;
        while (input != 1) {
            input = -1;
            while ((input != 0) && (input != 1)) {
                System.out.println("Please choose a move:");
                System.out.println("[0] = Hit");
                System.out.println("[1] = Stand");
                input = scanner.nextInt();
            }
            if (input == 0) {
                System.out.println(" ");
                player.deal();
                System.out.println("Here is your" + player.displayHand());
                System.out.println("The value of your hand is: " + player.trueHandValue());

                if (player.checkBust()) {
                    System.out.println("You went bust!");
                    input = 1;
                } else if (!player.checkBust()) {
                    if (player.getCardsReceived() == 5) {
                        System.out.println("5 Card Trick!!! You win!");
                        input = 1;
                    }
                    if (player.trueHandValue() == 21) {
                        System.out.println("Blackjack!");
                        input = 1;
                    }
                }

            }

        }

    }

    public static int playAgain(Scanner scanner) {

        System.out.println(" ");
        System.out.println("Play again?");
        System.out.println("[0] Yes");
        System.out.println("[1] No");
        int againInput = -1;
        int quit = -1;
        while ((againInput != 0) && (againInput != 1)) {
            againInput = scanner.nextInt();
            if (againInput == 0) {
                quit = 0;
            } else if (againInput == 1) {
                quit = 1;
                System.out.println("Thanks for playing!");
            }
            System.out.println(" ");
        }

        return quit;

    }

}
