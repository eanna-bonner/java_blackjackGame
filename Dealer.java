public class Dealer extends GameLogic {

    private String name = "Dealer";
    private String[] hand = new String[5];
    private static int cardsReceived = 0;

    public Dealer() {

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

    public void finishHand(Dealer dealer) {
        System.out.println("Dealer's" + dealer.displayHand());
        while ((dealer.trueHandValue() <= 16)) {
            dealer.deal();
            System.out.println("Dealer is finishing his" + dealer.displayHand());

            if (dealer.checkBust()) {
                System.out.println("Dealer went bust!");
            } else if (!dealer.checkBust()) {
                if (cardsReceived == 5) {
                    System.out.println("5 Card Trick!!! Dealer wins!");

                    break;
                }
                if (dealer.trueHandValue() == 21) {
                    System.out.println("Blackjack!");
                }
            }

        }
    }

}
