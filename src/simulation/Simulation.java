package simulation;

import cat.Cat;
import printer.Printer;
import state.State;

import java.util.*;

public class Simulation {

    static Scanner scanner = new Scanner(System.in);

    static List<Cat> cats = Cat.makeCats(3);

    static Map<String, State> eventObjects = new HashMap<>();

    static {
        eventObjects.put("1", State.EAT);
        eventObjects.put("2", State.PLAY);
        eventObjects.put("3", State.HEAL);
        eventObjects.put("f", State.ADD);
        eventObjects.put("r", State.NEXT_DAY);
    }

    public void catMenu() {
        cats.sort(Comparator.comparing(Cat::getAverage).reversed());
        Printer.printoutAllBlocks(cats);
        while (true) {
            ProgramFunctionality();
        }
    }

    static void ProgramFunctionality() {
        String energy;
        System.out.println("\n1: Покормить\n" +
                "2: Поиграть\n" +
                "3: К ветеринару\n" +
                "f: Завести нового питомца\n" +
                "r: Следующий день");
        System.out.print("Введите номер/букву с действием: ");
        energy = scanner.nextLine();
        if (eventObjects.get(energy) != null) {
            eventObjects.get(energy).start(cats);
            Printer.printoutAllBlocks(cats);

        } else System.out.println("\n\nТаких действий не существует!\nПопробуйте снова!");
    }
}
