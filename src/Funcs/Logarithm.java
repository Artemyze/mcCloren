package Funcs;

import javax.management.InvalidAttributeValueException;

public class Logarithm extends Functions{

    public Logarithm(double x, double e) throws InvalidAttributeValueException {
        super(x, e);
    }

    private double logarithmCalc() {
        int n = 1;
        double res = 0;
        double num;
        do {
            num = this.multi(-1, n + 1) * this.multi(x, n);
            for (int i = 1; i <= n; i++) num = num/i;
            res = res + num;
            n++;
        } while ((int)(Math.abs(num)*1000000) >= (int)(e*1000000));
        return res;
    }

    @Override
    void setX(double x) throws InvalidAttributeValueException {
        if (x <= 1 && x > -1) throw new InvalidAttributeValueException(
                "Для этой функции х должно быть меньше или равно 1. И больше -1.");
        super.setX(x);
    }

    @Override
    public double getResult() {
        return logarithmCalc();
    }
}
