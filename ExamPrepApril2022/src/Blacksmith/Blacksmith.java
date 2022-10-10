package Blacksmith;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> recipes = new HashMap<>(){{
            put(70, "Gladius");
            put(80, "Shamshir");
            put(90, "Katana");
            put(110, "Sabre");
        }};
        TreeMap<String, Integer> forged = new TreeMap<>(String::compareTo);
        ArrayDeque<Integer> steel = new ArrayDeque<>(Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        ArrayDeque<Integer> carbon = new ArrayDeque<>(Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        while(steel.size() > 0 && carbon.size() > 0) {
            int currentSteel = steel.pop();
            int currentCarbon = carbon.removeLast();
            int currentSum = currentSteel + currentCarbon;
            if (recipes.containsKey(currentSum)) {
                String weaponName = recipes.get(currentSum);
                forged.putIfAbsent(weaponName, 0);
                forged.put(weaponName, forged.get(weaponName) + 1);
            } else {
                currentCarbon += 5;
                carbon.offer(currentCarbon);
            }
        }
        if (forged.size() > 0) {
            System.out.printf("You have forged %d swords.\n", forged.values().stream().reduce(0, Integer::sum));
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.size() > 0) {
            List<String> steelList = new ArrayList<>(steel.stream().map(Object::toString).collect(Collectors.toList()));
            System.out.printf("Steel left: %s\n", String.join(", ", steelList));
        } else {
            System.out.println("Steel left: none");
        }
        if (carbon.size() > 0) {
            List<String> carbonList = new ArrayList<>(carbon.stream().map(Object::toString).collect(Collectors.toList()));
            Collections.reverse(carbonList);
            System.out.printf("Carbon left: %s\n", String.join(", ", carbonList));
        } else {
            System.out.println("Carbon left: none");
        }
        for(String key: forged.keySet()) {
            System.out.printf("%s: %d\n", key, forged.get(key));
        }
    }
}
