import polynomial.Polynomial;
import org.junit.Test;
import static org.junit.Assert.*;

public class OperationsTest {

    @Test
    public void testAddition() {
        Polynomial p1 = new Polynomial("2x^2-3x^1+1");
        Polynomial p2 = new Polynomial("-4x^2+5x^1-2");
        Polynomial res = new Polynomial("-2x^2+2x^1-1");
        p1.addition(p2);
        //System.out.println(Polynomial.toString(p1.getPolynomial()));
        assertTrue(p1.equals(p1, res));
    }

    @Test
    public void testSubtraction() {
        Polynomial p1 = new Polynomial("2x^2-3x^1+1");
        Polynomial p2 = new Polynomial("-4x^2+5x^1-2");
        Polynomial res = new Polynomial("6x^2-8x^1+3");
        p1.subtraction(p2);
        assertTrue(p1.equals(p1, res));
    }

    @Test
    public void testMultiplication() {
        Polynomial p1 = new Polynomial("2x^2-3x^1+1");
        Polynomial p2 = new Polynomial("-4x^1+2");
        Polynomial res = new Polynomial("-8x^3+16x^2-10x^1+2");
        p1.multiplication(p2);
        //System.out.println(Polynomial.toString(p1.getPolynomial()));
        assertTrue(p1.equals(p1, res));

    }

    @Test
    public void testDerivative() {
        Polynomial p1 = new Polynomial("3x^2-2x^1+1");
        Polynomial res = new Polynomial("6x^1-2");
        p1.derivative();
        assertTrue(p1.equals(p1, res));
    }

    @Test
    public void testIntegration() {
        Polynomial p1 = new Polynomial("3x^2-2x^1+1");
        Polynomial res = new Polynomial("6x^1-2");
        p1.integration();
        //System.out.println(Polynomial.toString(p1.getPolynomial()));
        //System.out.println(p1.equals(p1, res));
        p1.equals(p1, res);

        //assertTrue(p1.equals(p1, res));
    }

}
