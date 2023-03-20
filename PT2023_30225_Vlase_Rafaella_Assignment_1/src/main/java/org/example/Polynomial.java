package org.example;
import java.util.Map;
import java.util.TreeMap;
public class Polynomial
{
    private static Map<Integer, Monomial> monomials;
    public Polynomial()
    {
        monomials = new TreeMap<>();
    }
    public Polynomial(Map<Integer, Monomial> monomials)
    {
        this.monomials = new TreeMap<>(monomials);
    }

    public void addMonomial(Monomial monomial)
    {
        int degree = monomial.getDegree();
        if(monomials.containsKey(degree))
        {
            Monomial existing = monomials.get(degree);
            Monomial newMonomial = existing.addition(existing, monomial);
            monomials.put(degree, newMonomial);
        }
        else
            monomials.put(degree, monomial);
    }
    public static Polynomial addition(Polynomial x)
    {
        Polynomial y = new Polynomial();
        for(int degree : monomials.keySet())
        {
            Monomial monomial = monomials.get(degree);
            y.addMonomial(monomial);
        }

        for(int degree : x.monomials.keySet())
        {
            Monomial monomial = x.monomials.get(degree);
            y.addMonomial(monomial);
        }
        return y;
    }

}
