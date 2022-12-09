import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class GameGUI {
    private Dealer dealer;
    private Player player;

    public GameGUI(Dealer dealer, Player player) {

        this.dealer = dealer;
        this.player = player;

        JFrame gameGUI = new JFrame();// creating instance of JFrame

        // Title text area
        JTextArea title = new JTextArea("Blackjack");
        title.setFont(new FontUIResource("Algerian", Font.BOLD, 50));
        title.setBackground(new java.awt.Color(53, 101, 77));
        title.setEditable(false);
        title.setBounds(45, 40, 300, 55);

        // Game narration

        // Show Cards

        // Hit Stand

        JButton hit = new JButton("HIT");
        hit.setBounds(50, 370, 75, 35);

        hit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                gameGUI.add(player.hit());
            }

        });

        JButton stand = new JButton("STAND");
        stand.setBounds(265, 370, 75, 35);

        stand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO "stand"
            }

        });

        // "Rules" button
        JButton gotoRules = new JButton("Rules");// creating instance ostartMenu JButton
        gotoRules.setBounds(310, 5, 70, 35);

        gotoRules.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RulesGUI();
            }

        });

        // "Close" button
        JButton home = new JButton("Home");
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameGUI.dispose();
            }

        });
        home.setBounds(5, 5, 70, 35);
        // Add all to GUI
        gameGUI.add(title);
        gameGUI.add(hit);
        gameGUI.add(stand);
        gameGUI.add(home);
        gameGUI.add(gotoRules);
        gameGUI.getContentPane().setBackground(new java.awt.Color(53, 101, 77));
        gameGUI.setSize(400, 500);// 400 width and 500 height
        gameGUI.setLayout(null);// using no layout managers
        gameGUI.setVisible(true);// making the frame visible
    }
}
