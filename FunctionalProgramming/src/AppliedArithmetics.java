import java.util.Arrays;
import java.util.Scanner;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add" -> numbers = Arrays.stream(numbers).map(num -> num + 1).toArray();
                case "multiply" -> numbers = Arrays.stream(numbers).map(num -> num * 2).toArray();
                case "subtract" -> numbers = Arrays.stream(numbers).map(num -> num - 1).toArray();
                default -> {
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            command = scanner.nextLine();
        }
    }
}
