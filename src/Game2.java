//import java.util.*;
//
//class Game2 {
//    // 본 게임
//    static void playRound(List<Player> players) {
//        Dealer dealer = new Dealer();           // 딜러
//        dealer.dealCards(players, 5);     // 카드 나눠주기
//        int highestScore = -1;
//        List<Player> winners = new ArrayList<>();
//
//        for (Player player : players) {                 // 플레이어 목록(players)을 반복하며 각 플레이어에 대해 작업을 수행
//            Arrays.sort(player.hand);
//            String rank = Dealer.rankCheck(player);     // 현재 플레이어의 카드 랭크를 평가하여 rank 변수에 저장
//            int score = Dealer.rankScore(rank);         // 평가된 랭크에 따라 점수를 계산하여 score 변수에 저장
//
//            System.out.println(player + " - Rank: " + rank + " (Score: " + score + ")"); // 현재 플레이어의 카드 정보, 랭크, 점수를 출력
//
//            if (score > highestScore) {                 // 현재 플레이어의 점수가 이전 최고 점수보다 높은 경우
//                highestScore = score;                   // 최고 점수를 현재 점수로 업데이트
//                winners.clear();                        // 이전 승자 목록을 비운다.
//                winners.add(player);                    // 현재 플레이어를 새로운 승자 목록에 추가
//            } else if (score == highestScore) {         // 현재 플레이어의 점수가 최고 점수와 같은 경우
//                winners.add(player);                    // 현재 플레이어를 승자 목록에 추가
//            }
//        }
//
//        for (Player player : players) {         // 승자 처리
//            if (winners.contains(player)) {
//                player.wins++;
//                player.money += 100;            // 승자는 100원 획득
//                player.point+=3;                // 승자는 승점 3점 획득
//            } else  {
//                player.losses++;                // 패자는 0원 획득
//            }
//        }
//
//        System.out.println("Winners: " + winners);
//        System.out.println();
//    }
//
//    //메인
//    public static void main(String[] args) {
//        List<Player> gamePlayers = new ArrayList<>();       // 플레이어 슬롯
//        Scanner scanner = new Scanner(System.in);           // 스캐너로 사용자에게 [게임수, 플레이어수, 닉네임]정보를 입력 받아 게임 준비를 한다.
//        int numberOfPlayers = 0;                            // 플레이어 수.
//
//        System.out.print("Put you wanna Games to Play > "); // 게임을 몇판 할지 입력 받는다.
//        final int GAMES_TO_PLAY = scanner.nextInt();        // 게임 판수.
//        scanner.nextLine();
//        while (numberOfPlayers < 1 || numberOfPlayers > 4) {// 플레이어 수가 1명 미만 4명 초과일때, 1,2,3,4 를 제외한 다른 숫자나 문자 입력시 try catch.
//            System.out.print("Put the number of players (1-4) > ");
//            numberOfPlayers = scanner.nextInt();
//            scanner.nextLine();
//            if (numberOfPlayers < 1 || numberOfPlayers > 4) {
//                System.out.println("Please enter a number between 1 and 4.");
//            }
//        }
//
//        // 닉네임을 입력 받는다. // 만약, 20자가 넘으면 다시 입력받도록 한다.
//        for (int i = 0; i < numberOfPlayers; i++) {
//            System.out.print("Nickname (20 characters max): ");
//            String nickname = scanner.nextLine();
//            while (nickname.length() > 20) {
//                System.out.println("Nickname is too long! Please enter again.");
//                nickname = scanner.nextLine();
//            }
//            gamePlayers.add(new Player(nickname));
//        }
//
//        System.out.println("All Good! If you wanna start to game, enter the number 1.");
//        scanner.nextLine();
//
//        for (int i = 0; i < GAMES_TO_PLAY; i++) {
//            playRound(gamePlayers);
//        }
//
////        gamePlayers.sort(new Comparator<Player>() { // wins 기준 내림차순 정렬
////            @Override
////            public int compare(Player p1, Player p2) {
////                return Integer.compare(p2.wins, p1.wins);
////            }
////        });
//
//        gamePlayers.sort((p1, p2) -> Integer.compare(p2.wins, p1.wins));
//
//        System.out.println("============================ Final Results ==========================");   // 결과
//        for (Player player : gamePlayers) {
//            System.out.println(
//                    player.nickname + " - Wins: " + player.wins + ", Losses: " + player.losses + ", Money: " + player.money+", Point: "+player.point);
//        }
//        System.out.println("=====================================================================");
//        System.out.println("Today, after playing "+GAMES_TO_PLAY+" games, the final winner is The " + gamePlayers.get(0).nickname + "!");
//    }
//}