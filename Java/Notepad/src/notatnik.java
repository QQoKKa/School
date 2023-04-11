import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class notatnik extends JDialog {
    private JPanel panel;
    private JPanel panel2;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu edit;
    private JMenuItem open,save, exit, selectAll;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private String fontName[];
    private Integer array[];
    private JButton bButton;
    private JButton button2;
    private JButton switchModeButton;
    private JTextArea textArea1;
    private JButton rbutton;
    boolean darkMode = false;
    int size = 24;
    String font;
    public notatnik() {
        setContentPane(panel);
        setModal(true);
        file = new JMenu("File");
        edit = new JMenu("Edit");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");
        selectAll = new JMenuItem("Select All");
        file.add(open);
        file.add(save);
        file.add(exit);
        edit.add(selectAll);
        menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
        setJMenuBar(menuBar);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    textArea1.setText("");
                    Scanner in = null;
                    try {
                        in = new Scanner(file);
                        while(in.hasNext()) {
                            String line = in.nextLine();
                            textArea1.append(line+"\n");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    PrintWriter out = null;
                    try {
                        out = new PrintWriter(file+".txt");
                        String output = textArea1.getText();
                        out.println(output);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            out.flush();
                        } catch (Exception ex1) {

                        }
                        try {
                            out.close();
                        } catch (Exception ex1) {

                        }
                    }

                    }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.selectAll();
            }
        });

        panel2.setBackground(new Color(47, 48, 97));
        bButton.setBackground(new Color(252, 252, 98));
        button2.setBackground(new Color(252, 252, 98));
        rbutton.setBackground(new Color(252, 252, 98));
        switchModeButton.setBackground(new Color(252, 252, 98));
        comboBox1.setBackground(new Color(252, 252, 98));
        comboBox2.setBackground(new Color(252, 252, 98));
        GraphicsEnvironment fontlist = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontName = fontlist.getAvailableFontFamilyNames();
        array = new Integer[fontName.length];
        file = new JMenu("File");

        for(int i=1;i<=fontName.length;i++) {;
            comboBox1.addItem(fontName[i-1]);
        }
        for (int i = 1; i <= 84; i++) {
            if (i%2==0) {
                comboBox2.addItem(i);
            }
        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                font = (String) comboBox1.getSelectedItem();
                textArea1.setFont(new Font(font, Font.PLAIN, size));
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = (int) comboBox2.getSelectedItem();
                textArea1.setFont(new Font(font, Font.PLAIN, size));
            }
        });
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setFont(new Font(font, Font.BOLD, size));
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setFont(new Font(font, Font.ITALIC, size));
            }
        });
        rbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setFont(new Font(font, Font.PLAIN, size));
            }
        });
        switchModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (darkMode) {
                    panel2.setBackground(new Color(47, 48, 97));
                    bButton.setBackground(new Color(252, 252, 98));
                    bButton.setForeground(Color.black);
                    button2.setBackground(new Color(252, 252, 98));
                    button2.setForeground(Color.black);
                    rbutton.setBackground(new Color(252, 252, 98));
                    rbutton.setForeground(Color.black);
                    switchModeButton.setBackground(new Color(252, 252, 98));
                    switchModeButton.setForeground(Color.black);
                    comboBox1.setBackground(new Color(252, 252, 98));
                    comboBox1.setForeground(Color.black);
                    comboBox2.setBackground(new Color(252, 252, 98));
                    comboBox2.setForeground(Color.black);
                    textArea1.setBackground(Color.WHITE);
                    textArea1.setForeground(Color.BLACK);
                    darkMode = false;
                } else {
                    panel2.setBackground(new Color(84, 26, 22));
                    bButton.setBackground(new Color(65, 123, 90));
                    bButton.setForeground(Color.WHITE);
                    button2.setBackground(new Color(65, 123, 90));
                    button2.setForeground(Color.WHITE);
                    rbutton.setBackground(new Color(65, 123, 90));
                    rbutton.setForeground(Color.WHITE);
                    switchModeButton.setBackground(new Color(65, 123, 90));
                    switchModeButton.setForeground(Color.WHITE);
                    comboBox1.setBackground(new Color(65, 123, 90));
                    comboBox1.setForeground(Color.WHITE);
                    comboBox2.setBackground(new Color(65, 123, 90));
                    comboBox2.setForeground(Color.WHITE);
                    textArea1.setBackground(new Color(59, 59, 59));
                    textArea1.setForeground(Color.WHITE);
                    darkMode = true;
                }
            }
        });

    }

    public static void main(String[] args) {
        notatnik dialog = new notatnik();
        dialog.pack();
        dialog.setMinimumSize(new Dimension(600, 400));
        dialog.setPreferredSize(new Dimension(1000, 800));
        dialog.setVisible(true);
        System.exit(0);
    }
}
