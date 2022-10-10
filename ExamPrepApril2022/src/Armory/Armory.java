package Armory;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[n][n];
        int officerX = 0;
        int officerY = 0;
        int moneySpent = 0;
        boolean outside = false;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] row = input.split("");
            armory[i] = row;
            if (input.contains("A")) {
                officerX = i;
                officerY = input.indexOf("A");
            }
        }
        String command = scanner.nextLine();
        while (true) {
            armory[officerX][officerY] = "-";
            switch (command) {
                case "up":
                    officerX -= 1;
                    break;
                case "down":
                    officerX += 1;
                    break;
                case "left":
                    officerY -= 1;
                    break;
                case "right":
                    officerY += 1;
                    break;
            }
            if (isOutside(officerX, officerY, n)) {
                outside = true;
                break;
            } else {
                if (armory[officerX][officerY].equals("M")) {
                    armory[officerX][officerY] = "-";
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (armory[i][j].equals("M")){
                                officerX = i;
                                officerY = j;
                        }
                    }
                }
            } else if (!armory[officerX][officerY].equals("-")) {
                moneySpent += Integer.parseInt(armory[officerX][officerY]);
                if (moneySpent >= 65) {
                    armory[officerX][officerY] = "A";
                    break;
                }
            }
            armory[officerX][officerY] = "A";
        }
        command = scanner.nextLine();
    }
        if(outside)

    {
        System.out.println("I do not need more swords!");
    } else

    {
        System.out.println("Very nice swords, I will come back for more!");
    }
        System.out.printf("The king paid %d gold coins.\n", moneySpent);

    printMap(armory);

}

    public static boolean isOutside(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    public static void printMap(String[][] map) {
        for (String[] l : map) {
            System.out.println(String.join("", l));
        }
    }
}
