import Funcs.Factory;
import Funcs.FuncType;
import Funcs.Functions;

import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isWork = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    0 - ряд макклорена для arctan(x),
                    1 - для cos(x),
                    2 - для sin(x),
                    3 - для e^x,
                    4 - ln(x+1),
                    5 - (1+x)^a
                    6 - выход
                    """);
            int choice;
            if (scanner.hasNextInt()) choice = scanner.nextInt();
            else continue;
            if (choice < FuncType.values().length) {
                try {
                    System.out.println(Factory.getInstance(choice).getResult());
                } catch (InvalidAttributeValueException err) {
                    System.out.println(err.getMessage());
                }
            } else if (choice == 6) {
                isWork = false;
            }
        } while (isWork);
    }
}