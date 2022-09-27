import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Character, Integer> symbols = new TreeMap<Character, Integer>();
        char[] input = scanner.nextLine().toCharArray();

        for (char ch: input) {
            symbols.putIfAbsent(ch, 0);
            int newCount = symbols.get(ch) + 1;
            symbols.put(ch, newCount);
        }

        symbols.forEach((ch, count) -> System.out.printf("%c: %d time/s\n", ch, count));
    }
}
