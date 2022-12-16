package Funcs;

import javax.management.InvalidAttributeValueException;

public abstract class Functions {
    protected double x, e;
    protected Functions(double x, double e) throws InvalidAttributeValueException {
        setE(e);
        setX(x);
    }
    double multi(double x, int n) {
        if(n==0) return 1;
        double result = x;
        for (int i = 1; i < n; i++) {
            //System.out.println(result + "lo");
            result = result * x;
        }
        return result;
    }

    long fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++){
            res = res * i;
        }
        return res;
    }
    public static boolean almostEqualRelative(double a, double b) {
        // находим разницу
        double diff = Math.abs(a - b);
        double maxRelDiff = 0.00001;
        a = Math.abs(a);
        b = Math.abs(b);
        // находим большее
        double largest = Math.max(b, a);

        return diff <= largest * maxRelDiff;
    }

    abstract public double getResult();

    void setX(double x) throws InvalidAttributeValueException {
        this.x = x;
    }

    void setE(double e) throws InvalidAttributeValueException {
        if (e < 0) throw new InvalidAttributeValueException("Точность не должны быть меньше 0");
        this.e = e;
    }
}
