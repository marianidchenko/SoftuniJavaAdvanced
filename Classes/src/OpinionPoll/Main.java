package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> people = new ArrayList<Person>();

        for (int i = 0; i < n; i++) {
            String[] personArr = scanner.nextLine().split(" ");
            String name = personArr[0];
            int age = Integer.parseInt(personArr[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        ArrayList<Person> peopleOver30 = new ArrayList<Person>(people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList()));

        peopleOver30.forEach(person -> System.out.printf("%s - %d\n", person.getName(), person.getAge()));
    }
}
