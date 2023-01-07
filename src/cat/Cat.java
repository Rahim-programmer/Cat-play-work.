package cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat {
    private static final Random random = new Random();
    private static final List<String> cat = new ArrayList<>();
    private static final List<String> names = List.of("Том", "Амели", "Наоми", "Маркиза", "Изольда", "Пират", "Гудини", "Зорро", "Саймон", "Альбус");
    private String name;
    private int age;
    private int satiety;
    private int mood;
    private int health;
    private int average;
    private boolean player;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public void nextDays() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        satiety = random.nextInt(50) + 31;
        mood = random.nextInt(50) + 31;
        health = random.nextInt(50) + 31;
        average = (satiety + mood + health) / 3;
        player = false;
    }

    public static List<Cat> makeCats(int amount) {
        return Stream.generate(Cat::new).limit(amount).collect(Collectors.toList());
    }

    public Cat() {
        name = getRandomName(names.get(random.nextInt(names.size())));
        age = random.nextInt(15) + 4;
        satiety = random.nextInt(41) + 40;
        mood = random.nextInt(31) + 51;
        health = random.nextInt(21) + 60;
        average = (satiety + mood + health) / 3;
        player = false;
    }

    private String getRandomName(String name) {
        if (cat.contains(name)) {
            return getRandomName(names.get(random.nextInt(names.size())));
        }
        cat.add(name);
        return name;
    }


    public void playWithTheCat(int number){
        upSatiety(number);
        upMood(number);
        characteristicChange();
    }
    public void HealTheСat(List<Integer> number) {
        addHealth(number.get(0));
        downMood(number.get(1));
        downSatiety(number.get(1));
        characteristicChange();
    }

    public void playWithTheСat(List<Integer> number) {
        addHealth(number.get(0));
        upMood(number.get(0));
        downSatiety(number.get(1));
        characteristicChange();
    }


    public void addHealth(int health) {
        setHealth(Math.min(Math.max(getHealth() + health, 0), 100));
    }

    public void downHealth(int health) {
        setHealth(Math.max(getHealth() - health, 0));
    }

    public void upMood(int mood) {
        setMood(Math.min(Math.max(getMood() + mood, 0), 100));
    }

    public void downMood(int mood) {
        setMood(Math.max(getMood() - mood, 0));
    }

    public void upSatiety(int satiety) {
        setSatiety(Math.min(Math.max(getSatiety() + satiety, 0), 100));
    }

    public void downSatiety(int satiety) {
        setSatiety(Math.max(getSatiety() - satiety, 0));
    }
    public void characteristicChange() {
        average = (satiety + mood + health) / 3;
    }

}

