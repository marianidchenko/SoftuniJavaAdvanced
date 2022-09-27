import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = ((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (b % 2 == 0 && a % 2 != 0) {
                return 1;
            }
            return a.compareTo(b);
        });

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
    }
}
