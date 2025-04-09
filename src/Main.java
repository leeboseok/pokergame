import java.util.List;
import java.util.Scanner;

public class Main {
    // 메인
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Put you wanna Games to Play > ");
        final int gamesToPlay = scanner.nextInt();
        scanner.nextLine();

        List<Player> gamePlayers = Game.preparePlayers(scanner);

        System.out.println("All Good! If you wanna start to game, enter the number 1.");
        scanner.nextLine();

        Game.runGame(gamePlayers, gamesToPlay);

        Game.printFinalResults(gamePlayers, gamesToPlay);
    }
}
