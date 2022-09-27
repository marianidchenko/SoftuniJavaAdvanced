package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String currentLine = scanner.nextLine();
        while (!currentLine.equals("Home")) {
            if (currentLine.equals("back")) {
                if (history.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String previousPage = history.pop();
                    forward.addFirst(previousPage);
                    System.out.println(history.peek());
                }
            } else if (currentLine.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String nextPage = forward.pop();
                    history.push(nextPage);
                    System.out.println(history.peek());
                }
            } else {
                if (!currentLine.equals("")) {
                    history.push(currentLine);
                    System.out.println(history.peek());
                    forward.clear();
                }
            }
            currentLine = scanner.nextLine();
        }
    }
}
