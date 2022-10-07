package MouseAndCheese;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<ArrayList<String>> maze = new ArrayList<>();
        int mouseX = 0;
        int mouseY = 0;
        int cheeses = 0;
        boolean isOutside = false;
        String boost = "";

        for (int i = 0; i < n; i++) {
            ArrayList<String> row = Arrays.stream(scanner.nextLine().split(""))
                    .collect(Collectors.toCollection(ArrayList::new));
            maze.add(row);
            if (row.contains("M")) {
                mouseX = i;
                mouseY = row.indexOf("M");
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "right":
                    if (mouseY < n -1) {
                        String element = maze.get(mouseX).get(mouseY+1);
                        if ("c".equals(element)) {cheeses++;}
                        else if ("B".equals(element)) {boost="right";}
                        maze.get(mouseX).set(mouseY+1, "M");
                    } else {isOutside = true;}
                    maze.get(mouseX).set(mouseY, "-");
                    mouseY++;
                    break;
                case "left":
                    if (mouseY > 0) {
                        String element = maze.get(mouseX).get(mouseY-1);
                        if ("c".equals(element)) {cheeses++;}
                        else if ("B".equals(element)) {boost="left";}
                        maze.get(mouseX).set(mouseY-1, "M");
                    } else {isOutside = true;}
                    maze.get(mouseX).set(mouseY, "-");
                    mouseY--;
                    break;
                case "up":
                    if (mouseX > 0) {
                        String element = maze.get(mouseX-1).get(mouseY);
                        if ("c".equals(element)) {cheeses++;}
                        else if ("B".equals(element)) {boost="up";}
                        maze.get(mouseX-1).set(mouseY, "M");
                    } else {isOutside = true;}
                    maze.get(mouseX).set(mouseY, "-");
                    mouseX--;
                    break;
                case "down":
                    if (mouseX < n -1) {
                        String element = maze.get(mouseX+1).get(mouseY);
                        if ("c".equals(element)) {cheeses++;}
                        else if ("B".equals(element)) {boost="down";}
                        maze.get(mouseX+1).set(mouseY, "M");
                    } else {isOutside = true;}
                    maze.get(mouseX).set(mouseY, "-");
                    mouseX++;
                    break;
            }
            if (isOutside) {break;}
            if (!boost.equals("")) {
                command = boost;
                boost = "";
                continue;
            }
            command = scanner.nextLine();
        }
        if (isOutside) {
            System.out.println("Where is the mouse?");
        }
        if (cheeses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheeses);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeses);
        }
        prStringMatrix(n, maze);
    }
    private static void prStringMatrix(int n, ArrayList<ArrayList<String>> matrix) {
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                System.out.print(matrix.get(row).get(col) + "");
            }
            System.out.println();
        }
    }
}
