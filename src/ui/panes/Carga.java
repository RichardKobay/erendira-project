package ui.panes;

import javax.swing.*;

public class Carga extends JFrame{
    private JPanel mainPanel;

    public Carga () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
