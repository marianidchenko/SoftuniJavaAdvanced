package Swap;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(scanner.nextLine());
            box.add(line);
        }
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Box.swap(box.getValues(), nums[0], nums[1]);
        System.out.println(box.toString());
    }
}
