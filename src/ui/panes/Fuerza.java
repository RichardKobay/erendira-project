package ui.panes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fuerza extends JFrame{
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton calculateButton;

    public Fuerza () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Welcome welcome = new Welcome();
                setVisible(false);
            }
        });
    }
}
