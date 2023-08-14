package melb.steven.models;

public interface Player {
    String getName();

    //The reason I passed char[][] board as a parameter to the makeMove method is to allow different types of players
    // (human or robot) to have access to the current state of the board when deciding their move.
    int[] makeMove(char[][] board);
}

