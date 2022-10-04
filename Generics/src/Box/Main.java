package Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<Integer>();

        for (int i = 0; i < n; i++) {
            Integer line = Integer.parseInt(scanner.nextLine());
            box.add(line);
        }
        System.out.println(box.toString());
    }
}