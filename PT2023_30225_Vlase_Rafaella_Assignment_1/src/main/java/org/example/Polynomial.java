package org.example;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Map<Integer, Double> monomials;

    public Polynomial() {
        monomials = new TreeMap<>();
    }

    public Polynomial(Map<Integer, Double> monomials) {
        this.monomials = new TreeMap<>(monomials);
    }

    public Polynomial(String polynomial)
    {
        monomials = new TreeMap<>();
        Pattern pattern = Pattern.compile("([+\\-]?[0-9]*\\.?[0-9]*X\\^([0-9]+))([+\\-][0-9]*\\.?[0-9]*X\\^[0-9]+)*");
        Matcher matcher = pattern.matcher(polynomial);
        while (matcher.find())
        {
            Double coeff = Double.parseDouble(matcher.group(1));
            String degreeStr = matcher.group(3);
            if (degreeStr != null) {
                int degree = Integer.parseInt(degreeStr);
                addDouble(degree, coeff);
            } else {
                addDouble(0, coeff);
            }
        }
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

    public Polynomial derivative() {
        Polynomial result = new Polynomial();
        for (int degree : monomials.keySet()) {
            if (degree > 0) {
                Double coeff = monomials.get(degree);
                Double newCoeff = coeff * degree;
                result.addDouble(degree - 1, newCoeff);
            }
        }
        return result;
    }

    public Polynomial integration() {
        Polynomial result = new Polynomial();
        for (int degree : monomials.keySet()) {
            Double coeff = monomials.get(degree);
            Double newCoeff = coeff / (degree + 1);
            result.addDouble(degree + 1, newCoeff);
        }
        return result;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Double> sortedMonomials = new TreeMap<>(monomials);

        NavigableSet<Integer> degrees = sortedMonomials.descendingKeySet();

        DecimalFormat df = new DecimalFormat("#.##");
        for (int degree : degrees) {
            Double coeff = sortedMonomials.get(degree);
            if (coeff != 0) {
                if (coeff < 0) {
                    sb.append(" - ");
                    coeff = -coeff;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (coeff != 1 || degree == 0) {
                    sb.append(df.format(coeff));
                }
                if (degree > 0) {
                    sb.append("X");
                    if (degree > 1) {
                        sb.append("^").append(degree);
                    }
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }
}