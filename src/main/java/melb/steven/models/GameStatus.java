package melb.steven.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// This class is for future use to save or load games
@Getter
@RequiredArgsConstructor
public class GameStatus {
    private final Player playerX;
    private final Player playerO;

    private final char[][] board;
}
