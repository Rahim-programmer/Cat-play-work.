package state;

import event.Event;
import cat.Cat;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public enum State implements Event {
    EAT("Кормить кота") {
        @Override
        public void start(List<Cat> cats) {
            Cat cat = cats.get(getNumberOfCats(cats));
            if (!cat.isPlayer()) {
                cat.playWithTheCat(getStepOfChanging(cat).get(0));
                System.out.printf("\nВы покормили кота %s, возраст которого - %s\n", cat.getName(), cat.getAge());
                cat.setPlayer(true);
            }else {
                System.out.println("Кот уже наелся и не хочет есть\n");
                cat.setPlayer(false);
            }
        }
    },
    PLAY("Играть с котом") {
        @Override
        public void start(List<Cat> cats) {
            Cat cat = cats.get(getNumberOfCats(cats));
            if (!cat.isPlayer()) {
                cat.playWithTheСat(getStepOfChanging(cat));
                System.out.printf("\nВы поиграли с котом %s, возраст которого - %s", cat.getName(), cat.getAge());
                cat.setPlayer(true);
            }else {
                System.out.println("Кот уже устал\n");
                cat.setPlayer(false);
            }
        }
    },
    HEAL("Вылечить кота") {
        @Override
        public void start(List<Cat> cats) {
            Cat cat = cats.get(getNumberOfCats(cats));
            if (!cat.isPlayer()) {
                cat.HealTheСat(getStepOfChanging(cat));
                System.out.printf("\nВы отвезли к ветеринару кота %s, возраст которого - %s\n", cat.getName(), cat.getAge());
                cat.setPlayer(true);
            }else {
                System.out.println("Кот уже устал и он хочет спать\n");
                cat.setPlayer(false);
            }
        }
    },


    ADD("Добавить кота") {
        @Override
        public void start(List<Cat> cats) {
            String newName;
            int newAge;
            System.out.print("Хотите завести нового кота в ручную? (Y/N): ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Замечательно!");
                while (true) {
                    try {
                        System.out.print("Введите имя кота:");
                        newName = checkName(scanner.nextLine());
                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                }
                while (true) {
                    try {
                        System.out.print("Введите возраст кота:");
                        newAge = tryParseAge(scanner.nextLine());
                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.println(e.getMessage());
                        continue;
                    } catch (Exception e) {
                        System.out.println("Введите числовое значение");
                        continue;
                    }
                    if (newAge > 18) {
                        System.out.println("Неправильный возраст кота. Исследование показывает, что коты живут до 18 лет!");
                        continue;
                    } else if (newAge < 1) {
                        System.out.println("Неправильный возраст кота. Этот кот еще не родился!");
                        continue;
                    }
                    break;
                }
                cats.add(new Cat(newName, newAge));
                cats.sort(Comparator.comparing(Cat::getAverage).reversed());
                System.out.println("Ураа мы завели нового кота!");
            } else {
                System.out.println("Вы завели нового случайного кота");
                cats.add(new Cat());
                cats.sort(Comparator.comparing(Cat::getAverage).reversed());
            }
        }
    },


    NEXT_DAY("Следующий день") {
        @Override
        public void start(List<Cat> cats) {
            cats.forEach(Cat::nextDays);
        }
    };

    private String value;
    static final Scanner scanner = new Scanner(System.in);

    private static final Random random = new Random();

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static List<Integer> getStepOfChanging(Cat cat) {
        if (cat.getAge() < 6) {
            return List.of(7, 3);
        } else if (cat.getAge() < 11) {
            return List.of(5, 5);
        }
        return List.of(4, 6);
    }

    public int getNumberOfCats(List<Cat> cats) {
        int number;
        while (true) {
            try {
                System.out.printf("Введите номер кота (1-%s): ", cats.size());
                number = tryParseAge(scanner.nextLine());
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("Введите числовое значение");
                continue;
            }
            if (number < 1 || number > cats.size()) {
                System.out.println("Данного кота в списке нету!");
                continue;
            }
            break;
        }
        return number - 1;
    }

    static int tryParseAge(String str) throws Exception {
        if (str == null) {
            throw new NullPointerException("Значение null!");
        }
        if (str.length() < 1) {
            throw new NumberFormatException("Пустое значение!");
        }
        return Integer.parseInt(str);
    }

    static String checkName(String str) throws Exception {
        if (str == null) {
            throw new NullPointerException("Значение null!");
        }
        if (str.length() < 1) {
            throw new NumberFormatException("Пустое значение!");
        }
        for (int i = 0; i < str.length(); i++) {
            if (isInteger(str.charAt(i))) {
                throw new Exception("Введите имя без числовых значений");
            }
        }
        return str;
    }

    static boolean isInteger(char r) {
        try {
            Integer.parseInt(String.valueOf(r));
        } catch (NumberFormatException ext) {
            return false;
        } catch (NullPointerException ext) {
            return false;
        }
        return true;
    }


}