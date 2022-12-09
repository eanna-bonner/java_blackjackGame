import javax.swing.JPanel;

public class Player extends GameLogic {

    private String name;
    private String[] hand;
    private static int cardsReceived = 0;

    public Player(String name, String[] hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public String[] getHand() {
        return hand;
    }

    public int getCardsReceived() {
        return cardsReceived;
    }

    public static void setCardsReceived(int input) {
        cardsReceived = input;
    }

    public JPanel hit() {

        deal();
        JPanel output = displayCard("4H");

        if (checkBust()) {
            // Bust return

        } else if (!checkBust()) {
            if (getCardsReceived() == 5) {
                // 5 card trick return

            }
            if (trueHandValue() == 21) {
                // blackjack return

            }
        }
        return output;
    }
}
