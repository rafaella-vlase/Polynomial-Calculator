/*package org.example;

import java.util.HashMap;
import java.util.Map;

public class Operations {
    public static void main(String[] args) {

        Map<Integer, Double> monomials = new HashMap<>();
        monomials.put(3, 4.0);
        monomials.put(2, 2.0);
        monomials.put(0, 3.0);
        Polynomial p1 = new Polynomial(monomials);

        Map<Integer, Double> monomials1 = new HashMap<>();
        monomials1.put(4, 1.0);
        monomials1.put(2, 2.0);
        monomials1.put(0, 3.0);
        Polynomial p2 = new Polynomial(monomials1);

        System.out.println("p1 = " + p1.toString());
        System.out.println("p2 = " + p2.toString());

        Polynomial sum = Polynomial.addition(p1, p2);
        System.out.println("p1 + p2 = " + sum.toString());
        Polynomial difference = Polynomial.subtraction(p1, p2);
        System.out.println("p1 - p2 = " + difference.toString());

        Polynomial product = Polynomial.multiplication(p1, p2);
        System.out.println("p1 * p2 = " + product.toString());

        //Polynomial derivative = p1.derivative(Polynomial.parse(p1));
        //System.out.println("p1' = " + derivative.toString());

        //Polynomial integral = p1.integration(Polynomial.parse(p1));
        //System.out.println("∫p1 = " + integral.toStringIntegration());
    }
}
*/