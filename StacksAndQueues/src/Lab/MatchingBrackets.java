package Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {

            String sym = String.valueOf(expression.charAt(i));
            if (sym.equals("(")) {
                stack.push(i);
            } else if (sym.equals(")")) {
                int startId = stack.pop();
                String contents = expression.substring(startId, i + 1);
                System.out.println(contents);
            }
        }
    }
}
