import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String email;
        HashSet<String> topDomainsToRemove = new HashSet<String>(Arrays.asList("us", "uk", "com"));
        LinkedHashMap<String, String> contacts = new LinkedHashMap<String, String>();

        while (!name.equals("stop")) {
            email = scanner.nextLine();
            String [] emailList = email.split("\\.");
            String topDomain = emailList[emailList.length - 1];
            if (!topDomainsToRemove.contains(topDomain.toLowerCase())) {
                contacts.put(name, email);
            }
            name = scanner.nextLine();
        }

        for (String c : contacts.keySet()) {
            System.out.printf("%s -> %s\n", c, contacts.get(c));
        }
    }
}
