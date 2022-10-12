import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>(Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        ArrayDeque<Integer> threads = new ArrayDeque<>(Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {
            int currentTask = tasks.getLast();
            int currentThread = threads.getFirst();
            if (currentTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d\n", currentThread, taskToKill);
                break;
            }
            threads.pop();
            if (currentThread >= currentTask) {
                tasks.removeLast();
            }
        }
        String result = "";
        for (int thread: threads) {
            result += (thread + " ");
        }
        System.out.println(result.trim());
    }
}