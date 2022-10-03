package Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Person> people = new HashMap<String, Person>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String [] tokens = line.split(" ");
            Person person = null;
            if (!people.containsKey(tokens[0])) {
                people.put(tokens[0], person = new Person(tokens[0]));
            } else {
                person = people.get(tokens[0]);
            }
            switch (tokens[1]) {
                case "company":
                    person.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "car":
                    person.setCar(new Car(tokens[2], Integer.parseInt(tokens[3])));
                    break;
                case "pokemon":
                    person.setPokemon(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    person.setParents(new Parent(tokens[2], tokens[3]));
                    break;
                case "children":
                    person.setChildren(new Child(tokens[2], tokens[3]));
                    break;
            }
            line = scanner.nextLine();
        }
        String command = scanner.nextLine();
        System.out.println(people.get(command).toString());
    }
}
