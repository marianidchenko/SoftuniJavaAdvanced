import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set1.add(num);
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if(set1.contains(num)) {
                set2.add(num);
            }

        }
        set1.retainAll(set2);
        for (int num: set1) {
            System.out.print(num+ " ");
        }

    }
}
