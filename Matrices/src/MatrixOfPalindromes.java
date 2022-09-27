import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String [][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String outer = String.valueOf((char)("a".charAt(0) + row));
                String inner = String.valueOf((char)("a".charAt(0) + col + row));
                String element = outer + inner + outer;
                matrix[row][col] = element;
            }
        }
        printMatrix(rows, cols, matrix);
    }
    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
