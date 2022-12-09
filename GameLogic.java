import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GameLogic {

    String[] hand = { "", "", "", "", "" };
    int cardsReceived;

    private String cardSuit(String card) {
        String suit;
        char ch = card.charAt(card.length() - 1);

        if (ch == 'S') {
            suit = "spades";
        } else if (ch == 'D') {
            suit = "diamonds";
        } else if (ch == 'C') {
            suit = "clubs";
        } else if (ch == 'H') {
            suit = "hearts";
        } else {
            System.err.println("Error in cardSuit. Suit not found.");
            suit = "error";
        }

        return suit;
    }

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

    public JPanel displayCard(String card) {
        String stringValue;
        int intValue = cardValue(card);
        if (intValue == 11) {
            stringValue = "ace";
        } else {
            stringValue = Integer.toString(intValue);
        }
        String suit = cardSuit(card);
        JPanel cardPanel = new JPanel();
        cardPanel.setBounds(100 + (42 * cardsReceived), 110, 32, 56);
        cardPanel.setBackground(new java.awt.Color(0, 0, 0));// 53,101,77 is poker green
        BufferedImage myPicture;
        try {
            myPicture = ImageIO
                    .read(new File(
                            "Assets\\Cards\\" + stringValue + "_" + suit + ".png"));
        } catch (IOException e1) {
            myPicture = null;
            e1.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        cardPanel.add(picLabel);
        return cardPanel;
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
