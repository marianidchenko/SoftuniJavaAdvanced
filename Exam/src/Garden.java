import java.util.Arrays;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] mapSize = scanner.nextLine().split(" ");
        int n = Integer.parseInt(mapSize[0]);
        int m = Integer.parseInt(mapSize[1]);
        int[][] garden = new int[n][m];

        String command = scanner.nextLine();
        while (!command.equals("Bloom Bloom Plow")) {
            String[] tokens = command.split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);

            if (x < 0 || y < 0 || x >= n || y >= m) {
                System.out.println("Invalid coordinates.");
            } else {
                for (int i = 0; i < n; i++) {
                    if (i == x) {
                        for (int j = 0; j < m; j++) {garden[i][j] += 1;}
                    } else {
                        for (int j = 0; j < m; j++) {
                            if (j == y) {garden[i][j] += 1;}
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        printGarden(garden);
    }

    public static void printGarden(int[][] garden) {
        for (int[]x: garden) {
            String row = Arrays.toString(x).replaceAll("\\[|]|,|", "");
            System.out.println(row.trim());
        }
    }
}
