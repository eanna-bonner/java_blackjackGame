public class GameLogic {

    String[] hand = { "", "", "", "", "" };
    int cardsReceived;

    private int cardValue(String card) {
        int value = 0;
        if (card.length() == 2) {
            char ch = card.charAt(0);
            boolean isDigit = Character.isDigit(ch);
            if (isDigit) {
                value = Character.getNumericValue(ch);
            } else if (ch == 'A') {
                value = 11;
            } else {
                value = 10;
            }
        }

        else if (card.length() == 3) {
            value = 10;
        } else {
            value = 0;
        }

        return value;
    }

    public int handValue() {
        int handTotal = 0;
        for (int i = 0; i < hand.length; i++) {
            handTotal += cardValue(hand[i]);
        }
        return handTotal;
    }

    public int trueHandValue() {
        int value;
        if (handValue() > 21) {
            if (checkAce() > 0) {
                value = handValue() - (checkAce() * 10);
                if (value <= 11) {
                    value += 10;
                }
                return value;
            }
        }
        return handValue();
    }

    public int checkAce() {
        int aceCount = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].length() == 2) {
                if (hand[i].charAt(0) == 'A') {
                    aceCount += 1;
                }
            }
        }
        return aceCount;
    }

    public boolean checkBust() {
        if (trueHandValue() > 21) {
            return true;
        } else {
            return false;
        }

    }

    public String displayHand() {
        String output = " hand: {";
        for (int i = 0; i < hand.length; i++) {
            output = output + hand[i];
            if (i == hand.length - 1) {
                output = output + "}";
            } else {
                output = output + ", ";
            }

        }
        return output;
    }

    public void deal() {
        hand[cardsReceived] = Deck.getDeck()[Deck.getCardsPlayed()];
        Deck.incrementCardsPlayed();
        cardsReceived += 1;
        Player.setCardsReceived(cardsReceived);
    }

    public static void checkWinner(Player player, Dealer dealer) {
        if ((!dealer.checkBust()) && (dealer.getCardsReceived() != 5)) {
            System.out.println(" ");
            System.out.println("The value of the Dealer's hand is: " + dealer.trueHandValue());
            System.out.println("The value of your hand is: " + player.trueHandValue());
            if (dealer.trueHandValue() >= player.trueHandValue()) {
                System.out.println("The house always wins...");
                System.out.println("Better luck next time!");
            } else if (player.trueHandValue() > dealer.trueHandValue()) {
                System.out.println(player.getName() + " wins!!!");
            }
        } else {
            System.out.println("You win!");
        }
    }

    public static void startGame(Player player, Dealer dealer) {
        Deck.shuffleDeck();

        dealer.deal();
        player.deal();
        dealer.deal();
        player.deal();

        System.out.println("Here is your" + player.displayHand());

        System.out.println("The value of your hand is: " + player.trueHandValue());
    }
}
