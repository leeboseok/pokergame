import java.util.Arrays;

class Player {

    Dealer dealer=new Dealer();

    int money=10000; // 게임 머니
    String nickname; // 닉네임
    Card[] hand; // 딜러에게 받은 카드
    int wins; // 우승 횟수
    int losses; // 패배 횟수
    int point; // 승점

    Player(){};

    // 닉네임을 입력받아서 플레이어 이름 생성.
    Player(String nickname) {
        if (nickname.length()<=20) {
            this.nickname=nickname;
        } else {
            throw new IllegalArgumentException("Nickname cannot exceed 20 characters.");
        }
    }


    public String toString() {
        if (hand.length == 0) {
            return nickname + " has no cards.";
        } else {
            return nickname + " : " + Arrays.toString(hand);
        }
    }

}
