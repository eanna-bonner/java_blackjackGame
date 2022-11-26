import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args) {
        String[] playerHand = new String[5];
        String[] dealerHand = new String[5];

        int quit = -1;
        Scanner scanner = new Scanner(System.in);
        while (quit != 1) {
            Player player = new Player("Éanna", playerHand);
            Player dealer = new Player("Dealer", dealerHand);

            Deck.shuffleDeck();

            dealer.deal();
            player.deal();
            dealer.deal();
            player.deal();

            System.out.println("Here is your" + player.displayHand());

            System.out.println("The value of your hand is: " + player.handValue());

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
                    System.out.println("The value of your hand is: " + player.handValue());

                    if (player.checkBust()) {
                        System.out.println("You went bust!");
                        input = 1;
                    } else if (!player.checkBust()) {
                        if (player.getCardsReceived() == 5) {
                            System.out.println("5 Card Trick!!! You win!");
                            input = 1;
                        }
                        if (player.handValue() == 21) {
                            System.out.println("Blackjack!");
                            input = 1;
                        }
                    }

                }

            }
            System.out.println(" ");
            if (!player.checkBust() && (player.getCardsReceived() != 5)) {
                System.out.println("Dealer's" + dealer.displayHand());
                while ((dealer.handValue() <= 16)) {
                    dealer.deal();
                    System.out.println("Dealer is finishing his" + dealer.displayHand());

                    if (dealer.checkBust()) {
                        System.out.println("Dealer went bust!");
                    } else if (!dealer.checkBust()) {
                        if (dealer.getCardsReceived() == 5) {
                            System.out.println("5 Card Trick!!! Dealer wins!");

                            break;
                        }
                        if (dealer.handValue() == 21) {
                            System.out.println("Blackjack!");
                        }
                    }

                }

                if ((!dealer.checkBust()) && (dealer.getCardsReceived() != 5)) {
                    System.out.println(" ");
                    System.out.println("The value of the Dealer's hand is: " + dealer.handValue());
                    System.out.println("The value of your hand is: " + player.handValue());
                    if (dealer.handValue() >= player.handValue()) {
                        System.out.println("The house always wins...");
                        System.out.println("Better luck next time!");
                    } else if (player.handValue() > dealer.handValue()) {
                        System.out.println(player.getName() + " wins!!!");
                    }
                }

            }
            System.out.println(" ");
            System.out.println("Play again?");
            System.out.println("[0] Yes");
            System.out.println("[1] No");
            int againInput = -1;
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

        }
        scanner.close();
    }

}
