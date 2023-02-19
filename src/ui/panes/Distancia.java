package ui.panes;

import data.DataAndFunctions;

import javax.swing.*;
import java.awt.event.*;

public class Distancia extends JFrame {
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton calculateButton;
    private JTextField q1;
    private JTextField q2;
    private JTextField q3;
    private JTextField force;
    private JTextField force2;
    private JLabel force2Label;

    // q and force Variables
    private double q1Value = 0;
    private double q2Value = 0;
    private double q3Value = 0;
    private double forceValue = 0;
    private double force2Value = 0;

    public Distancia () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Will return to the main page and close current page
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Welcome();
                setVisible(false);
            }
        });

        // Check if q2 is filled, if it's filled, will unlock the q3 TextField to let the user write the third charge
        q2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                q3.setEnabled(q2.getText().length()>0);
                force2.setEnabled(q3.isEnabled());
                if (!(q2.getText().length()>0)) q3.setText(null);
                if (!(q2.getText().length()>0)) force2.setText(null);
            }
        });

        /*
         * This is the main button, will show the distance between 2 or 3 charges
         *
         * First, will get the length of q3 TextInput to check if it's empty or not, if it is, will check if the values
         * of the inputs are really numbers and not letter or other special characters, if there are no special characters,
         * will cal the function to calculate q1 to q2 distance, and show it with a JOptionPane
         *
         * If q3 is non-empty, will call another function that will calculate the distance between q1 and q2
         * and q2 and q3 and will show it with a JOptionPane
         *
         * @author Ricardo Soriano
         */
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (q3.getText().length() == 0) {
                    try {
                        q1Value = Math.abs(Double.parseDouble(q1.getText()));
                        q2Value = Math.abs(Double.parseDouble(q2.getText()));
                        forceValue = Math.abs(Double.parseDouble(force.getText()));
                        q1To12Distance(q1Value, q2Value, forceValue);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Digite números válidos");
                    }
                }

                if (!(q3.getText().length() == 0)) {
                    try {
                        q1Value = Math.abs(Double.parseDouble(q1.getText()));
                        q2Value = Math.abs(Double.parseDouble(q2.getText()));
                        q3Value = Math.abs(Double.parseDouble(q3.getText()));
                        forceValue = Math.abs(Double.parseDouble(force.getText()));
                        force2Value = Math.abs(Double.parseDouble(force2.getText()));
                        q1Q2AndQ3Distance(q1Value, q2Value, q3Value, forceValue, force2Value);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null, "Digite números válidos");
                    }
                }
            }
        });

        // Will listen the q2 TextField, if it's changed an if it's not empty, will activate the textField and Label for q3
        q3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                force2.setEnabled(q3.getText().length()>0);
                force2Label.setEnabled(q3.getText().length()>0);
            }
        });
    }

    // Calc the distance and show it in a MessageDialog
    private void q1To12Distance (double q1Value, double q2Value, double forceValue) {
        double distance = DataAndFunctions.calcDistance(q1Value, q2Value, forceValue);
        JOptionPane.showMessageDialog(null, "La distancia entre q1 y q2 es: " + distance);
    }

    private void q1Q2AndQ3Distance (double q1Value, double q2Value, double q3Value, double forceValue, double force2Value) {
        double[] data = DataAndFunctions.calcDistance(q1Value, q2Value, q3Value, forceValue, force2Value);
        JOptionPane.showMessageDialog(null, "La distancia entre q1 y q2 es: " + data[0] + "\nLa distancia entre q2 y q3 es: " + data[1]);
    }
}
