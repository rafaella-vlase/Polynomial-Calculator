package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolyCalc extends JFrame implements ActionListener {

    private JTextField poly1Field, poly2Field, resultField;

    public PolyCalc() {
        setTitle("Polynomial Calculator");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create panel for polynomial input boxes
        JPanel polyPanel = new JPanel();
        polyPanel.setLayout(new GridLayout(2, 1));
        poly1Field = new JTextField(20);
        poly2Field = new JTextField(20);
        polyPanel.add(new JLabel("Polynomial 1: "));
        polyPanel.add(poly1Field);
        polyPanel.add(new JLabel("Polynomial 2: "));
        polyPanel.add(poly2Field);
        add(polyPanel, BorderLayout.WEST);

        // create panel for calculator buttons
        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(new GridLayout(5, 4));
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", "x", "^", "=", "d/dx", "\u222b"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            calcPanel.add(button);
        }
        add(calcPanel, BorderLayout.CENTER);

        // create panel for result display
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(new JLabel("Result: "));
        resultField = new JTextField(20);
        resultField.setEditable(false);
        resultPanel.add(resultField);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // implement calculator logic here based on button commands
    }


}

