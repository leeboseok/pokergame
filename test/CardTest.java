import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class CardTest {

    @Test
    void testToString() {
        // Given
        Card card1 = new Card(Card.SPADE, 13);  // ♤K
        Card card2 = new Card(Card.HEART, 1);   // ♡A
        Card card3 = new Card(Card.DIAMOND, 10); // ◇10

        // When & Then
        assertEquals("♤K", card1.toString());
        assertEquals("♡A", card2.toString());
        assertEquals("◇10", card3.toString());
    }

    @Test
    void testCompareToDifferentKinds() {
        // Given
        Card card1 = new Card(Card.SPADE, 10);  // ♤10
        Card card2 = new Card(Card.HEART, 10);  // ♡10

        // When
        int result = card1.compareTo(card2);

        // Then
        assertTrue(result > 0); // SPADE(4) > HEART(2)
    }

    @Test
    void testCompareToSameKindDifferentNumbers() {
        // Given
        Card card1 = new Card(Card.SPADE, 5);   // ♤5
        Card card2 = new Card(Card.SPADE, 10);  // ♤10

        // When
        int result = card1.compareTo(card2);

        // Then
        assertTrue(result < 0); // 5 < 10
    }

    @Test
    void testCompareToSameKindAndNumber() {
        // Given
        Card card1 = new Card(Card.CLOVER, 7);  // ♧7
        Card card2 = new Card(Card.CLOVER, 7);  // ♧7

        // When
        int result = card1.compareTo(card2);

        // Then
        assertEquals(0, result); // Same kind and number
    }

    @Test
    void testSorting() {
        // Given
        List<Card> cards = Arrays.asList(
                new Card(Card.HEART, 10),   // ♡10
                new Card(Card.SPADE, 1),    // ♤A
                new Card(Card.CLOVER, 13),  // ♧K
                new Card(Card.DIAMOND, 5)   // ◇5
        );

        // When
        Collections.sort(cards);

        // Then
        List<Card> expected = Arrays.asList(
                new Card(Card.CLOVER, 13),  // ♧K
                new Card(Card.DIAMOND, 5),  // ◇5
                new Card(Card.HEART, 10),   // ♡10
                new Card(Card.SPADE, 1)     // ♤A
        );

        assertEquals(expected.toString(), cards.toString());
    }
}
