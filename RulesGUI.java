import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class RulesGUI {

    RulesGUI() {
        JFrame rulesGUI = new JFrame();// creating instance of JFrame

        // Title text area
        JTextArea title = new JTextArea("Blackjack Rules");
        title.setFont(new FontUIResource("Algerian", Font.BOLD, 30));
        title.setBackground(new java.awt.Color(53, 101, 77));
        title.setEditable(false);
        title.setBounds(50, 25, 300, 40);

        // List of rules
        JLabel rules = new JLabel("<html><ul>" +
                "<li>Play against the Dealer.</li>" +
                "<li>Each player gets 2 cards.</li>" +
                "<li>All picture cards are worth 10.</li>" +
                "<li>Ace is worth 11 OR 1.</li>" +
                "<li>21 points is Blackjack.</li>" +
                "<li>Go over 21 and you're Bust, you lose.</li>" +
                "<li>If you get 5 cards and are not bust, thats a 5 card trick, you win!</li>" +
                "<li>Press 'Hit' to draw a card.</li>" +
                "<li>Press 'Stand' to pass your turn.</li>" +
                "<li>The Dealer will then finish his hand.</li>" +
                "<li>Higher score wins!</li>" +
                "</ul><html>");

        rules.setFont(new FontUIResource("Algerian", Font.PLAIN, 15));
        rules.setBackground(new java.awt.Color(53, 101, 77));
        rules.setBounds(20, 90, 340, 300);

        // "Close" button
        JButton exit = new JButton("Close");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                rulesGUI.dispose();
            }

        });
        exit.setBounds(165, 410, 70, 35);
        // Add all to GUI
        rulesGUI.add(title);
        rulesGUI.add(rules);
        rulesGUI.add(exit);
        rulesGUI.getContentPane().setBackground(new java.awt.Color(53, 101, 77));
        rulesGUI.setSize(400, 500);// 400 width and 500 height
        rulesGUI.setLayout(null);// using no layout managers
        rulesGUI.setVisible(true);// making the frame visible
    }
}
