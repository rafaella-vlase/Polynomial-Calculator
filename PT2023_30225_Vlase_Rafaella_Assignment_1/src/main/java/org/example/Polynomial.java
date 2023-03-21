package org.example;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private Map<Integer, Double> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    public Polynomial(Map<Integer, Double> monomials) {
        this.monomials = new TreeMap<>(monomials);
    }

    public void addDouble(int degree, Double monomial) {
        if (monomials.containsKey(degree)) {
            Double existing = monomials.get(degree);
            Double newDouble = existing + monomial;
            monomials.put(degree, newDouble);
        } else {
            monomials.put(degree, monomial);
        }
    }

    public static Polynomial addition(Polynomial x, Polynomial y) {
        Polynomial result = new Polynomial();
        for (int degree : x.monomials.keySet()) {
            Double monomial = x.monomials.get(degree);
            result.addDouble(degree, monomial);
        }

        for (int degree : y.monomials.keySet()) {
            Double monomial = y.monomials.get(degree);
            result.addDouble(degree, monomial);
        }
        return result;
    }

    public static Polynomial subtraction(Polynomial x, Polynomial y) {
        Polynomial result = new Polynomial();
        for (int degree : x.monomials.keySet()) {
            Double monomial = x.monomials.get(degree);
            result.addDouble(degree, monomial);
        }

        for (int degree : y.monomials.keySet()) {
            Double monomial = y.monomials.get(degree);
            result.addDouble(degree, -monomial);
        }
        return result;
    }

    public static Polynomial multiplication(Polynomial x, Polynomial y) {
        Polynomial result = new Polynomial();
        for (int degX : x.monomials.keySet()) {
            Double coeffX = x.monomials.get(degX);
            for (int degY : y.monomials.keySet()) {
                Double coeffY = y.monomials.get(degY);
                int deg = degX + degY;
                Double coeff = coeffX * coeffY;
                result.addDouble(deg, coeff);
            }
        }
        return result;
    }


}