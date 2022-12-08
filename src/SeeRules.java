import java.util.Scanner;

public class SeeRules {
    public static void seeRules(){
        System.out.println("How do you beat the dealer?\n" +
                "\n" +
                "By drawing a hand value that is higher than the dealer’s hand value\n" +
                "By the dealer drawing a hand value that goes over 21.\n" +
                "By drawing a hand value of 21 on your first two cards, when the dealer does not.\n" +
                "\n" +
                "How do you lose to the dealer? \n" +
                "\n" +
                "Your hand value exceeds 21.\n" +
                "The dealers hand has a greater value than yours at the end of the round");

        System.out.println("Would you like to play a game of BlackJack now?\nTo play press 1\nTo end gaming session, press 2");
        Scanner again = new Scanner(System.in);
        int playAgain = again.nextInt();
        if(playAgain == 1){
            PlayGame.playGame();
        }
        else;

    }

}
