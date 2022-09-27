import java.util.*;
import java.util.function.Predicate;


public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Integer[] input = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        HashSet<Integer> set = new HashSet<>(Arrays.asList(input));

        Predicate<Integer> isDivisible = (num -> {
            for (Integer numberToDivide: set) {
                if(num % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= n; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
