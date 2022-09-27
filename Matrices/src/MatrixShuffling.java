import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int cols = numbers[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = input;
        }

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("END")) {
            try {
                int x1 = Integer.parseInt(command[1]);
                int y1 = Integer.parseInt(command[2]);
                int x2 = Integer.parseInt(command[3]);
                int y2 = Integer.parseInt(command[4]);
                int temp = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = temp;
                printMatrix(rows, cols, matrix);
            } catch(Exception e) {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine().split(" ");
        }
    }
    private static void printMatrix(int rows, int cols, int[][] matrix) {
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
