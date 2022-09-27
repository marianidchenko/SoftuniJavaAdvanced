import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];
        int counter = 1;

        if (type.equals("A")) {
            fillMatrixA(n, counter, matrix);
        } else {
            fillMatrixB(n, counter, matrix);
        }

        printMatrix(n, matrix);
    }

    private static void fillMatrixB(int n, int counter, int[][] matrix) {
        for(int col=0; col<n; col++) {
            if(col%2 == 0) {
                for (int row=0; row<n; row++) {
                    matrix[row][col] = counter;
                    counter ++;
                }
            } else {
                for (int row=n-1; row>=0; row--) {
                    matrix[row][col] = counter;
                    counter ++;
                }
            }
        }
    }

    private static void fillMatrixA(int n, int counter, int[][] matrix) {
        for (int col=0; col<n; col++) {
            for (int row=0; row<n; row++) {
                matrix[row][col] = counter;
                counter ++;
            }
        }
    }

    private static void printMatrix(int n, int[][] matrix) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
