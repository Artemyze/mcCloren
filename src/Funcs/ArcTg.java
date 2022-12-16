package Funcs;

import javax.management.InvalidAttributeValueException;

public class ArcTg extends Functions {
    public ArcTg(double x, double e) throws InvalidAttributeValueException {
        super(x, e);
    }

    private double sinusCalc() {
        int n = 0;
        double res = 0;
        double num;
        do {
            num = multi(-1, n) * multi(x, 2 * n + 1)/(2 * n + 1);
            res = res + num;
            System.out.println(x + "sd" + res);
            n++;
        } while ((int)(Math.abs(num)*1000000) >= (int)(e*1000000));
        return res;
    }

    @Override
    void setX(double x) throws InvalidAttributeValueException {
        if (Math.abs(x) > 1) throw new InvalidAttributeValueException(
                "Для этой функции |х| должно быть меньше или равно 1.");
        super.setX(x);
    }

    @Override
    public double getResult() {
        return sinusCalc();
    }
}
