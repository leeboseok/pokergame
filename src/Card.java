import java.util.*;

class Card implements Comparable<Card>{

    static final int KIND_MAX = 4; // 카드 무늬의 수
    static final int NUM_MAX = 13; // 무늬별 카드 수

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind;
    int number;

    Card() {
        this(SPADE, 1);
    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        String kind="";
        String number="";

        switch(this.kind) {
            case 4 :
                kind = "♤";
                break;
            case 3 :
                kind = "◇";
                break;
            case 2 :
                kind = "♡";
                break;
            case 1 :
                kind = "♧";
                break;
            default :
        }

        switch(this.number) {
            case 13 :
                number = "K";
                break;
            case 12 :
                number = "Q";
                break;
            case 11 :
                number = "J";
                break;
            case 1 :
                number = "A";
                break;
            default :
                number = this.number + "";
        }
        return kind + number;
    }
    @Override
    public int compareTo(Card other) {
        // 먼저 kind (무늬) 순으로 비교
        if (kind != other.kind) {
            return Integer.compare(kind, other.kind);
        }
        // kind가 같으면 number (숫자) 순으로 비교
        return Integer.compare(number, other.number);
    }
}