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
                value = 1;
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

    public boolean checkBust() {
        if (handValue() > 21) {
            return true;
        }

        else {
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
}
