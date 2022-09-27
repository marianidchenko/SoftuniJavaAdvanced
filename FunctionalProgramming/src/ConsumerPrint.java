import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>(List.of(scanner.nextLine().split("\\s+")));

        Consumer<String> consumer = System.out::println;

        lines.forEach(consumer);
    }
}
