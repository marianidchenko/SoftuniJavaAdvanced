import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int cols = numbers[1];
        int[][] matrix = new int[rows][cols];
        int maxSum = Integer.MIN_VALUE;
        int maxCenterX = 0;
        int maxCenterY = 0;

        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }
        for (int x = 1; x < rows-1; x++) {
            for (int y = 1; y < cols-1; y++) {
                int sum = matrix[x-1][y-1] + matrix[x-1][y] + matrix[x-1][y+1] +
                        matrix[x][y-1] + matrix[x][y] + matrix[x][y+1] +
                        matrix[x+1][y-1] + matrix[x+1][y] + matrix[x+1][y+1];
                if (sum > maxSum) {
                    maxCenterX = x;
                    maxCenterY = y;
                    maxSum = sum;
                }
            }
        }
        System.out.println("Sum = "+ maxSum);
        for (int row=maxCenterX-1; row<=maxCenterX+1; row++) {
            for (int col=maxCenterY-1; col<=maxCenterY+1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
