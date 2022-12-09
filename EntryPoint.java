public class EntryPoint {
    public static void main(String[] args) {
        String[] playerHand = new String[5];
        Player player = new Player("Éanna", playerHand);
        Dealer dealer = new Dealer();
        new HomeGUI(dealer, player);

    }
}