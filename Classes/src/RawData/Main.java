package RawData;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            Engine engine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Cargo cargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);
            ArrayList<Tire> tires = new ArrayList<>();
            for (int j = 5; j < tokens.length; j += 2) {
                Tire tire = new Tire(Double.parseDouble(tokens[j]), Integer.parseInt(tokens[j + 1]));
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        ArrayList<Car> filteredCars = cars.stream()
                .filter(car -> car.getCargo().getType().equals(command))
                .collect(Collectors.toCollection(ArrayList::new));

        if (command.equals("fragile")) {
            for (Car car : filteredCars) {
                if (car.getTires().stream().anyMatch(t -> t.getPressure() < 1.0)) {
                    System.out.println(car.getModel());
                }
            }
        } else {
            for (Car car : filteredCars) {
                if (car.getEngine().getPower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
