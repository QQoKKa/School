
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Main implements ActionListener {

    private JFrame gameWindow;
    private JLabel wordLabel;
    private JButton[] letterButtons;
    private String[] words = {"hej", "ja", "nie", "monaco", "akademia", "pana", "kleksa"};
    private String word;
    private int guessesLeft;
    private boolean wrongGuess = false;

    private Graphics2D g2d;
    private JLabel drawingLabel;

    public Main() {
        gameWindow = new JFrame("Hangman");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(1920, 1080);
        gameWindow.setVisible(true);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setLayout(new GridLayout(3, 1));
        gameWindow.getContentPane().setBackground(Color.decode("#392c42"));
        drawingLabel = new JLabel();
        drawingLabel.setPreferredSize(new Dimension(200, 100));
        drawingLabel.setLayout(null);
        gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingLabel.setOpaque(false);
        gameWindow.add(drawingLabel);
        wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        wordLabel.setForeground(Color.decode("#FFFFFF"));
        gameWindow.add(wordLabel);


        g2d = (Graphics2D) gameWindow.getGraphics();


        JPanel buttonPanel = new JPanel(new GridLayout(2, 13));
        letterButtons = new JButton[26];
        for (int i = 0; i < 26; i++) {
            letterButtons[i] = new RoundedButton(Character.toString((char) ('A' + i)));
            letterButtons[i].addActionListener(this);
            buttonPanel.add(letterButtons[i]);
        }
        buttonPanel.setOpaque(false);
        gameWindow.add(buttonPanel);
        newGame();

        drawHangman();
    }

    public void newGame() {
        for (int i = 0; i < 26; i++) {
            letterButtons[i].setBackground(Color.decode("#392c42"));
            letterButtons[i].setForeground(Color.decode("#FFFFFF"));
            //place buttons at bottom`
            drawHangman();
        }

        word = words[(int) (Math.random() * words.length)];
        System.out.println(word);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append("_ ");
        }
        wordLabel.setText(sb.toString());

        for (int i = 0; i < 26; i++) {
            letterButtons[i].setEnabled(true);
        }

        guessesLeft = 6;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        char letter = button.getText().charAt(0);
        button.setEnabled(false);
        boolean found = false;
        StringBuilder sb = new StringBuilder(wordLabel.getText());
        word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                found = true;
                sb.setCharAt(i * 2, letter);
            }
        }

        if (!found) {
            guessesLeft--;
            wrongGuess = true;
            button.setForeground(Color.decode("#ff0000"));
            drawHangman();
        } else {
            button.setForeground(Color.decode("#09ff00"));
        }
        wordLabel.setText(sb.toString());

        if (guessesLeft == 0) {
            JOptionPane.showMessageDialog(gameWindow, "Ju nub");
            newGame();
        } else if (!sb.toString().contains("_")) {
            JOptionPane.showMessageDialog(gameWindow, "Dobrze");
            newGame();
        }
    }
    private void drawHangman() {
        if (wrongGuess) {
            BufferedImage img = new BufferedImage(drawingLabel.getWidth(), drawingLabel.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setStroke(new BasicStroke(5));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawOval(50, 50, 50, 50);
            if (guessesLeft < 5) {
                g2d.drawLine(75, 100, 75, 200);
            }
            if (guessesLeft < 4) {
                g2d.drawLine(75, 100, 125, 150);
            }
            if (guessesLeft < 3) {
                g2d.drawLine(75, 100, 25, 150);
            }
            if (guessesLeft < 2) {
                g2d.drawLine(75, 200, 125, 250);
            }
            if (guessesLeft < 1) {
                g2d.drawLine(75, 200, 25, 250);
            }
            drawingLabel.setIcon(new ImageIcon(img));
        }
    }
    public class RoundedButton extends JButton {
        private static final int ARC_WIDTH = 20;
        private static final int ARC_HEIGHT = 20;

        public RoundedButton(String label) {
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorder(BorderFactory.createEmptyBorder(4, 15, 4, 15));
        }

        public void setEnabled(boolean enabled) {
            super.setEnabled(true);
            if (enabled) {
                setForeground(Color.decode("#FFFFFF"));
            } else {
                setForeground(Color.decode("#ff0000"));
            }
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            //g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, ARC_WIDTH, ARC_HEIGHT);
            g2.drawRoundRect(1, 1, getWidth() - 6, getHeight() - 6, ARC_WIDTH, ARC_HEIGHT);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}