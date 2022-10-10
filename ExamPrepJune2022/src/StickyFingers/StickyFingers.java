package StickyFingers;

import java.util.*;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int playerX = 0;
        int playerY = 0;
        int moneyStolen = 0;
        boolean caught = false;
        String[] commands = scanner.nextLine().split(",");
        String[][] map = new String[n][n];;


        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            map[i] = line;
            if (Arrays.asList(line).contains("D")) {
                playerX = i;
                playerY = Arrays.asList(line).indexOf("D");
            }
        }
        for (String command : commands) {
            map[playerX][playerY] = "+";
            switch (command) {
                case "up":
                    playerX -= 1;
                    if (isOutside(playerX, playerY, n)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        playerX += 1;
                    }
                    break;
                case "down":
                    playerX += 1;
                    if (isOutside(playerX, playerY, n)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        playerX -= 1;
                    }
                    break;
                case "left":
                    playerY -= 1;
                    if (isOutside(playerX, playerY, n)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        playerY += 1;
                    }
                    break;
                case "right":
                    playerY += 1;
                    if (isOutside(playerX, playerY, n)) {
                        System.out.println("You cannot leave the town, there is police outside!");
                        playerY -= 1;
                    }
                    break;
            }
            if (isOnHouse(playerX, playerY, map)) {
                moneyStolen += playerX * playerY;
                System.out.printf("You successfully stole %d$.\n", playerX*playerY);
            } else if (isOnPolice(playerX, playerY, map)) {
                System.out.printf("You got caught with %d$, and you are going to jail.\n", moneyStolen);
                map[playerX][playerY] = "#";
                caught = true;
                break;
            }
            map[playerX][playerY] = "D";
        }
        if(!caught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", moneyStolen);
        }
        printMap(map);
    }
    public static boolean isOutside(int x, int y, int n) {
        return (x < 0 || n <= x || y < 0 || n <= y);
    }
    public static boolean isOnHouse(int x, int y, String[][] map) {
        return (map[x][y].equals("$"));
    }
    public static boolean isOnPolice(int x, int y, String[][] map) {
        return (map[x][y].equals("P"));
    }

    public static void printMap(String[][] map) {
        for (String[] l: map) {
            System.out.println(String.join(" ", l));
        }
    }
}
