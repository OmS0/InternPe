import java.util.Scanner;

public class Connect4Game {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static char[][] grid = new char[ROWS][COLUMNS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeGrid();
        boolean gameOver = false;

        while (!gameOver) {
            printGrid();
            int column = promptPlayerInput();
            int row = dropPiece(column);

            if (checkWin(row, column)) {
                printGrid();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isGridFull()) {
                printGrid();
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static void initializeGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    private static void printGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + grid[row][col] + " ");
            }
            System.out.println("|");
        }
        for (int col = 0; col < COLUMNS; col++) {
            System.out.print("+-+-");
        }
        System.out.println("+");
        for (int col = 0; col < COLUMNS; col++) {
            System.out.print("  " + col + " ");
        }
        System.out.println();
    }

    private static int promptPlayerInput() {
        Scanner scanner = new Scanner(System.in);
        int column;
        while (true) {
            System.out.print("Player " + currentPlayer + ", choose a column (0-6): ");
            if (scanner.hasNextInt()) {
                column = scanner.nextInt();
                if (isValidMove(column)) {
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return column;
    }

    private static boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && grid[0][column] == ' ';
    }

    private static int dropPiece(int column) {
        int row = ROWS - 1;
        while (row >= 0 && grid[row][column] != ' ') {
            row--;
        }
        if (row >= 0) {
            grid[row][column] = currentPlayer;
        }
        return row;
    }

    private static boolean checkWin(int row, int column) {
        char player = currentPlayer;

        // Check horizontally
        for (int col = 0; col <= COLUMNS - 4; col++) {
            if (grid[row][col] == player && grid[row][col + 1] == player &&
                    grid[row][col + 2] == player && grid[row][col + 3] == player) {
                return true;
            }
        }

        // Check vertically
        for (int r = 0; r <= ROWS - 4; r++) {
            if (grid[r][column] == player && grid[r + 1][column] == player &&
                    grid[r + 2][column] == player && grid[r + 3][column] == player) {
                return true;
            }
        }

        // Check diagonally (from top-left to bottom-right)
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (grid[r][col] == player && grid[r + 1][col + 1] == player &&
                        grid[r + 2][col + 2] == player && grid[r + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonally (from top-right to bottom-left)
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int col = 3; col < COLUMNS; col++) {
                if (grid[r][col] == player && grid[r + 1][col - 1] == player &&
                        grid[r + 2][col - 2] == player && grid[r + 3][col - 3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isGridFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (grid[0][col] == ' ') {
                return false;
            }
        }
        return true;
    }
}

