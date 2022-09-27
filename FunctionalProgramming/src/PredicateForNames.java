import java.util.Scanner;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split(" ");
        BiPredicate<String, Integer> predicate = (name, length) -> name.length() <= length;
        for (String name : names) {
            if (predicate.test(name, n)) {
                System.out.println(name);
            }
        }
    }
}
