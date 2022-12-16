package Funcs;

import javax.management.InvalidAttributeValueException;

public class PowerFunc extends Functions{
    private double a;
    public PowerFunc(double x, double e, double a) throws InvalidAttributeValueException {
        super(x, e);
        setA(a);
    }

    private double sinusCalc() {
        int n = 0;
        double res = 0;
        double num;
        do {
            double buff = 1;
            for (int it = - n + 1; it <= 0; it++ ) buff = buff*(a + it);
            num = buff * this.multi(x, n)/fact(n);
            res = res + num;
            n++;
        } while (num >= e);
        return res;
    }

    @Override
    double getResult() {
        return sinusCalc();
    }

    public void setA(double a) {
        this.a = a;
    }
}
