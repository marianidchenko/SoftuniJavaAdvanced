package StackIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        String[] tokens = scanner.nextLine().replaceAll(",", "").split(" ");
        while (!tokens[0].equals("END")) {
            String command = tokens[0];
            switch (command) {
                case "Push":
                    List<Integer> nums = Arrays.stream(Arrays.copyOfRange(tokens, 1, tokens.length))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());
                    stack.push(nums);
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            tokens = scanner.nextLine().replaceAll(",", "").split(" ");
        }
        System.out.println(stack);
    }
}
