package melb.steven.models;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RobotPlayer implements Player {
    private final String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int[] makeMove(char[][] board) {
        // Implement robot logic here
        // For now, let's return a dummy move
        return new int[]{0, 0};
    }
}

