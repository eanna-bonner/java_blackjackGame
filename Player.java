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

}
