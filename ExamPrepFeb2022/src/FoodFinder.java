import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vowels = new ArrayDeque<String>(Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList()));
        ArrayDeque<String> consonants = new ArrayDeque<String>(Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList()));
        Map<String, Set> foodLetters = new LinkedHashMap<>(){{
            put("pear", new HashSet<>());
            put("flour", new HashSet<>());
            put("pork", new HashSet<>());
            put("olive", new HashSet<>());
        }};
        
        while (consonants.size() > 0) {
            String currentVowel = vowels.pop();
            String currentConsonant = consonants.removeLast();
            for (String key : foodLetters.keySet()) {
                if (!foodLetters.get(key).contains(currentVowel) && key.contains(currentVowel)) {
                    foodLetters.get(key).add(currentVowel);
                }
                if (!foodLetters.get(key).contains(currentConsonant) && key.contains(currentConsonant)) {
                    foodLetters.get(key).add(currentConsonant);
                }
            }
            vowels.add(currentVowel);
        }
        List result = foodLetters.keySet().stream().filter(k -> k.length() == foodLetters.get(k).size())
                .collect(Collectors.toList());
        System.out.printf("Words found: %d\n", result.size());
        for (String key: foodLetters.keySet()) {
            if (key.length() == foodLetters.get(key).size()) {
                System.out.println(key);
            }
        }
    }
}