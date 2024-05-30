package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ej9_UD20 extends JFrame {
    private ArrayList<JToggleButton> cards;
    private ArrayList<Color> colors;
    private JToggleButton selectedCard1;
    private JToggleButton selectedCard2;
    private int attempts;
    private JLabel attemptsLabel;
    private int pairsFound;

    public ej9_UD20() {
        setTitle("Memory Game");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize variables
        cards = new ArrayList<>();
        colors = new ArrayList<>();
        selectedCard1 = null;
        selectedCard2 = null;
        attempts = 0;
        pairsFound = 0;

        // Load colors
        Color[] colorArray = {
            Color.RED, Color.RED,
            Color.GREEN, Color.GREEN,
            Color.BLUE, Color.BLUE,
            Color.YELLOW, Color.YELLOW,
            Color.ORANGE, Color.ORANGE,
            Color.MAGENTA, Color.MAGENTA,
            Color.CYAN, Color.CYAN,
            Color.PINK, Color.PINK
        };

        Collections.addAll(colors, colorArray);
        Collections.shuffle(colors);

        // Create panel for cards
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            JToggleButton card = new JToggleButton();
            card.setBackground(colors.get(i)); // Show color initially
            card.setPreferredSize(new Dimension(100, 100));
            card.setOpaque(true);
            card.setBorderPainted(false);
            card.putClientProperty("color", colors.get(i));
            card.addActionListener(new CardListener());
            cards.add(card);
            cardPanel.add(card);
        }
        add(cardPanel, BorderLayout.CENTER);

        // Attempts label
        attemptsLabel = new JLabel("Attempts: 0");
        add(attemptsLabel, BorderLayout.NORTH);

        // "Flip All" button
        JButton flipAllButton = new JButton("Girar");
        flipAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JToggleButton card : cards) {
                    card.setBackground(Color.GRAY);
                    card.setSelected(false);
                }
                selectedCard1 = null;
                selectedCard2 = null;
            }
        });
        add(flipAllButton, BorderLayout.SOUTH);
    }

    private class CardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JToggleButton selectedCard = (JToggleButton) e.getSource();

            if (selectedCard1 == null) {
                selectedCard1 = selectedCard;
                selectedCard1.setBackground((Color) selectedCard1.getClientProperty("color"));
            } else if (selectedCard1 != selectedCard && selectedCard2 == null) {
                selectedCard2 = selectedCard;
                selectedCard2.setBackground((Color) selectedCard2.getClientProperty("color"));
                attempts++;
                attemptsLabel.setText("Attempts: " + attempts);

                // Check for a match
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (selectedCard1.getClientProperty("color").equals(selectedCard2.getClientProperty("color"))) {
                            selectedCard1.setVisible(false);
                            selectedCard2.setVisible(false);
                            pairsFound++;
                            if (pairsFound == 8) {
                                JOptionPane.showMessageDialog(null, "Congratulations! You found all pairs!");
                            }
                        } else {
                            selectedCard1.setBackground(Color.GRAY);
                            selectedCard2.setBackground(Color.GRAY);
                        }
                        selectedCard1 = null;
                        selectedCard2 = null;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ej9_UD20().setVisible(true);
            }
        });
    }
}
