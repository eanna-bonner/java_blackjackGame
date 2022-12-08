import java.util.*;

public class PlayGame {
    public static void playGame() {
        List<Integer> cards = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5,
                6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        int dealerHand = 0;
        int playerHand = 0;
        int dealerHiddenCard = 0;

        double index = (Math.random() * (cards.size()));
        int newIndex = (int) index;
        playerHand = playerHand + cards.get(newIndex);
        Integer integer = cards.remove(newIndex);

//        System.out.println(newIndex);
//        System.out.println(playerHand);
//        System.out.println(integer);
//        System.out.println(cards.size());

        index = (Math.random() * (cards.size()));
        newIndex = (int) index;
        dealerHand = dealerHand + cards.get(newIndex);
        integer = cards.remove(newIndex);

//        System.out.println(newIndex);
//        System.out.println(playerHand);
//        System.out.println(integer);
//        System.out.println(cards.size());

        index = (Math.random() * (cards.size()));
        newIndex = (int) index;
        playerHand = playerHand + cards.get(newIndex);
        integer = cards.remove(newIndex);

        index = (Math.random() * (cards.size()));
        newIndex = (int) index;
        dealerHiddenCard = dealerHiddenCard + cards.get(newIndex);
        integer = cards.remove(newIndex);

        System.out.println("The cards have been dealt!!! \nYour hand is " + playerHand + "\nThe dealers first " +
                "card is worth " + dealerHand);

//        System.out.println(cards);

        System.out.println("To take another card, enter 1 \nTo sit, enter 2");
        Scanner scanner = new Scanner(System.in);
        int decision = scanner.nextInt();
        if (decision == 1) {
            index = (Math.random() * (cards.size()));
            newIndex = (int) index;
            playerHand = playerHand + cards.get(newIndex);
            System.out.println("You have been dealt a " + cards.get(newIndex) + "!!\nYour hand is now " + playerHand);
            integer = cards.remove(newIndex);

            if (playerHand > 21) {
                System.out.print("Oops! Your hand of " + playerHand + " has made you go bust. The dealer has won!!");
            }

            else if(playerHand== 21){
                System.out.println("You have got Blackjack!! Let's see what the dealer gets");
                System.out.println("The dealer flips his second card and now has "+ (dealerHand));
                while(dealerHand<17){
                    index = (Math.random() * (cards.size()));
                    newIndex = (int) index;
                    dealerHand = dealerHand + cards.get(newIndex);
                    integer = cards.remove(newIndex);
                }
                System.out.println("The dealer has hit until he reached 17....\nThe dealer now has "+dealerHand);
                if(dealerHand>21){
                    System.out.println("The dealer has went bust. You win!!");
                }
                else if(dealerHand<22) {
                    if ((dealerHand > 16) && (dealerHand < playerHand)) {
                        System.out.println("You have won!!");}
                    else if ((dealerHand > 16) && (dealerHand > playerHand)) {
                        System.out.println("You have lost");}
                    else if ((dealerHand > 16) && (dealerHand == playerHand)) {
                        System.out.println("You have drawn");}
                }
            }
            else if (playerHand < 21) {
                System.out.println("To take another card, enter 1 \nTo sit, enter 2");
                decision = scanner.nextInt();
                if (decision == 1) {
                    index = (Math.random() * (cards.size()));
                    newIndex = (int) index;
                    playerHand = playerHand + cards.get(newIndex);
                    System.out.println("You have been dealt a " + cards.get(newIndex) + "!!\nYour hand is now " + playerHand);
                    integer = cards.remove(newIndex);
                    if (playerHand > 21) {
                        System.out.print("Oops! Your hand of " + playerHand + " has made you go bust. The dealer has won!!");
                    }
                    else if (playerHand == 21) {
                        System.out.println("You have got Blackjack!! Let's see what the dealer gets");
                        System.out.println("The dealer flips his second card and now has " + (dealerHand));
                        while (dealerHand < 17) {
                            index = (Math.random() * (cards.size()));
                            newIndex = (int) index;
                            dealerHand = dealerHand + cards.get(newIndex);
                            integer = cards.remove(newIndex);
                        }
                        System.out.println("The dealer has hit until he reached 17....\nThe dealer now has " + dealerHand);
                        if (dealerHand > 21) {
                            System.out.println("The dealer has went bust. You win!!");
                        } else if (dealerHand < 22) {
                            if ((dealerHand > 16) && (dealerHand < playerHand)) {
                                System.out.println("You have won!!");
                            } else if ((dealerHand > 16) && (dealerHand > playerHand)) {
                                System.out.println("You have lost");
                            } else if ((dealerHand > 16) && (dealerHand == playerHand)) {
                                System.out.println("You have drawn");
                            }
                        }
                    }
                    else if (playerHand < 21) {
                        System.out.println("To take another card, enter 1 \nTo sit, enter 2");
                        decision = scanner.nextInt();
                        if (decision == 1) {
                            index = (Math.random() * (cards.size()));
                            newIndex = (int) index;
                            playerHand = playerHand + cards.get(newIndex);
                            System.out.println("You have been dealt a " + cards.get(newIndex) + "!!\nYour hand is now " + playerHand);
                            integer = cards.remove(newIndex);
                            if (playerHand > 21) {
                                System.out.print("Oops! Your hand of " + playerHand + " has made you go bust. The dealer has won!!");
                            }
                            else if (playerHand<22) {
                                System.out.println("You have won via Charlies Rule!!!\n When you receive five " +
                                        "cards and don't go bust, you automatically win!");

                            }


                        }
                        else if (decision == 2) {
                            System.out.println("Let's see what the dealer gets");
                            dealerHand = dealerHiddenCard + dealerHand;
                            System.out.println("The dealer flips his second card and now has " + (dealerHand));
                            while (dealerHand < 17) {
                                index = (Math.random() * (cards.size()));
                                newIndex = (int) index;
                                dealerHand = dealerHand + cards.get(newIndex);
                                integer = cards.remove(newIndex);
                            }
                            System.out.println("The dealer has hit until he reached 17....\nThe dealer now has " + dealerHand);
                            if (dealerHand > 21) {
                                System.out.println("The dealer has went bust. You win!!");
                            }
                            else if (dealerHand < 22) {
                                System.out.println("The dealer has " + dealerHand);
                                if ((dealerHand > 16) && (dealerHand < playerHand)) {
                                    System.out.println("You have won!!");
                                } else if ((dealerHand > 16) && (dealerHand > playerHand)) {
                                    System.out.println("You have lost");
                                } else if ((dealerHand > 16) && (dealerHand == playerHand)) {
                                    System.out.println("You have drawn");
                                }
                            }

                        }
                    }

                }
                else if (decision == 2) {
                        System.out.println("Let's see what the dealer gets");
                        dealerHand = dealerHiddenCard + dealerHand;
                        System.out.println("The dealer flips his second card and now has " + (dealerHand));
                        while (dealerHand < 17) {
                            index = (Math.random() * (cards.size()));
                            newIndex = (int) index;
                            dealerHand = dealerHand + cards.get(newIndex);
                            integer = cards.remove(newIndex);
                        }
                        System.out.println("The dealer has hit until he reached 17....\nThe dealer now has " + dealerHand);
                        if (dealerHand > 21) {
                            System.out.println("The dealer has went bust. You win!!");
                        }
                        else if (dealerHand < 22) {
                            System.out.println("The dealer has " + dealerHand);
                            if ((dealerHand > 16) && (dealerHand < playerHand)) {
                                System.out.println("You have won!!");
                            } else if ((dealerHand > 16) && (dealerHand > playerHand)) {
                                System.out.println("You have lost");
                            } else if ((dealerHand > 16) && (dealerHand == playerHand)) {
                                System.out.println("You have drawn");
                            }
                        }

                }
            }
        }
        else if(decision==2){
            System.out.println("Let's see what the dealer gets");
            dealerHand= dealerHiddenCard+dealerHand;
            System.out.println("The dealer flips his second card and now has "+ (dealerHand));
            while(dealerHand<17){
                index = (Math.random() * (cards.size()));
                newIndex = (int) index;
                dealerHand = dealerHand + cards.get(newIndex);
                integer = cards.remove(newIndex);
            }
            System.out.println("The dealer has hit until he reached 17....\nThe dealer now has "+dealerHand);
            if(dealerHand>21){
                System.out.println("The dealer has went bust. You win!!");
            }
            else if(dealerHand<22) {
                if ((dealerHand > 16) && (dealerHand < playerHand)) {
                    System.out.println("You have won!!");
                }
                else if ((dealerHand > 16) && (dealerHand > playerHand)) {
                    System.out.println("You have lost");
                }
                else if ((dealerHand > 16) && (dealerHand == playerHand)) {
                    System.out.println("You have drawn");
                }
            }

        }
    System.out.println("Would you like to play again?\nTo play again press 1\nTo end gaming session, press 2");
        Scanner again = new Scanner(System.in);
        int playAgain = again.nextInt();
        if(playAgain == 1){
            PlayGame.playGame();
        }
        else;

    }
}

