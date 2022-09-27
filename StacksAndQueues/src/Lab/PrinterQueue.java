package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String currentLine = scanner.nextLine();
        while (!currentLine.equals("print")) {
            if (currentLine.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s\n", queue.pollFirst());
                }
            } else {
                queue.offer(currentLine);
            }
            currentLine = scanner.nextLine();
        }

        if (!queue.isEmpty()) {
            for (int i = 0; i <= queue.size() + 1; i++) {
                System.out.println(queue.pollFirst());
            }
        }
    }
}
