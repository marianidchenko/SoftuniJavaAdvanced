package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number: numbers) {
            stack.push(Integer.parseInt(number));
        }

        for (int num: stack) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
