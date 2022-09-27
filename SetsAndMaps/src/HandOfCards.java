import java.util.*;

public class HandOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, Integer> multipliers = new HashMap<String, Integer>(){{
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }};
        HashMap<String, Integer> faceCards = new HashMap<String, Integer>(){{
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
        }};

        LinkedHashMap<String, HashSet> players = new LinkedHashMap<String, HashSet>();
        while (!input.equals("JOKER")) {
            String[] inputList = input.split(": ");
            String name = inputList[0];
            if (!players.containsKey(name)) {
                HashSet<String> cards = new HashSet<>();
                players.put(name, cards);
            }
            HashSet<String> cards = players.get(name);
            cards.addAll(Arrays.asList(inputList[1].split(", ")));
            input = scanner.nextLine();
        }
        for (String name : players.keySet()) {
            int cardScore = 0;
            for(Object card : players.get(name)) {
                String cardValue = card.toString();
                String value = cardValue.substring(0, cardValue.length() - 1);
                int valueInteger;
                String multiplier = cardValue.substring(cardValue.length() - 1);
                if (faceCards.containsKey(value)) {
                    valueInteger = Integer.valueOf(faceCards.get(value));
                } else {
                    valueInteger = Integer.parseInt(value);
                }
                cardScore += valueInteger * multipliers.get(multiplier);
            }
            System.out.printf("%s: %d\n", name, cardScore);
        }
    }
}
