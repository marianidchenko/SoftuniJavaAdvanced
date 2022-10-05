package ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ListyIterator iterator = null;
        while (!command.equals("END")) {
            String[] tokens = command.split(" ");
            ArrayList<String> data = Arrays.stream(tokens)
                    .skip(1)
                    .collect(Collectors.toCollection(ArrayList::new));
            switch (tokens[0]) {
                case "Create":
                    iterator = new ListyIterator(data);
                    break;
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(iterator);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
            command = scanner.nextLine();
        }
    }
}
