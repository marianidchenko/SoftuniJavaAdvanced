package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countToAdd = input[0];
        int countToRemove = input[1];
        int targetElement = input[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < countToAdd; i++) {
            queue.add(numbers[i]);
        }
        for (int i = 0; i < countToRemove; i++) {
            queue.pop();
        }

        if (queue.contains(targetElement)) {
            System.out.println("true");
        } else if (queue.isEmpty()){
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
