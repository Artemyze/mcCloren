package Funcs;

import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class Factory {
    public Factory() {}

    public static Functions getInstance(int choice) throws InvalidAttributeValueException, IndexOutOfBoundsException {
        double x, e, a;
        Functions func = null;
        System.out.println("Ввведите х");
        x = getDouble();
        System.out.println("Введите e");
        e = getDouble();
        FuncType item = FuncType.values()[choice];
        switch (item) {
            case SINUS -> func = new Sinus(x, e);
            case ARC_TG -> {
                try {
                    func = new ArcTg(x, e);
                }catch (InvalidAttributeValueException err) {
                    System.out.println(err.getMessage());
                    func = getInstance(choice);
                }
            }
            case COSINES -> func = new Cosines(x, e);
            case EXPONENT -> func = new Exponent(e, x);
            case LOGARITHM -> func = new Logarithm(x, e);
            case POWER_FUNC -> {
                System.out.println("Введите а");
                a = getDouble();
                func = new PowerFunc(x, e, a);
            }
        }
        return func;
    }

    private static double getDouble() {
        double num = 0;
        try {
            Scanner in = new Scanner(System.in);
            num = in.nextDouble();
            in.hasNextInt();
        } catch (Exception e) {
            // TODO: 16.12.2022
        }
        return num;
    }

}
