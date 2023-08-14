package melb.steven.services;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner  = new Scanner(System.in);
    public void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public boolean askIfPlayAgain() {
        System.out.println("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
