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
            for (int i = 1; i <= n; i++) num = num/i;
            System.out.println(num + " e" + res);
            n++;
            res = res + num;
        } while ((int)(Math.abs(num)*1000000) >= (int)(e*1000000));
        return res;
    }

    @Override
    public double getResult() {
        return exponent();
    }
}
