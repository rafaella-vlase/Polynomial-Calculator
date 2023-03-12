package org.example;

public class Monomial
{
    int degree = 0;
    double coefficient = 0;
    public Monomial(int degree, double coefficient)
    {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public int getDegree()
    {
        return degree;
    }
    public void setDegree(int degree)
    {
        this.degree = degree;
    }
    public double getCoefficient()
    {
        return coefficient;
    }
    public void setCoefficient(double coefficient)
    {
        this.coefficient = coefficient;
    }
    public Monomial addition(Monomial x, Monomial y)
    {
        return new Monomial(x.degree, x.coefficient + y.coefficient);
    }

    public Monomial subtraction(Monomial x, Monomial y)
    {
        return new Monomial(x.degree, x.coefficient - y.coefficient);
    }
    public Monomial division(Monomial x, Monomial y)
    {
        if (y.coefficient == 0)
            throw new ArithmeticException("Division by zero");
        return new Monomial(x.degree - y.degree, x.coefficient / y.coefficient);
    }
    public Monomial multiplication(Monomial x, Monomial y)
    {
        return new Monomial(x.degree + y.degree, x.coefficient * y.coefficient);
    }

    public String toString()
    {
        if (coefficient < 0)
            return coefficient + "X^" + degree;
        else
            return  "+" + coefficient + "X^" + degree;
    }
}
