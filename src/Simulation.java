import java.util.*;

public class Simulation {

    static Scanner scanner = new Scanner(System.in);

    static List<Cat> cats = Cat.makeCats(3);

    static Map<String,State> eventObjects = new HashMap<>();
    static {
        eventObjects.put("1", State.EAT);
        eventObjects.put("2", State.PLAY);
        eventObjects.put("3", State.HEAL);
        eventObjects.put("a", State.ADD);
        eventObjects.put("n", State.NEXT_DAY);
    }

    public void catMenu(){
        cats.sort(Comparator.comparing(Cat::getAverage).reversed());
        Printer.print(cats);
    }
}
