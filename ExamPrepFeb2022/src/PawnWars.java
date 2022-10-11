import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[8][8];
        int wX = 0;
        int wY = 0;
        int bX = 0;
        int bY = 0;
        boolean oddTurn = true;

        for (int i = 0; i < 8; i++) {
            String input = scanner.nextLine();
            board[i] = input.split("");
            if (input.contains("w")) {
                wX = i;
                wY = input.indexOf("w");
            }
            if (input.contains("b")) {
                bX = i;
                bY = input.indexOf("b");
            }
        }

        while (true) {
            if (oddTurn) {
                board[wX][wY] = "-";
                if (canTake(wX, wY, "White", board)) {
                    wX = bX;
                    wY = bY;
                    board[wX][wY] = "w";
                    String square = String.valueOf((char) (wY + 65)).toLowerCase() + (8 - wX);
                    System.out.printf("Game over! White capture on %s.", square);
                    break;
                }
                wX--;
                if (isAtEdge(wX, wY, "White")) {
                    board[wX][wY] = "w";
                    String square = String.valueOf((char) (wY + 65)).toLowerCase() + (8 - wX);
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.", square);
                    break;
                }
                board[wX][wY] = "w";
            } else {
                board[bX][bY] = "-";
                if (canTake(bX, bY, "Black", board)) {
                    bX = wX;
                    bY = wY;
                    board[bX][bY] = "b";
                    String square = String.valueOf((char) (bY + 65)).toLowerCase() + (8 - bX);
                    System.out.printf("Game over! Black capture on %s.", square);
                    break;
                }
                bX++;
                if (isAtEdge(bX, bY, "Black")) {
                    board[bX][bY] = "b";
                    String square = String.valueOf((char) (bY + 65)).toLowerCase() + (8 - bX);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s.", square);
                    break;
                }
                board[bX][bY] = "b";
            }
            oddTurn = !oddTurn;
        }
    }

    public static boolean canTake(int x, int y, String color, String[][] board) {
        try {
            if (color.equals("White")) {
                if (y - 1 < 0) {
                    return (board[x - 1][y + 1].equals("b"));
                }
                if (y + 1 == 8) {
                    return (board[x - 1][y - 1].equals("b"));
                }
                return (board[x + 1][y - 1].equals("b") || board[x - 1][y + 1].equals("b"));
            }
            else {
                if (y - 1 < 0) {
                    return (board[x + 1][y + 1].equals("w"));
                }
                if (y + 1 == 8) {
                    return (board[x + 1][y - 1].equals("w"));
                }
                return (board[x + 1][y - 1].equals("w") || board[x - 1][y + 1].equals("w"));
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isAtEdge(int x, int y, String color) {
        if (color.equals("White")) {
            if (x == 0) {
                return true;
            }
            return false;
        }
        if (x == 7) {
            return true;
        }
        return false;
    }
}
