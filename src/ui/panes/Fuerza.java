package ui.panes;

import data.DataAndFunctions;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fuerza extends JFrame{
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton calculateButton;
    private JTextField q1TextField;
    private JTextField q3TextField;
    private JTextField q2TextField;
    private JTextField distance1textField;
    private JTextField distance2TextField;
    private JLabel q3Label;
    private JLabel distancia2Label;

    public Fuerza () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Return to the main page and close current page
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Welcome welcome = new Welcome();
                setVisible(false);
            }
        });

        //  Check if q2 is filled, if it's filled, will unlock the q3 TextField to let the user write the third charge
        //  and the second distance field
        q2TextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                q3Label.setEnabled(q2TextField.getText().length() > 0);
                q3TextField.setEnabled(q2TextField.getText().length() > 0);
                if (!(q2TextField.getText().length() > 0)) q3TextField.setText(null);
                if (!(q2TextField.getText().length() > 0)) distance2TextField.setText(null);
            }
        });

        /*
        * Main button, will show the force between 2 or 3 charges
        *
        *
        * */
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (q3TextField.getText().length() == 0) {
                    try {
                        double q1Value = Math.abs(Double.parseDouble(q1TextField.getText()));
                        double q2Value = Math.abs(Double.parseDouble(q2TextField.getText()));
                        double distance1Value = Math.abs(Double.parseDouble(distance1textField.getText()));
                        q1Toq2Force(q1Value, q2Value, distance1Value);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Introduzca un número válido");
                    }
                }
            }
        });
    }

    private void q1Toq2Force (double q1Value, double q2Value, double distanceValue) {
        double force = DataAndFunctions.calcForce(q1Value, q2Value, distanceValue);
        JOptionPane.showMessageDialog(null, "La fuerza entre q1 y q2 es: " + force);
    }
}
