package CarSalesman;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Engine engine = null;
            switch (tokens.length) {
                case 2:
                    engine = new Engine(tokens[0], Integer.parseInt(tokens[1]));
                    break;
                case 3:
                    if (checkIfNumber(tokens[2])) {
                        engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    } else {
                        engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    }
                    break;
                default:
                    engine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Car car = null;
            Engine engine = engines.stream()
                    .filter(e -> e.getModel().equals(tokens[1]))
                    .collect(Collectors.toList())
                    .get(0);

            switch (tokens.length) {
                case 2:
                    car = new Car(tokens[0], engine);
                    break;
                case 3:
                    if (checkIfNumber(tokens[2])) {
                        car = new Car(tokens[0], engine, Integer.parseInt(tokens[2]));
                    } else {
                        car = new Car(tokens[0], engine, tokens[2]);
                    }
                    break;
                default:
                    car = new Car(tokens[0], engine, Integer.parseInt(tokens[2]), tokens[3]);
            }

            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public static Boolean checkIfNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {return false;}
        return true;
    }
}
