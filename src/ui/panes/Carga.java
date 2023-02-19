package ui.panes;

import data.DataAndFunctions;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Carga extends JFrame{
    private JPanel mainPanel;
    private JButton returnButton;
    private JButton calculateButton;
    private JTextField q1TextField;
    private JTextField distanceTextField;
    private JTextField forceTextField;

    public Carga () {
        // This will show the main panel, that shows everything
        setContentPane(mainPanel);
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // Return to main panel and close actual panel
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Welcome welcome = new Welcome();
                setVisible(false);
            }
        });


        /*
        * MAIN FUNCTION
        * This function will check if the numbers on the TextFields ar really numbers and not letters or other characters
        * Then will change all the values for its absolute value and then will cal the function that will show the value
        * of the missing charge.
        * */
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    double q1Value = Math.abs(Double.parseDouble(q1TextField.getText()));
                    double forceValue = Math.abs(Double.parseDouble(forceTextField.getText()));
                    double distanceValue = Math.abs(Double.parseDouble(distanceTextField.getText()));
                    calcCharge(q1Value, forceValue, distanceValue);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Digite números válidos");
                }
            }
        });
    }

    // Calls the function that will calc the missing charge and will show it with a JOptionPane
    private void calcCharge (double q1Value, double forceValue, double distanceValue) {
        double charge = DataAndFunctions.calcCharge(q1Value, forceValue, distanceValue);
        JOptionPane.showMessageDialog(null, "La carga dos tiene un valor de: " + charge);
    }
}
