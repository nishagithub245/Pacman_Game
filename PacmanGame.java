import java.util.Scanner;

public class PacmanGame {

    public static void main(String[] args) {
        PacmanGameController game = new PacmanGameController();
        game.initializeBoard();

        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            game.displayBoard();
            System.out.print("Enter direction (up/down/left/right): ");
            String direction = scanner.nextLine().toLowerCase();
            game.movePacman(direction);
        }

        System.out.println("Game over!");
        scanner.close();
    }
}
