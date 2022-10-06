package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<Person>();
        while (!input.equals("END")) {
            String[] peopleData = input.split(" ");
            String name = peopleData[0];
            int age = Integer.parseInt(peopleData[1]);
            String town = peopleData[2];
            Person person = new Person(name, age, town);
            people.add(person);
            input = scanner.nextLine();
        }

        int compareIndex = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(compareIndex-1);

        int totalPeople = people.size();
        int samePeople = 0;

        for (Person person : people) {
            if (person.compareTo(personToCompare) < 0) {
                samePeople++;
            }
        }
        if (samePeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(samePeople + " " + (totalPeople-samePeople) + " " + totalPeople);
        }
    }
}
