import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int d1 = 0;
        int d2 = 0;

        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
            d1 += numbers[i];
            d2 += numbers[n-i-1];
        }
        System.out.println(Math.abs(d1 - d2));
    }
}
