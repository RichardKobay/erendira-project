package ui.panes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame {
    private JPanel mainPanel;
    private JRadioButton distanciaRadioButton;
    private JRadioButton fuerzaRadioButton;
    private JRadioButton cargaRadioButton;
    private JButton nextButton;

    private int selectedRadio;

    public Welcome () {
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(selectedRadio);
            }
        });

        distanciaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 0;
            }
        });

        fuerzaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 1;
            }
        });

        cargaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 2;
            }
        });
    }

    public static void main() {
        Welcome welcome = new Welcome();
    }
}
