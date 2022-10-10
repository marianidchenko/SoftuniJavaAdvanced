package TreasureHunt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = size[0];
        int m = size[1];
        String[][] map = new String[n][m];

        int[] coordinates = new int[]{0, 0};
        ArrayList<String> path = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] row = input.split(" ");
            map[i] = row;
            if (input.contains("Y")) {
                coordinates[0] = i;
                coordinates[1] = input.replaceAll(" ", "").indexOf("Y");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    coordinates[0] -= 1;
                    if (!isInside(coordinates[0], coordinates[1], n, m) || isOnTree(coordinates[0], coordinates[1], map)) {
                        coordinates[0] += 1;
                    } else {
                        path.add(command);
                    }
                    break;
                case "down":
                    coordinates[0] += 1;
                    if (!isInside(coordinates[0], coordinates[1], n, m) || isOnTree(coordinates[0], coordinates[1], map)) {
                        coordinates[0] -= 1;
                    } else {
                        path.add(command);
                    }
                    break;
                case "right":
                    coordinates[1] += 1;
                    if (!isInside(coordinates[0], coordinates[1], n, m) || isOnTree(coordinates[0], coordinates[1], map)) {
                        coordinates[1] -= 1;
                    } else {
                        path.add(command);
                    }
                    break;
                case "left":
                    coordinates[1] -= 1;
                    if (!isInside(coordinates[0], coordinates[1], n, m) || isOnTree(coordinates[0], coordinates[1], map)) {
                        coordinates[1] += 1;
                    } else {
                        path.add(command);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if(isOnTreasure(coordinates[0], coordinates[1], map)) {
            System.out.println("I've found the treasure!");
            String resultPath = String.join(", ", path);
            System.out.printf("The right path is %s", resultPath);
        } else {
            System.out.println("The map is fake!");
        }
    }

    public static boolean isInside(int x, int y, int n, int m) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    public static boolean isOnTree(int x, int y, String[][] map) {
        return (map[x][y].equals("T"));
    }

    public static boolean isOnTreasure(int x, int y, String[][] map) {
        return (map[x][y].equals("X"));
    }
}
