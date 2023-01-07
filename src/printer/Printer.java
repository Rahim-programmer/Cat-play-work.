package printer;

import cat.Cat;

import java.util.List;

public class Printer {
    private static int j;

    public static final void printoutAllBlocks(List<Cat> cats) {
        j = 0;
        topBlockPrintout();
        cats.forEach(Printer::printoutOfСat);
        printBottomMenu();
    }
    private static void topBlockPrintout() {

        System.out.println(String.format("\n\n%1$3.3s | %1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-7.7s | %1$-15.15s |", "----------------"));
        System.out.println(String.format("%3.3s | %10.10s | %-10.10s | %-10.10s | %-10.10s | %-7.7s | %-15.15s |",
                "#", "Имя", "Возраст", "Здоровье", "Настроение", "Сытость", "Средний уровень"));
        System.out.println(String.format("%1$3.3s | %1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-7.7s | %1$-15.15s |", "----------------"));

    }

    private static void printBottomMenu() {
        System.out.println(String.format("%1$3.3s | %1$10.10s | %1$-10.10s | %1$-10.10s | %1$-10.10s | %1$-7.7s | %1$-15.15s |", "--------------"));
    }

    private static void printoutOfСat(Cat cat) {
        j++;
        System.out.println(String.format("%3.3s | %10.10s |     %-4.4s   |     %-4.4s   |     %-4.4s   |   %-3.3s   |        %-5.5s    |",
                j, (cat.isPlayer() ? "* " : "") + cat.getName(), cat.getAge(), cat.getHealth(), cat.getMood(), cat.getSatiety(), cat.getAverage()));
    }
}


