package ChocolateTime;

import java.util.*;
import java.util.stream.Collectors;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Double, String> chocolateTypes = new HashMap<>(){{
            put(100.0, "Baking Chocolate");
            put(50.0, "Dark Chocolate");
            put(30.0,"Milk Chocolate");
        }};
        TreeMap<String, Integer> chocolatesMade = new TreeMap<>(String::compareTo);

        ArrayDeque<Double> milkValues = new ArrayDeque<Double>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList()));
        ArrayDeque<Double> cacaoValues = new ArrayDeque<Double>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList()));
        // Cacao Percentage = CacaoPowderValue / (CacaoPowderValue + MilkPowderValue)
        // Always remove cacao and increase milk with 10 if not applicable

        while (cacaoValues.size() > 0 && milkValues.size() > 0) {
            Double currentMilk = milkValues.pop();
            Double currentCacao = cacaoValues.removeLast();
            Double currentPercentage = currentCacao / (currentMilk + currentCacao) * 100;
            if (chocolateTypes.containsKey(currentPercentage)) {
                String chocolateMade = chocolateTypes.get(currentPercentage);
                chocolatesMade.putIfAbsent(chocolateMade, 0);
                chocolatesMade.put(chocolateMade, chocolatesMade.get(chocolateMade) + 1);
            } else {
                currentMilk += 10;
                milkValues.add(currentMilk);
            }
        }
        if (chocolatesMade.size() == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (String key: chocolatesMade.keySet()) {
            System.out.printf("# %s --> %d\n", key, chocolatesMade.get(key));
        }
    }
}
