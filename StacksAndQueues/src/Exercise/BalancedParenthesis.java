package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        boolean valid = true;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("{") || input[i].equals("[") || input[i].equals("(")) {
                stack.push(input[i]);
            } else if (stack.isEmpty()){
                valid = false;
                break;
            } else if (input[i].equals("}")){
                if (!stack.pop().equals("{")) {
                    valid = false;
                    break;
                }
            } else if (input[i].equals("]")){
                if (!stack.pop().equals("[")) {
                    valid = false;
                    break;
                }
            } else if (input[i].equals(")")){
                if (!stack.pop().equals("(")) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
