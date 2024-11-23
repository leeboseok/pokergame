import java.util.*;

public class Game {
    // 플레이어 등록
    private static List<Player> preparePlayers(Scanner scanner) {
        List<Player> players = new ArrayList<>();
        int numberOfPlayers = 0;

        while (numberOfPlayers < 1 || numberOfPlayers > 4) {
            System.out.print("Put the number of players (1-4) > ");
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
            if (numberOfPlayers < 1 || numberOfPlayers > 4) {
                System.out.println("Please enter a number between 1 and 4.");
            }
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Nickname (20 characters max): ");
            String nickname = scanner.nextLine();
            while (nickname.length() > 20) {
                System.out.println("Nickname is too long! Please enter again.");
                nickname = scanner.nextLine();
            }
            players.add(new Player(nickname));
        }
        return players;
    }

    // 본 게임
    static void playRound(List<Player> players) {
        Dealer dealer = new Dealer();
        dealCardsToPlayers(dealer, players, 5);

        List<Player> winners = new ArrayList<>();
        calculateScoresAndDetermineWinners(players, winners);

        processWinnersAndLosers(players, winners);

        System.out.println("Winners: " + winners);
        System.out.println();
    }

    // 카드 나눠주기
    private static void dealCardsToPlayers(Dealer dealer, List<Player> players, int cardsPerPlayer) {
        dealer.dealCards(players, cardsPerPlayer);
    }

    // 점수계산 및 승자 결정
    private static int calculateScoresAndDetermineWinners(List<Player> players, List<Player> winners) {
        int highestScore = -1;
        for (Player player : players) {
            Arrays.sort(player.hand);
            String rank = Dealer.rankCheck(player);
            int score = Dealer.rankScore(rank);

            System.out.println(player + " - Rank: " + rank + " (Score: " + score + ")");

            if (score > highestScore) {
                highestScore = score;
                winners.clear();
                winners.add(player);
            } else if (score == highestScore) {
                winners.add(player);
            }
        }
        return highestScore;
    }

    // 승자 패자 승점, 머니 계산
    private static void processWinnersAndLosers(List<Player> players, List<Player> winners) {
        for (Player player : players) {
            if (winners.contains(player)) {
                player.wins++;
                player.money += 100;
                player.point += 3;
            } else {
                player.losses++;
            }
        }
    }

    // 게임 시작
    private static void runGame(List<Player> players, int gamesToPlay) {
        for (int i = 0; i < gamesToPlay; i++) {
            playRound(players);
        }
    }

    // 결과판
    private static void printFinalResults(List<Player> players, int gamesToPlay) {
        players.sort((p1, p2) -> Integer.compare(p2.wins, p1.wins));

        System.out.println("============================ Final Results ==========================");
        for (Player player : players) {
            System.out.println(
                    player.nickname + " - Wins: " + player.wins + ", Losses: " + player.losses +
                            ", Money: " + player.money + ", Point: " + player.point
            );
        }
        System.out.println("=====================================================================");
        System.out.println("Today, after playing " + gamesToPlay + " games, the final winner is The " + players.get(0).nickname + "!");
    }

    // 메인
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Put you wanna Games to Play > ");
        final int gamesToPlay = scanner.nextInt();
        scanner.nextLine();

        List<Player> gamePlayers = preparePlayers(scanner);

        System.out.println("All Good! If you wanna start to game, enter the number 1.");
        scanner.nextLine();

        runGame(gamePlayers, gamesToPlay);

        printFinalResults(gamePlayers, gamesToPlay);
    }
}
