package Funcs;

import javax.management.InvalidAttributeValueException;

abstract class Functions {
    protected double x, e;
    protected Functions(double x, double e) throws InvalidAttributeValueException {
        setE(e);
        setX(x);
    }
    double multi(double x, int n) {
        if(n==0) return 1;
        double result = x;
        for (int i = 1; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++){
            res = res * i;
        }
        return res;
    }

    abstract double getResult();

    void setX(double x) {
        this.x = x;
        return x;
    }

    void setE(double e) throws InvalidAttributeValueException {
        if (e < 0) throw new InvalidAttributeValueException("Точность не должны быть меньше 0");
        this.e = e;
    }
}
