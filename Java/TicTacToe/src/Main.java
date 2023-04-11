import javax.swing.*;
import java.awt.*;

//create class main with window
public class Main extends JFrame {
    public Main() {
        super("Main");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(new java.awt.Color(40, 40, 40));
    }

    //create tic tac toe game
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.drawLine(133, 0, 133, 400);
        g.drawLine(266, 0, 266, 400);
        g.drawLine(0, 140, 400, 140);
        g.drawLine(0, 270, 400, 270);
    }

    public void objects() {
        //create 9 clickable cells
        JButton cell1 = new JButton();
        cell1.setBounds(0, 0, 133, 140);
        cell1.setBackground(new java.awt.Color(255, 0, 0));
        cell1.setBorderPainted(false);
        cell1.setFocusPainted(false);
        cell1.setContentAreaFilled(false);
        add(cell1);
    }
    public static void main(String[] args) {
        new Main();
    }
}