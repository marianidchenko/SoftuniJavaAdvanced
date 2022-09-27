package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MathPotato {

    static boolean isPrime(int num)
    {
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namesString = scanner.nextLine();
        int numberOfThrows = scanner.nextInt();

        List<String> list = Arrays.asList(namesString.split(" "));
        ArrayDeque<String> kids = new ArrayDeque<>(list);

        String currentKid = kids.peek();
        int cycle = 1;

        while (kids.size() > 1) {
            for (int i = 0; i < numberOfThrows; i++) {
                currentKid = kids.pollFirst();
                kids.offer(currentKid);
            }

            if (isPrime(cycle)) {
                currentKid = kids.pollLast();
                kids.push(currentKid);
                System.out.printf("Prime %s\n", currentKid);
            } else {
                currentKid = kids.removeLast();
                System.out.printf("Removed %s\n", currentKid);
            }
            cycle += 1;
        }

        String lastKid = kids.peek();
        System.out.printf("Last is %s\n", lastKid);
    }
}
