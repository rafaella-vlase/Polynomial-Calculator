import org.example.PolyCalc;
import org.example.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.example.Polynomial.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest
{
    @Test
    public void additionTest()
    {
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

        Map<Integer, Double> result = new HashMap<>();
        result.put(4, 1.0);
        result.put(3, 4.0);
        result.put(2, 4.0);
        result.put(0, 6.0);
        Polynomial r = new Polynomial(result);

        Assertions.assertEquals(r.toString(), addition(p1, p2).toString());
    }

    @Test
    public void substractionTest()
    {
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

        Map<Integer, Double> result = new HashMap<>();
        result.put(4, -1.0);
        result.put(3, 4.0);
        Polynomial r = new Polynomial(result);

        Assertions.assertEquals(r.toString(), subtraction(p1, p2).toString());
    }

    @Test
    public void multiplicationTest()
    {
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

        Map<Integer, Double> result = new HashMap<>();
        result.put(7, 4.0);
        result.put(6, 2.0);
        result.put(5, 8.0);
        result.put(4, 7.0);
        result.put(3, 12.0);
        result.put(2, 12.0);
        result.put(0, 9.0);
        Polynomial r = new Polynomial(result);

        Assertions.assertEquals(r.toString(), multiplication(p1, p2).toString());
    }

    @Test
    public void derivativeTest()
    {
        Map<Integer, Double> monomials = new HashMap<>();
        monomials.put(3, 4.0);
        monomials.put(2, 2.0);
        monomials.put(0, 3.0);
        Polynomial p1 = new Polynomial(monomials);

        Map<Integer, Double> result = new HashMap<>();
        result.put(2, 12.0);
        result.put(1, 4.0);
        Polynomial r = new Polynomial(result);

        Assertions.assertEquals(r.toString(), p1.derivative().toString());
    }

    @Test
    public void integrationTest()
    {
        Map<Integer, Double> monomials = new HashMap<>();
        monomials.put(3, 4.0);
        monomials.put(2, 2.0);
        monomials.put(0, 3.0);
        Polynomial p1 = new Polynomial(monomials);

        Map<Integer, Double> result = new HashMap<>();
        result.put(4, 1.0);
        result.put(3, 0.67);
        result.put(1, 3.0);
        Polynomial r = new Polynomial(result);

        Assertions.assertEquals(r.toString(), p1.integration().toString());
    }

}
