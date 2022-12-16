package Funcs;

import javax.management.InvalidAttributeValueException;

public class PowerFunc extends Functions{
    private double a;
    public PowerFunc(double x, double e, double a) throws InvalidAttributeValueException {
        super(x, e);
        setA(a);
    }

    private double powerFuncCalc() {
        int n = 0;
        double res = 0;
        double num;
        do {
            double buff = 1;
            for (int it = - n + 1; it <= 0; it++ ) buff = buff * (a + it);
            num = buff * this.multi(x, n);
            for (int i = 1; i <= n; i++) num = num/i;
            res = res + num;
            n++;
        } while ((int)(Math.abs(num)*1000000) >= (int)(e*1000000));
        return res;
    }

    @Override
    public double getResult() {
        return powerFuncCalc();
    }


    void setX(double x) throws InvalidAttributeValueException {
        if (Math.abs(x) >= 1) throw new InvalidAttributeValueException("Для этой функции |х| должно быть меньше 1");
        super.setX(x);
    }

    public void setA(double a) {
        this.a = a;
    }
}
