import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class HomeGUI {
    private Dealer dealer;
    private Player player;

    JFrame startMenu;

    HomeGUI(Dealer dealer, Player player) {

        this.dealer = dealer;
        this.player = player;

        startMenu = new JFrame();// creating instance startMenu JFrame

        // title
        JTextArea title = new JTextArea("Blackjack");
        title.setFont(new FontUIResource("Algerian", Font.BOLD, 50));
        title.setBackground(new java.awt.Color(53, 101, 77));
        title.setEditable(false);
        title.setBounds(45, 25, 300, 55);

        // Adds jack image to screen
        JPanel titleCards = new JPanel();
        titleCards.setBounds(150, 110, 100, 110);
        titleCards.setBackground(new java.awt.Color(53, 101, 77));
        BufferedImage myPicture;
        try {
            myPicture = ImageIO
                    .read(new File(
                            "Assets\\Cards\\titleBlackJack.png"));
        } catch (IOException e1) {
            myPicture = null;
            e1.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        titleCards.add(picLabel);

        // adds ace image to screen

        // makes buttons
        JButton startGame = new JButton("Play!");
        startGame.setBounds(165, 245, 70, 35);

        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new GameGUI(dealer, player);
                startMenu.dispose();

            }

        });

        JButton gotoRules = new JButton("Rules");// creating instance ostartMenu JButton
        gotoRules.setBounds(165, 300, 70, 35);

        gotoRules.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new RulesGUI();
            }

        });

        JButton exit = new JButton("Close");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                startMenu.dispose();
                System.exit(0);
            }

        });
        exit.setBounds(165, 355, 70, 35);

        // Add all to GUI

        startMenu.add(title);
        startMenu.add(titleCards);
        startMenu.add(startGame);
        startMenu.add(gotoRules);
        startMenu.add(exit);
        startMenu.getContentPane().setBackground(new java.awt.Color(53, 101, 77));
        startMenu.setSize(400, 500);// 400 width and 500 height
        startMenu.setLayout(null);// using no layout managers
        startMenu.setVisible(true);// making the startMenu frame visible
    }

}