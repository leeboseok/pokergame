import java.util.Arrays;
// 게임 당 한벌의 카드만 사용.
// 카드 한벌은 서로 다른 52장의 카드로 구성
class Deck {
    final int CARD_NUM = 52; // 카드의 개수
    Card cards[] = new Card[CARD_NUM];

    // Deck의 카드를 초기화한다.
    Deck () {
        int i=0;
        for(int k=Card.KIND_MAX; k > 0; k--) {
            for(int n=1; n < Card.NUM_MAX + 1 ; n++) {
                cards[i++] = new Card(k, n);
            }
        }
    }

    // 지정된 위치(index)에 있는 카드 하나를 선택한다.
    Card pick(int index) {
        return cards[index%CARD_NUM];
    }

    // Deck에서 임의의 위치에 있는 카드 하나를 선택한다.
    Card pick() {
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }
}