

import org.example.Polynomial;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperationsTest {

    @Test
    public void testPolynomialParsing() {
        Polynomial p = new Polynomial("3x^2 - 2x + 1");
        assertEquals("3x^2 - 2x + 1", p.toString());
    }

    @Test
    public void testAddition() {
        Polynomial p1 = new Polynomial("2x^2 - 3x + 1");
        Polynomial p2 = new Polynomial("-4x^2 + 5x - 2");
        p1.polynomial2 = p2.polynomial1;
        p1.addition();
        assertEquals("-2x^2 + 2x - 1", p1.toString());
    }

    @Test
    public void testSubtraction() {
        Polynomial p1 = new Polynomial("2x^2 - 3x + 1");
        Polynomial p2 = new Polynomial("-4x^2 + 5x - 2");
        p1.polynomial2 = p2.polynomial1;
        p1.subtraction();
        assertEquals("6x^2 - 8x + 3", p1.toString());
    }

    @Test
    public void testMultiplication() {
        Polynomial p1 = new Polynomial("2x^2 - 3x + 1");
        Polynomial p2 = new Polynomial("-4x + 2");
        p1.polynomial2 = p2.polynomial1;
        p1.multiplication();
        assertEquals("-8x^3 + 16x^2 - 8x", p1.toString());
    }

    @Test
    public void testDerivative() {
        Polynomial p1 = new Polynomial("3x^2 - 2x + 1");
        p1.derivative(p1.polynomial1);
        assertEquals("6x - 2", p1.toString());
    }

    @Test
    public void testIntegration() {
        Polynomial p1 = new Polynomial("2x^2 - 3x + 1");
        p1.integration();
        assertEquals("0.667x^3 - 1.5x^2 + x", p1.toString());
    }

}
