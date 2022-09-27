import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Function<int[], Integer> getMin = integers -> {
            int min = Integer.MAX_VALUE;
            for (int i : integers) {
                if (i < min) {
                    min = i;
                }
            }
            return min;
        };
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(getMin.apply(numbers));
    }
}
