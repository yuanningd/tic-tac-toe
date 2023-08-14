package melb.steven.services;


public class TicTacToeGameLogic {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';


    public boolean isMoveValid(int row, int col, char[][] board) {
        return row >= 0 && col >= 0 && row < SIZE && col < SIZE && board[row][col] == EMPTY;
    }


    public boolean checkWin(char symbol, char[][] board) {
        return checkRows(symbol, board) || checkColumns(symbol, board) || checkDiagonals(symbol, board);
    }

    private boolean checkRows(char symbol, char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
        }
        return false;
    }

    private boolean checkColumns(char symbol, char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        return false;
    }

    private boolean checkDiagonals(char symbol, char[][] board) {
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean checkDraw(int movesMade) {
        return movesMade == SIZE * SIZE;
    }
}


