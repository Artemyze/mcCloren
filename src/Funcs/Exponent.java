package Funcs;

import javax.management.InvalidAttributeValueException;

public class Exponent extends Functions{
    public Exponent(double e, double x) throws InvalidAttributeValueException {
        super(x, e);
    }
    private double exponent() {
        double res = 0;
        double num;
        int n = 0;
        do {
            num = multi(this.x, n);
            n++;
            res = res + num;
        } while (num < e);
        return res;
    }

    @Override
    public double getResult() {
        return exponent();
    }
}
