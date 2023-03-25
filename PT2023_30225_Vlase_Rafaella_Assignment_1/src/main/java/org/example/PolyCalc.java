package org.example;

import javax.swing.*;
import java.awt.*;

public class PolyCalc extends JFrame {

    private JPanel topPanel, bottomPanel;
    private JLabel polynomial1Label, polynomial2Label, resultLabel;
    private JTextField polynomial1Field, polynomial2Field, resultField;
    private JButton addButton, subButton, mulButton, divButton, derButton, intButton, calcButton;

    public PolyCalc() {
        // Create and configure the window
        super("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the top panel with labels and text fields
        topPanel = new JPanel(new GridLayout(3, 2));
        polynomial1Label = new JLabel("Polynomial 1:");
        polynomial1Field = new JTextField();
        polynomial1Field.setOpaque(false);
        polynomial2Label = new JLabel("Polynomial 2:");
        polynomial2Field = new JTextField();
        polynomial2Field.setOpaque(false);
        resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setOpaque(false);
        resultField.setEditable(false);
        topPanel.add(polynomial1Label);
        topPanel.add(polynomial1Field);
        topPanel.add(polynomial2Label);
        topPanel.add(polynomial2Field);
        topPanel.add(resultLabel);
        topPanel.add(resultField);
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(new Color(230, 216, 255));
        // Create the bottom panel with buttons
        bottomPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        addButton = new JButton("Addition");
        addButton.setBackground(new Color(228, 247, 245));
        subButton = new JButton("Subtraction");
        subButton.setBackground(new Color(228, 247, 245));
        mulButton = new JButton("Multiplication");
        mulButton.setBackground(new Color(228, 247, 245));
        divButton = new JButton("Division");
        divButton.setBackground(new Color(228, 247, 245));
        derButton = new JButton("Derivative");
        derButton.setBackground(new Color(228, 247, 245));
        intButton = new JButton("Integration");
        intButton.setBackground(new Color(228, 247, 245));
        calcButton = new JButton("Calculate");
        calcButton.setBackground(new Color(228, 247, 245));
        bottomPanel.add(addButton);
        bottomPanel.add(subButton);
        bottomPanel.add(mulButton);
        bottomPanel.add(divButton);
        bottomPanel.add(derButton);
        bottomPanel.add(intButton);
        bottomPanel.setBackground(new Color(230, 216, 255));
        add(bottomPanel, BorderLayout.CENTER);
        add(calcButton, BorderLayout.SOUTH);

        // Show the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
