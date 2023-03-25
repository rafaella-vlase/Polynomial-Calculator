package org.example;

import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        PolyCalc calculator = new PolyCalc();

        // Test the Polynomial constructor that takes a Map argument
        Map<Integer, Double> monomials = new HashMap<>();
        monomials.put(2, 2.0);
        monomials.put(0, 3.0);
        Polynomial p1 = new Polynomial(monomials);

        Map<Integer, Double> monomials1 = new HashMap<>();
        monomials1.put(2, 2.0);
        monomials1.put(0, 3.0);
        Polynomial p2 = new Polynomial(monomials);

        System.out.println("p1 = " + p1.toString()); // should print "2.0X^2 + 3.0"
        System.out.println("p2 = " + p2.toString()); // should print "2.0X^2 + 3.0"
        Polynomial sum = Polynomial.addition(p1, p2);
        System.out.println("p1 + p2 = " + sum.toString()); // should print "2.0X^3 + 3.0X^2 + 3.0X - 2.0"
        Polynomial difference = Polynomial.subtraction(p1, p2);
        System.out.println("p1 - p2 = " + difference.toString()); // should print "2.0X^3 + 2.0X^2 - 6.0X + 4.0"

        // Test the multiplication method
        Polynomial product = Polynomial.multiplication(p1, p2);
        System.out.println("p1 * p2 = " + product.toString()); // should print "2.0X^5 + 7.0X^4 + 2.0X^3 - 13.0X^2 + 2.0X - 3.0"

        // Test the derivative method
        Polynomial derivative = p1.derivative();
        System.out.println("p1' = " + derivative.toString()); // should print "6.0X^2 + 6.0X - 4.0"

        // Test the integration method
        Polynomial integral = p2.integration();
        System.out.println("∫p2 = " + integral.toString()); // should print "0.3333333333333333X^3 + X^2 - 3.0X"

    }
}