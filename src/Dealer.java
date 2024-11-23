//딜러는 플레이어에게 서로 다른 5장의 카드를 나눠준다.
//6. 딜러는 플레이어의 카드를 평가하고 결과를 점수로 반환한다.(점수가 높을 수록 좋음)


// 플레이어의 카드 랭크가 동일할 때 비교
import java.util.*;

class Dealer extends Deck {

    // 플레이어에게 5장의 카드를 나눠준다.
    void dealCards(List<Player> players, int count) {

        for (Player player : players) {
            player.hand = new Card[count];
            for (int i = 0; i < count; i++) {
                player.hand[i] = pick(); // 카드 뽑기
            }
        }

    }



    // 카드 랭크를 체크를 체크한다.
    static String rankCheck(Player p) {
        int[] kindCount = new int[5]; // 1: 클로버, 2: 하트, 3: 다이아몬드, 4: 스페이드
        int[] numberCount = new int[14]; // 1~13 (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
        boolean flush = false; // 플러시
        boolean straight = false; // 스트레이트
        int consecutive = 0; // 집계

        // 카드 종류와 숫자 집계 // 왜? // 내가 이걸 왜 하려고 했지? // okay.
        for (Card card : p.hand) {
            kindCount[card.kind]++;
            numberCount[card.number]++;
        }

        // 플러시 검사
        for (int count : kindCount) {
            if (count == 5) {
                flush = true;
                break;
            }
        }

        // 스트레이트 검사
        for (int i = 1; i <= 13; i++) {
            if (numberCount[i] > 0) {
                consecutive++;
                if (consecutive == 5) {
                    straight = true;
                    break;
                }
            } else {
                consecutive = 0;
            }
        }

        if (straight && flush) return "Straight flush";
        if (flush) return "Flush";
        if (straight) return "Straight";

        boolean fourCard = false;
        boolean threeCard = false;
        int pairs = 0;

        // 카드의 숫자를 카운트
        for (int count : numberCount) {
            if (count == 4) fourCard = true;
            if (count == 3) threeCard = true;
            if (count == 2) pairs++;
        }

        if (fourCard) return "Four Card";
        if (threeCard && pairs > 0) return "Full House";
        if (threeCard) return "Triple";
        if (pairs > 1) return pairs + " pairs";
        if (pairs == 1) return "1 pair";

        return "No rank";
    }

    // 카드의 순서를 섞는다.
    void shuffle() {
        for(int n=0; n < 1000; n++) {
            int i = (int)(Math.random() * CARD_NUM);
            Card temp = cards[0];
            cards[0] = cards[i];
            cards[i] = temp;
        }
    }

    // 같은 랭크가 나왓을 때 어디서 처리?
    // 1. 메서드를 하나 더 만들어야하나?
    // 2. 기존 메서드 내에서 처리.

    // rankCheck의 결과로 점수 반환.
    static int rankScore(String rank) {
        switch (rank) {
            case "Straight flush":
                return 8;
            case "Four Card":
                return 7;
            case "Full House":
                return 6;
            case "Flush":
                return 5;
            case "Straight":
                return 4;
            case "Triple":
                return 3;
            case "2 pairs":
                return 2;
            case "1 pair":
                return 1;
            default:
                return 0;
        }
    }
}
