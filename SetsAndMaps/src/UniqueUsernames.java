import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> uniqueUsernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String username= scanner.nextLine();
            uniqueUsernames.add(username);
        }
        for (String username: uniqueUsernames) {
            System.out.println(username);
        }
    }
}
