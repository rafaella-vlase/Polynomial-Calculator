package org.example;

public class Monomial {
    int degree = 0;
    double coefficient = 0;
    public Monomial(int degree, double coefficient)
    {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public Monomial division(Monomial x)
    {
        return new Monomial(this.degree/x.degree, this.coefficient*x.coefficient);
    }
}
