package Cooking;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        HashMap<Integer, String> recipes = new HashMap<Integer, String>(){{
            put(25, "Bread");
            put(50, "Cake");
            put(75, "Pastry");
            put(100, "Fruit Pie");
        }};

        LinkedHashMap<String, Integer> cooked = new LinkedHashMap<String, Integer>(){{
            put("Bread", 0);
            put("Cake", 0);
            put("Fruit Pie", 0);
            put("Pastry", 0);
        }};

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentSum = liquids.getFirst() + ingredients.getLast();
            if (recipes.containsKey(currentSum)) {
                String food = recipes.get(currentSum);
                cooked.put(food, cooked.get(food) + 1);
                liquids.pop();
                ingredients.removeLast();
            } else {
                liquids.pop();
                ingredients.offer(ingredients.removeLast() + 3);
            }
        }
        String liquidsLeft;
        String ingredientsLeft;
        if (liquids.isEmpty()) {
            liquidsLeft = "none";
        } else {
            liquidsLeft = String.join(", ", liquids.stream().map(String::valueOf).collect(Collectors.toList()));
        }

        if (ingredients.isEmpty()) {
            ingredientsLeft = "none";
        } else {
            List<String> ingredientsList = ingredients.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(ingredientsList);
            ingredientsLeft = String.join(", ", ingredientsList);
        }

        if (cooked.containsValue(0)) {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        System.out.printf("Liquids left: %s\n", liquidsLeft);
        System.out.printf("Ingredients left: %s\n", ingredientsLeft);
        for (Map.Entry<String, Integer> pair: cooked.entrySet()) {
            System.out.printf("%s: %d\n", pair.getKey(), pair.getValue());
        }
    }
}
