package ui.panes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JFrame {
    // Here are the items that will be showed on the main page
    private JPanel mainPanel;
    private JRadioButton distanciaRadioButton;
    private JRadioButton fuerzaRadioButton;
    private JRadioButton cargaRadioButton;
    private JButton nextButton;

    // This int is going to change its value in each radio button case
    private int selectedRadio = 999;

    public Welcome () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // This will get the selected radio button and print the index
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (selectedRadio != 999) {
                    if (selectedRadio == 0) {
                        Distancia distancia = new Distancia();
                    }
                    if (selectedRadio == 1) {
                        Fuerza fuerza = new Fuerza();
                    }
                    if (selectedRadio == 2) {
                        Carga carga = new Carga();
                    }
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una opción válida");
                    setVisible(false);
                    Welcome welcome = new Welcome();
                }
            }
        });

        // If distanciaRadioButton is clicked, will change the selectedRadio to 0
        distanciaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 0;
            }
        });

        // If fuerzaRadioButton is clicked, will change the selectedRadio to 1
        fuerzaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 1;
            }
        });

        // If cargaRadioButton is clicked, will change the selectedRadio to 2
        cargaRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRadio = 2;
            }
        });
    }

    // this will initialize the page
    public static void main() {
        Welcome welcome = new Welcome();
    }
}
