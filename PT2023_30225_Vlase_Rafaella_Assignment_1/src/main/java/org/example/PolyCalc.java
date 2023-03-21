package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolyCalc extends JFrame implements ActionListener {

    private JTextField poly1Field, poly2Field, resultField;

    public PolyCalc() {
        setTitle("Polynomial Calculator");
        setSize(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create panel for the entire content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // absolute positioning
        contentPanel.setBackground(new Color(230, 216, 255)); // lavender-light blue

        // create panel for polynomial input boxes
        JPanel polyPanel = new JPanel();
        polyPanel.setLayout(new GridLayout(2, 1));
        poly1Field = new JTextField(20);
        poly2Field = new JTextField(20);
        polyPanel.setBackground(new Color(230, 216, 255));
        polyPanel.add(new JLabel("Polynomial 1: "));
        polyPanel.add(poly1Field);
        polyPanel.add(new JLabel("Polynomial 2: "));
        polyPanel.add(poly2Field);
        polyPanel.setBounds(10, 10, 250, 100); // absolute positioning
        contentPanel.add(polyPanel);

        // create panel for calculator buttons
        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(new GridLayout(4, 4));
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "X", "+", "-", "*", "/", "^", "\u2202", "\u222b", "=", "Del"};
        calcPanel.setBackground(new Color(230, 216, 255));
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            calcPanel.add(button);
        }
        calcPanel.setBounds(270, 10, 310, 180); // absolute positioning
        contentPanel.add(calcPanel);

        // create panel for result display
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(new JLabel("Result: "));
        resultField = new JTextField(20);
        resultField.setEditable(false);
        resultPanel.add(resultField);
        resultPanel.setBounds(10, 120, 250, 70); // absolute positioning
        resultPanel.setBackground(new Color(230, 216, 255));
        contentPanel.add(resultPanel);

        setContentPane(contentPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // implement calculator logic here based on button commands
    }
}