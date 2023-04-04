package poker;
/*
 * JUnit class that tests the methods in the PokerHandEvaluator class
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {
	//testing "hasPair" method in "PokerHandEvaluator" class
	@Test
	public void testHasPair() {//only one pair of cards with the same value
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(13,1); //(value, suit) same suits 
		testDeck[1] = new Card(1,1);
		testDeck[2] = new Card(8,1);
		testDeck[3] = new Card(3,1);
		testDeck[4] = new Card(1,1); 
		assertTrue(PokerHandEvaluator.hasPair(testDeck));

	}
	//testing "hasTwoPair" method in "PokerHandEvaluator" class
	@Test
	public void testHasTwoPair() { //only two cards with the same value
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(2,1); //(value, suit) same suits 
		testDeck[1] = new Card(2,1);
		testDeck[2] = new Card(3,1);
		testDeck[3] = new Card(3,1);
		testDeck[4] = new Card(1,1);
		assertTrue(PokerHandEvaluator.hasTwoPair(testDeck));

	}
	//testing "hasThreeOfAKind" method in "PokerHandEvaluator" class
	@Test
	public void testHasThreeOfAKind() { //only three cards with the same value
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(2,1); //(value, suit) same suits 
		testDeck[1] = new Card(2,1);
		testDeck[2] = new Card(2,1);
		testDeck[3] = new Card(7,1);
		testDeck[4] = new Card(8,1);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testDeck));

	}
	//testing "hasStraight" method in "PokerHandEvaluator" class
	@Test
	public void testHasStraight() {
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(11,1); //(value, suit) same suits 
		testDeck[1] = new Card(10,1);
		testDeck[2] = new Card(12,1);
		testDeck[3] = new Card(1,1);
		testDeck[4] = new Card(13,1);
		assertTrue(PokerHandEvaluator.hasStraight(testDeck));

	}
	//testing "hasFlush" method in "PokerHandEvaluator" class
	@Test
	public void testFlush() { //same suit (Works for sure)
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(3,1); //(value, suit) same suits 
		testDeck[1] = new Card(2,1);
		testDeck[2] = new Card(8,1);
		testDeck[3] = new Card(10,1);
		testDeck[4] = new Card(1,1);
		assertTrue(PokerHandEvaluator.hasFlush(testDeck));
	}
	//testing "hasFullHouse" method in "PokerHandEvaluator" class
	@Test
	public void testHasFullHouse() {
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(2,1); //(value, suit) same suits 
		testDeck[1] = new Card(2,1);
		testDeck[2] = new Card(2,1);
		testDeck[3] = new Card(8,1);
		testDeck[4] = new Card(8,1);
		assertTrue(PokerHandEvaluator.hasFullHouse(testDeck));

	}
	//testing "hasFourOfAKind" method in "PokerHandEvaluator" class
	@Test
	public void testHasFourOfAKind() {
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(2,1); //(value, suit) same suits 
		testDeck[1] = new Card(2,1);
		testDeck[2] = new Card(2,1);
		testDeck[3] = new Card(2,1);
		testDeck[4] = new Card(1,1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testDeck));

	}
	//testing "hasStraightFlush" method in "PokerHandEvaluator" class
	@Test
	public void testStraightFlush() {//
		Card[] testDeck = new Card[5];
		testDeck[0] = new Card(11,1); //(value, suit) same suits 
		testDeck[1] = new Card(10,1);
		testDeck[2] = new Card(1,1);
		testDeck[3] = new Card(12,1);
		testDeck[4] = new Card(13,1);
		assertTrue(PokerHandEvaluator.hasStraightFlush(testDeck));
	}


}
