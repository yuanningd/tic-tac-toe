package melb.steven;

import lombok.RequiredArgsConstructor;
import melb.steven.models.HumanPlayer;
import melb.steven.models.Player;
import melb.steven.services.TicTacToeGameLogic;
import melb.steven.services.UserInterface;

import java.util.Arrays;

import static melb.steven.services.TicTacToeGameLogic.EMPTY;
import static melb.steven.services.TicTacToeGameLogic.SIZE;

@RequiredArgsConstructor
public class GameSystem {

    public static final char PLAYER_X_SYMBOL = 'X';
    public static final char PLAYER_O_SYMBOL = 'O';

    private final UserInterface gameUI;

    private final TicTacToeGameLogic gameLogic = new TicTacToeGameLogic();
    private char[][] board;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;

    private int movesMade;

    public void start() {
        boolean playAgain;
        do {
            initializeBoard();
            addPlayer();
            movesMade = 0;
            while (true) {
                gameUI.printBoard(board);
                gameUI.displayMessage(currentPlayer.getName() + "'s turn.");
                int[] move = currentPlayer.makeMove(board);
                char symbol = (currentPlayer == playerX) ? PLAYER_X_SYMBOL : PLAYER_O_SYMBOL;
                if (makeMove(move[0], move[1], board)) {
                    if (gameLogic.checkWin(symbol, board)) {
                        gameUI.printBoard(board);
                        gameUI.displayMessage(currentPlayer.getName() + " wins!");
                        break;
                    } else if (gameLogic.checkDraw(movesMade)) {
                        gameUI.printBoard(board);
                        gameUI.displayMessage("It's a draw!");
                        break;
                    }
                    switchPlayer();
                } else {
                    gameUI.displayMessage("Invalid move. Try again.");
                }
            }
            playAgain = gameUI.askIfPlayAgain();
        } while (playAgain);

    }

    private void initializeBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(board[i], EMPTY);
        }
        //Todo: load board from previous game
    }

    private void addPlayer() {
        playerX = new HumanPlayer("Player X");
        playerO = new HumanPlayer("Player O");
        currentPlayer = playerX;
        //Todo: Let user to decide type of game player or load users from previous game
    }

    private boolean makeMove(int row, int col, char[][] board) {
        if (gameLogic.isMoveValid(row, col, board)) {
            board[row][col] = (currentPlayer == playerX) ? PLAYER_X_SYMBOL : PLAYER_O_SYMBOL;
            movesMade++;
            return true;
        }
        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public static void main(String[] args) {
        UserInterface gameUI = new UserInterface();
        GameSystem gameSystem = new GameSystem(gameUI);
        gameSystem.start();
    }
}
