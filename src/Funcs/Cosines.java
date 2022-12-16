package Funcs;

import javax.management.InvalidAttributeValueException;

public class Cosines extends Functions {

    public Cosines(double x, double e) throws InvalidAttributeValueException {
        super(x, e);
    }

    private double cosinesCalc() {
        int n = 1;
        double res = 0;
        double num;
        do {
            num = this.multi(-1, n) * this.multi(x, 2 * n);
            for (int i = 1; i <= 2 * n; i++) num = num/i;
            res = res + num;
            n++;
            System.out.println((int)num + " " + x);
        } while ( (int)(Math.abs(num)*1000000) >= (int)(e*1000000));
        System.out.println(res);
        return res;
    }

    @Override
    public double getResult() {
        return cosinesCalc();
    }
}