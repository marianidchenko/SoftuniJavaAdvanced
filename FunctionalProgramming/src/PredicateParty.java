import java.util.*;
import java.util.function.BiPredicate;

public class PredicateParty {
    public static void main(String[] args) {
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, Integer> lengthIs = (name, length) -> length.equals(name.length());

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> guests = new ArrayList<>(List.of(scanner.nextLine().split(" ")));

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] commandArr = command.split(" ");
            String action = commandArr[0];
            String condition = commandArr[1];
            String conditionValue = commandArr[2];

            if (action.equals("Remove")) {
                switch (condition) {
                    case "StartsWith" -> guests.removeIf(name -> startsWith.test(name, conditionValue));
                    case "EndsWith" -> guests.removeIf(name -> endsWith.test(name, conditionValue));
                    case "Length" -> guests.removeIf(name -> lengthIs.test(name, Integer.parseInt(conditionValue)));
                }
            } else if (action.equals("Double")) {
                ArrayList<String> toDouble = new ArrayList<>();
                switch (condition) {
                    case "StartsWith" -> {
                        for (String guest : guests) {
                            if (startsWith.test(guest, conditionValue)) {
                                toDouble.add(guest);
                            }
                        }
                        guests.addAll(toDouble);
                    }
                    case "EndsWith" -> {
                        for (String guest : guests) {
                            if (endsWith.test(guest, conditionValue)) {
                                toDouble.add(guest);
                            }
                        }
                        guests.addAll(toDouble);
                    }
                    case "Length" -> {
                        for (String guest : guests) {
                            if (lengthIs.test(guest, Integer.parseInt(conditionValue))) {
                                toDouble.add(guest);
                            }
                        }
                        guests.addAll(toDouble);
                    }
                }
            }
            command = scanner.nextLine();
        }
        if (guests.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guests);
            String guestsString = String.join(", ", guests);
            System.out.printf("%s are going to the party!\n", guestsString);
        }
    }
}
