import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findMin = (list -> list.lastIndexOf(Collections.min(numbers)));

        System.out.println(findMin.apply(numbers));
    }
}
