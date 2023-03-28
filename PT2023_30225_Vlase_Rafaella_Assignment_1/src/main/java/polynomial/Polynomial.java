package polynomial;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    public TreeMap<Integer, Double> polynomial1;
    public TreeMap<Integer, Double> polynomial2;
    public TreeMap<Integer, Double> result;

    public Polynomial() {
        this.polynomial1 = new TreeMap<>();
        this.polynomial2 = new TreeMap<>();
        this.result = new TreeMap<>();
    }

    public Polynomial(TreeMap<Integer, Double> polynomial) {
        this.polynomial1 = polynomial;
        this.polynomial2 = new TreeMap<>();
        this.result = new TreeMap<>();
    }

    public Polynomial(String polynomialString) {
        this.polynomial1 = new TreeMap<>();
        this.polynomial2 = new TreeMap<>();
        this.result = new TreeMap<>();
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
            if (result.containsKey(degree)) {
                coeff += result.get(degree);
            }
            result.put(degree, coeff);
        }
    }

    public void addition() {
        for (int degree : polynomial1.keySet()) {
            double coeff = polynomial1.get(degree);
            result.put(degree, coeff);
        }
        for (int degree : polynomial2.keySet()) {
            double coefficient = polynomial2.get(degree);
            if (result.containsKey(degree)) {
                double currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient + coefficient);
            } else {
                result.put(degree, coefficient);
            }
        }
    }

    public void subtraction() {
        for (int degree : polynomial1.keySet()) {
            double coeff = polynomial1.get(degree);
            result.put(degree, coeff);
        }
        for (int degree : polynomial2.keySet()) {
            double coefficient = polynomial2.get(degree);
            if (result.containsKey(degree)) {
                double currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient - coefficient);
            } else {
                result.put(degree, -coefficient);
            }
        }
    }

    public void multiplication() {
        for (int degree1 : polynomial1.keySet()) {
            for (int degree2 : polynomial2.keySet()) {
                double coefficient1 = polynomial1.get(degree1);
                double coefficient2 = polynomial2.get(degree2);
                int degreeResult = degree1 + degree2;
                double coefficientResult = coefficient1 * coefficient2;
                if (result.containsKey(degreeResult)) {
                    double currentCoefficient = result.get(degreeResult);
                    result.put(degreeResult, currentCoefficient + coefficientResult);
                } else {
                    result.put(degreeResult, coefficientResult);
                }
            }
        }
    }

    public void derivative(TreeMap<Integer, Double> polynomial) {
        for (int degree : polynomial.keySet()) {
            double coefficient = polynomial.get(degree);
            if (degree > 0) {
                result.put(degree - 1, degree * coefficient);
            }
        }
    }

    public void integration() {
        result = new TreeMap<>();
        for (int degree : polynomial1.keySet()) {
            double coefficient = polynomial1.get(degree);
            result.put(degree + 1, coefficient / (degree + 1));
        }
        result.put(0, 0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.###");

        for (Map.Entry<Integer, Double> term : result.entrySet()) {
            int degree = term.getKey();
            double coeff = term.getValue();
            if (sb.length() > 0 && coeff > 0) {
                sb.append(" + ");
            }
            if (coeff < 0) {
                sb.append("- ");
                coeff = -coeff;
            }
            if (coeff != 1 || degree == 0) {
                sb.append(df.format(coeff));
            }
            if (degree > 0) {
                sb.append("x");
                if (degree > 1) {
                    sb.append("^").append(degree);
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}