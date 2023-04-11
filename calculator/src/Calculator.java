import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;


public class Calculator extends JDialog {

    private JPanel contentPane;
    private JButton j7Button;
    private JButton j4Button;
    private JButton j5Button;
    private JButton j8Button;
    private JButton j2Button;
    private JButton j1Button;
    private JButton j9Button;
    private JButton j6Button;
    private JButton j3Button;
    private JButton j0Button;
    private JButton jminusbutton;
    private JButton jplusbutton;
    private JButton jmnozenieButton;
    private JButton jdzielenieButton;
    private JButton jrownaButton;
    private JLabel jlabel;
    private JLabel jLabel2;
    private JButton cButton;

    public static float num1, num2, wynik;
    public static int akcja;
    public Calculator() {


        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        j0Button.setBorder(new LineBorder(Color.pink, 1, true));
        j1Button.setBorder(new LineBorder(Color.pink, 1, false));
        j2Button.setBorder(new LineBorder(Color.pink, 1, true));
        j3Button.setBorder(new LineBorder(Color.pink, 1, true));
        j4Button.setBorder(new LineBorder(Color.pink, 1, true));
        j5Button.setBorder(new LineBorder(Color.pink, 1, true));
        j6Button.setBorder(new LineBorder(Color.pink, 1, true));
        j7Button.setBorder(new LineBorder(Color.pink, 1, true));
        j8Button.setBorder(new LineBorder(Color.pink, 1, true));
        j9Button.setBorder(new LineBorder(Color.pink, 1, true));
        jminusbutton.setBorder(new LineBorder(Color.pink, 1, true));
        jplusbutton.setBorder(new LineBorder(Color.pink, 1, true));
        jmnozenieButton.setBorder(new LineBorder(Color.pink, 1, true));
        jdzielenieButton.setBorder(new LineBorder(Color.pink, 1, true));
        jrownaButton.setBorder(new LineBorder(Color.pink, 1, true));
        cButton.setBorder(new LineBorder(Color.pink, 1, true));

        j0Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "0");
            }
        });
        j1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "1");
            }
        });
        j2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "2");
            }
        });
        j3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "3");
            }
        });
        j4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "4");
            }
        });
        j5Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "5");
            }
        });
        j6Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "6");
            }
        });
        j7Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "7");
            }
        });
        j8Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "8");
            }
        });
        j9Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jlabel.setText(jlabel.getText() + "9");
            }
        });
        jminusbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jLabel2.setText("Odejmowanie");
                num1 = Integer.parseInt(jlabel.getText());
                jlabel.setText("");
                akcja = 2;
            }
        });
        jplusbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jLabel2.setText("Dodawanie");
                num1 = Integer.parseInt(jlabel.getText());
                jlabel.setText("");
                akcja = 1;
            }
        });
        jmnozenieButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jLabel2.setText("Mnożenie");
                num1 = Integer.parseInt(jlabel.getText());
                jlabel.setText("");
                akcja = 3;
            }
        });
        jdzielenieButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jLabel2.setText("Dzielenie");
                num1 = Integer.parseInt(jlabel.getText());
                jlabel.setText("");
                akcja = 4;
            }
        });
        jrownaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                num2 = Integer.parseInt(jlabel.getText());
                switch (akcja) {
                    case 1:
                        wynik = num1 + num2;
                        break;
                    case 2:
                        wynik = num1 - num2;
                        break;
                    case 3:
                        wynik = num1 * num2;
                        break;
                    case 4:
                        wynik = num1 / num2;
                        break;
                }
                if (wynik % 1 == 0) {
                    int wynik2 = (int) wynik;
                    jlabel.setText("");
                    jlabel.setText(jlabel.getText() + wynik2);
                    System.out.println(wynik2);
                } else {
                    jlabel.setText("");
                    jlabel.setText(jlabel.getText() + wynik);
                }

            }
        });
        cButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                jLabel2.setText("");
                jlabel.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Calculator dialog = new Calculator();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}