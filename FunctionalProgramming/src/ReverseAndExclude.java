import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        int n = Integer.parseInt(scanner.nextLine());
        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reverseAndExclude = ((arr, divisor) -> {
            Collections.reverse(arr);
            ArrayList<Integer> result = arr.stream().filter(num -> num%divisor != 0).collect(Collectors.toCollection(ArrayList::new));
            return result;
        });
        ArrayList<Integer> result = reverseAndExclude.apply(numbers, n);
        result.forEach(i -> System.out.print(i + " "));
    }
}
