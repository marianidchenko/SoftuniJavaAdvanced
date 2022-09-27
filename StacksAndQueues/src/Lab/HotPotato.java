package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namesString = scanner.nextLine();
        int numberOfThrows = scanner.nextInt();

        List<String> list = Arrays.asList(namesString.split(" "));
        ArrayDeque<String> kids = new ArrayDeque<>(list);

        String currentKid;

        while (kids.size() > 1) {
            for (int i = 0; i < numberOfThrows; i++) {
                currentKid = kids.pollFirst();
                kids.offer(currentKid);
            }

            currentKid = kids.removeLast();
            System.out.printf("Removed %s\n", currentKid);
        }

        String lastKid = kids.peek();
        System.out.printf("Last is %s\n", lastKid);
    }
}
