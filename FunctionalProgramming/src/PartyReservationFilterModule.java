import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PartyReservationFilterModule {
    public static void main(String[] args) {
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endsWith = String::endsWith;
        BiPredicate<String, String> contains = String::contains;
        BiPredicate<String, Integer> lengthIs = (name, length) -> length.equals(name.length());

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> guests = new ArrayList<>(List.of(scanner.nextLine().split(" ")));
        ArrayList<String> finalGuests = new ArrayList<>(guests);

        String command = scanner.nextLine();

        while (!command.equals("Print")) {
            String[] commandArr = command.split(";");
            String action = commandArr[0];
            String condition = commandArr[1];
            String conditionValue = commandArr[2];

            if (action.equals("Add filter")) {
                switch (condition) {
                    case "Starts with":
                        finalGuests.removeAll((finalGuests.stream()
                                .filter(name -> startsWith.test(name, conditionValue))
                                .collect(Collectors.toList())));
                        break;
                    case "Ends with":
                        finalGuests.removeAll((finalGuests.stream()
                                .filter(name -> endsWith.test(name, conditionValue))
                                .collect(Collectors.toList())));
                        break;
                    case "Contains":
                        finalGuests.removeAll((finalGuests.stream()
                                .filter(name -> contains.test(name, conditionValue))
                                .collect(Collectors.toList())));
                        break;
                    case "Length":
                        finalGuests.removeAll((finalGuests.stream()
                                .filter(name -> lengthIs.test(name, Integer.parseInt(conditionValue)))
                                .collect(Collectors.toList())));
                        break;
                }
            } else {
                switch (condition) {
                    case "Starts with":
                        finalGuests.addAll(guests.stream()
                                .filter(name -> startsWith.test(name, conditionValue))
                                .collect(Collectors.toList()));
                        break;
                    case "Ends with":
                        finalGuests.addAll(guests.stream()
                                .filter(name -> endsWith.test(name, conditionValue))
                                .collect(Collectors.toList()));
                        break;
                    case "Contains":
                        finalGuests.addAll(guests.stream()
                                .filter(name -> contains.test(name, conditionValue))
                                .collect(Collectors.toList()));
                        break;
                    case "Length":
                        finalGuests.addAll(guests.stream()
                                .filter(name -> lengthIs.test(name, Integer.valueOf(conditionValue)))
                                .collect(Collectors.toList()));
                        break;
                }
            }
            command = scanner.nextLine();
        }
        String result = String.join(" ", guests.stream().filter(finalGuests::contains).collect(Collectors.toList()));
        System.out.println(result);
    }
}
