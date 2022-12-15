import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {
    static boolean isWork = true;
    protected enum MenuItems { // перечисение выбора пользователя в меню
        EXP("",
                () ->{
                }),
        SINUS("Установить курсор на начало",
                () -> {
                }),
        COSINES("Добавить элемент после курсора",
                () -> {
                }),
        LOGARITHM("Удалить после курсора",
                () -> {
                }),
        GET_AFTER_CURSOR("Элемент после курсора",
                () -> {
                }),
        MOVE_CURSOR_RIGHT("Передвинуть курсор вправо",
                () -> {
                }),
        SWAP_VALUES_AFTER_CUR_AND_HEAD("Поменять значения элементов начала списка и следующего за курсором",
                () -> {
                }),
        SWAP_VALUES_AFTER_CUR_AND_TAIL("Поменять значения элементов конца списка и следующего за курсором",
                () -> {
                }),
        PRINT_ALL("Вывод результата",
                () -> {
                }),
        EXIT("Выход",
                () -> {
                    isWork = false;
                });
        final String description; // описание действия пункта меню
        final Runnable func;
        MenuItems(String annotation, Runnable func) {
            this.func = func;
            this.description = annotation;
        }
    }
    public Menu(){}

    /**
     * Выводит на экран меню. Пользователь вводит значение и затем вызывается соответстующая пункту меню
     * функция. Все функции и их номер берутся из перечисления данного класса {@link MenuItems}
     */
    public void execute() {// запускает вывод на экран меню пользователя
        do {
            printMenu();
            Scanner scan = new Scanner(System.in);
            int choice = MenuItems.values().length + 1;
            try {
                choice = scan.nextInt();
                MenuItems menuItem = MenuItems.values()[choice];
                menuItem.func.run();
            } catch (NoSuchElementException errNoSuchEl) {
                System.out.println("Вы ввели не номер");
            } catch (IndexOutOfBoundsException errIndexOutOfBounds) {
                System.out.println("Неправильный ввод, нет такого пункта в меню.");
            } catch (NullPointerException nullPointerException){
                System.out.println("Введите что-нибудь в список");
            } finally {
                scan.nextLine();
            }
        } while (isWork);
    }
    protected void printMenu(){
        // проходимся по всему enum и выводим описание каждого пункта меню
        // так же выодится значение пункта, по которому пользователь может выбрать соответствующее действие меню
        IntStream.range(0, MenuItems.values().length)
                .forEach(i -> {
                    MenuItems menuItem = MenuItems.values()[i];
                    System.out.println(i + ". " + menuItem.description);
                });
        System.out.println("Введите номер пункта меню: ");
    }

    public static class InputUserLine {
        private String text;

        public InputUserLine(InputStream stream) throws IllegalStateException{
            Scanner in = new Scanner(stream);
            try {
                this.text = in.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Не введено значение");
                text = new InputUserLine(stream).getText();
            }
        }

        public String getText() {
            return text;
        }
    }

    public static class InputUserInt {
        private int intNumber;
        private InputStream stream;

        public InputUserInt(InputStream stream) throws IllegalStateException{
            Scanner in = new Scanner(stream);
            try {
                this.intNumber = in.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                intNumber = new InputUserInt(stream).getIntNumber();
            }
        }
        public int getIntNumber() {
            return intNumber;
        }

    }
}
