package Funcs;

import javax.management.InvalidAttributeValueException;

public class Sinus extends Functions {

    public Sinus(double x, double e) throws InvalidAttributeValueException {
        super(x, e);
    }

    private double sinusCalc() {
        int n = 1;
        double res = 0;
        double num;
        do {
            num = this.multi(-1, n + 1) * this.multi(x, 2 * n - 1)/fact(2 * n - 1);
            res = res + num;
            n++;
        } while (num >= e);
        return res;
    }
    @Override
    public double getResult() {
        return sinusCalc();
    }
}
