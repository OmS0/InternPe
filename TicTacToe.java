import java.util.Scanner;

public class TicTacToe
{
    private static char[][] board = new char[3][3];
    private static char CurrentPlayer = 'X';

    public static void main(String[] args)
    {
        boolean PlayAgain = true;
        Scanner sc = new Scanner(System.in);

        while (PlayAgain)
        {
            initializeBoard();
            boolean GameWon = false;

            while (!GameWon)
            {
                displayBoard();
                int[] Move = getPlayerMove();
                int Row = Move[0];
                int Col = Move[1];

                if(isValidMove(Row, Col))
                {
                    makeMove(Row, Col);
                    GameWon = checkForWin(Row, Col);
                    if (!GameWon)
                    {
                        CurrentPlayer = (CurrentPlayer == 'X') ? '0' : 'X';
                    }
                }
                else
                {
                    System.out.println("Invalid Move. Please Try Again");
                }
            }
            displayBoard();
            System.out.println("Player " + CurrentPlayer + " Wins!");

            System.out.print("Do you want to play again? (Yes/No): ");
            String PlayAgainResponse = sc.next().toLowerCase();
            PlayAgain = PlayAgainResponse.equals("yes");
        }
        System.out.println("Thanks For Playing!");
    }
    private static void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    private static void displayBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    private static int[] getPlayerMove()
    {
        Scanner sc = new Scanner(System.in);
        int [] Move = new int[2];

        System.out.print("Player " + CurrentPlayer + ", Enter Your Move (Row and Column): ");
        Move[0] = sc.nextInt();
        Move[1] = sc.nextInt();

        return Move;
    }
    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
            return false;
        }
        return true;
    }

    private static void makeMove(int Row, int Col) {
        board[Row][Col] = CurrentPlayer;
    }

    private static boolean checkForWin(int Row, int Col) {
        // Check rows, columns, and diagonals for a win
        return (checkRow(Row) || checkColumn(Col) || checkDiagonal() || checkAntiDiagonal());
    }

    private static boolean checkRow(int Row) {
        return (board[Row][0] == CurrentPlayer && board[Row][1] == CurrentPlayer && board[Row][2] == CurrentPlayer);
    }

    private static boolean checkColumn(int Col) {
        return (board[0][Col] == CurrentPlayer && board[1][Col] == CurrentPlayer && board[2][Col] == CurrentPlayer);
    }

    private static boolean checkDiagonal() {
        return (board[0][0] == CurrentPlayer && board[1][1] == CurrentPlayer && board[2][2] == CurrentPlayer);
    }

    private static boolean checkAntiDiagonal() {
        return (board[0][2] == CurrentPlayer && board[1][1] == CurrentPlayer && board[2][0] == CurrentPlayer);
    }
}