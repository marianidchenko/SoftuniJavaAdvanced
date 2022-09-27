import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, String> phonebook = new HashMap<String, String>();
        while (!input.equals("search")) {
            String[] contact = input.split("-");
            phonebook.put(contact[0], contact[1]);
            input = scanner.nextLine();
        }
        String searchQuery = scanner.nextLine();
        while (!searchQuery.equals("stop")) {
            if (phonebook.containsKey(searchQuery)) {
                System.out.printf("%s -> %s\n", searchQuery, phonebook.get(searchQuery));
            } else {
                System.out.printf("Contact %s does not exist.\n", searchQuery);
            }
            searchQuery = scanner.nextLine();
        }
    }
}
