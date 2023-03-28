package polyCalc;

import polynomial.Polynomial;

import javax.swing.*;
import java.awt.*;

public class PolyCalc extends JFrame {

    private final JTextField polynomial1Field;
    private final JTextField polynomial2Field;
    private final JTextField resultField;
    private Polynomial poly1, poly2, result;


    public PolyCalc() {
        // Create and configure the window
        super("Polynomial Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(true);

        // Create the top panel with labels and text fields
        JPanel topPanel = new JPanel(new GridLayout(3, 2));
        JLabel polynomial1Label = new JLabel("Polynomial 1:");
        polynomial1Label.setForeground(new Color(255, 255, 255));
        polynomial1Field = new JTextField();
        polynomial1Field.setForeground(Color.WHITE);
        polynomial1Field.setOpaque(false);
        JLabel polynomial2Label = new JLabel("Polynomial 2:");
        polynomial2Label.setForeground(new Color(255, 255, 255));
        polynomial2Field = new JTextField();
        polynomial2Field.setForeground(Color.WHITE);
        polynomial2Field.setOpaque(false);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setForeground(new Color(255, 255, 255));
        resultField = new JTextField();
        resultField.setOpaque(false);
        resultField.setEditable(false);
        resultField.setForeground(new Color(255, 255, 255));
        topPanel.add(polynomial1Label);
        topPanel.add(polynomial1Field);
        topPanel.add(polynomial2Label);
        topPanel.add(polynomial2Field);
        topPanel.add(resultLabel);
        topPanel.add(resultField);
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(new Color(99, 39, 99));
        JPanel bottomPanel = new JPanel(new GridLayout(2, 3, 5, 5));

        poly1 = new Polynomial();
        poly2 = new Polynomial();
        JButton addButton = new JButton("Addition");
        addButton.setBackground(new Color(154, 48, 154));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setActionCommand("add");

        JButton subButton = new JButton("Subtraction");
        subButton.setBackground(new Color(255, 222, 252));
        subButton.setForeground(new Color(0, 0, 0));
        subButton.setActionCommand("sub");

        JButton mulButton = new JButton("Multiplication");
        mulButton.setBackground(new Color(154, 48, 154));
        mulButton.setForeground(new Color(255, 255, 255));
        mulButton.setActionCommand("mul");

        JButton divButton = new JButton("Division");
        divButton.setBackground(new Color(154, 48, 154));
        divButton.setForeground(new Color(255, 255, 255));
        JButton derButton = new JButton("Derivative");
        derButton.setBackground(new Color(255, 222, 252));
        derButton.setForeground(new Color(0, 0, 0));
        derButton.setActionCommand("der");

        JButton intButton = new JButton("Integration");
        intButton.setBackground(new Color(154, 48, 154));
        intButton.setForeground(new Color(255, 255, 255));
        intButton.setActionCommand("int");


        addButton.addActionListener(e -> {
            poly1 = new Polynomial(polynomial1Field.getText());
            poly2 = new Polynomial(polynomial2Field.getText());
            poly1.polynomial2 = poly2.polynomial1;
            poly1.addition();
            resultField.setText(poly1.toString());
        });


        subButton.addActionListener(e -> {
            poly1 = new Polynomial(polynomial1Field.getText());
            poly2 = new Polynomial(polynomial2Field.getText());
            poly1.polynomial2 = poly2.polynomial1;
            poly1.subtraction();
            resultField.setText(poly1.toString());
        });

        mulButton.addActionListener(e -> {
            poly1 = new Polynomial(polynomial1Field.getText());
            poly2 = new Polynomial(polynomial2Field.getText());
            poly1.polynomial2 = poly2.polynomial1;
            poly1.multiplication();
            resultField.setText(poly1.toString());
        });

        derButton.addActionListener(e -> {
            Polynomial poly = new Polynomial(polynomial1Field.getText());
            poly.derivative(poly.polynomial1);
            resultField.setText(poly.toString());
        });

        intButton.addActionListener(e -> {
            Polynomial poly = new Polynomial(polynomial1Field.getText());
            poly.integration();
            resultField.setText(poly.toString());
        });

        bottomPanel.add(addButton);
        bottomPanel.add(subButton);
        bottomPanel.add(mulButton);
        bottomPanel.add(divButton);
        bottomPanel.add(derButton);
        bottomPanel.add(intButton);
        bottomPanel.setBackground(new Color(99, 39, 99));
        add(bottomPanel, BorderLayout.CENTER);

        // Show the window
        pack();
        setSize(600, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}