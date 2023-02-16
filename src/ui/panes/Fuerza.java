package ui.panes;

import javax.swing.*;

public class Fuerza extends JFrame{
    private JPanel mainPanel;

    public Fuerza () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
