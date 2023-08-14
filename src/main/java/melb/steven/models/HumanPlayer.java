package melb.steven.models;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class HumanPlayer implements Player {
    private final String name;
    private final Scanner scanner = new Scanner(System.in);;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int[] makeMove(char[][] board) {
        int[] move = new int[2];
        System.out.println("Enter your move (row [0-2] and column [0-2]): ");
        move[0] = scanner.nextInt();
        move[1] = scanner.nextInt();
        return move;
    }
}

