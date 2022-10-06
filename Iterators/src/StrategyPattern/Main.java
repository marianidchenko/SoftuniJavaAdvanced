package StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person> nameSet = new TreeSet<Person>(new NameComparator());
        TreeSet<Person> ageSet = new TreeSet<Person>(new AgeComparator());
        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split(" ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            ageSet.add(person);
            nameSet.add(person);
        }

        for (Person person : nameSet) {
            System.out.println(person);
        }
        for (Person person : ageSet) {
            System.out.println(person);
        }
    }
}
