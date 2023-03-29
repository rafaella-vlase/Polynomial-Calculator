package polynomial;

import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public TreeMap<Integer, Double> polynomial;

    public TreeMap<Integer, Double> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial(TreeMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }

    public Polynomial() {
        this.polynomial = new TreeMap<>();
    }

    public Polynomial(TreeMap<Integer, Double> polynomial) {
        this.polynomial = polynomial;
    }

    public Polynomial(String polynomialString) {
        this.polynomial = new TreeMap<>();
        Pattern pattern = Pattern.compile("([+\\-]?\\d*)(x(?:\\^(\\d+))?)?");
        Matcher matcher = pattern.matcher(polynomialString);
        while (matcher.find()) {
            String coeffString = matcher.group(1);
            String degreeString = matcher.group(3);
            double coeff = 0;
            int degree = 0;
            if (!coeffString.isEmpty()) {
                coeff = Double.parseDouble(coeffString);
            }
            if (degreeString != null) {
                degree = Integer.parseInt(degreeString);
            }
            if (polynomial.containsKey(degree)) {
                coeff += polynomial.get(degree);
            }
            polynomial.put(degree, coeff);
        }
    }

    public void addition(Polynomial p) {
        for (int degree : p.polynomial.keySet()) {
            double coeff = p.polynomial.get(degree);
            if (polynomial.containsKey(degree)) {
                double currentCoefficient = polynomial.get(degree);
                polynomial.put(degree, currentCoefficient + coeff);
            } else {
                polynomial.put(degree, coeff);
            }
        }
    }

    public void subtraction(Polynomial p) {
        for (int degree : p.polynomial.keySet()) {
            double coeff = p.polynomial.get(degree);
            if (polynomial.containsKey(degree)) {
                double currentCoefficient = polynomial.get(degree);
                polynomial.put(degree, currentCoefficient - coeff);
            } else {
                polynomial.put(degree, -coeff);
            }
        }
    }

    public void multiplication(Polynomial p) {
        Polynomial result = new Polynomial();
        for (int degree1 : this.polynomial.keySet()) {
            for (int degree2 : p.polynomial.keySet()) {
                int degree = degree1 + degree2;
                double coeff = this.polynomial.get(degree1) * p.polynomial.get(degree2);
                if (result.polynomial.containsKey(degree)) {
                    coeff += result.polynomial.get(degree);
                }
                result.polynomial.put(degree, coeff);
            }
        }
        this.setPolynomial(result.getPolynomial());
    }

    public void derivative() {
        Polynomial result = new Polynomial();
        for (int degree : this.polynomial.keySet()) {
            if (degree != 0) {
                double coeff = this.polynomial.get(degree) * degree;
                result.polynomial.put(degree - 1, coeff);
            }
        }
        this.setPolynomial(result.getPolynomial());
    }

    public void integration() {
        Polynomial result = new Polynomial();
        for (int degree : this.polynomial.keySet()) {
            double coeff = this.polynomial.get(degree) / (degree + 1);
            result.polynomial.put(degree + 1, coeff);
        }

        //this.setPolynomial(result.getPolynomial());
        //System.out.println(Polynomial.toString(this.getPolynomial()));
    }

    public static String toString(TreeMap<Integer, Double> polynomial) {
        DecimalFormat df = new DecimalFormat("#.##");
        StringBuilder sb = new StringBuilder();
        boolean firstTerm = true;
        for (int degree : polynomial.descendingKeySet()) {
            double coeff = polynomial.get(degree);
            if (coeff != 0) {
                if (firstTerm) {
                    if (coeff < 0) {
                        sb.append("-");
                        coeff = -coeff;
                    }
                    firstTerm = false;
                } else {
                    sb.append(coeff < 0 ? " - " : " + ");
                    coeff = Math.abs(coeff);
                }
                if (degree == 0) {
                    sb.append(df.format(coeff));
                } else {
                    sb.append(df.format(coeff)).append("x");
                    if (degree > 1) {
                        sb.append("^").append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }

    public boolean equals(Polynomial p1, Polynomial p2) {
        TreeMap<Integer, Double> polynomial1 = p1.polynomial;
        TreeMap<Integer, Double> polynomial2 = p2.polynomial;
        if (polynomial1.size() != polynomial2.size()) {
            return false;
        }
        //System.out.println(Polynomial.toString(p1.getPolynomial()));
        //System.out.println(Polynomial.toString(p2.getPolynomial()));

        for (int degree : polynomial1.keySet()) {
            if (!polynomial2.containsKey(degree) || !polynomial1.get(degree).equals(polynomial2.get(degree))) {
                return false;
            }
        }
        return true;
    }

}