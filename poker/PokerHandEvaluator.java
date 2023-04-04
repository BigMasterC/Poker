package poker;
/*
 * This class consists of several static methods that test whether or not 
 * the player has the specified hand ("hand" being Pair, TwoPair, ThreeOfAKind
 * etc.).
 */
public class PokerHandEvaluator {

	/* "hasPair" method tests if the player has two cards of the same value.
	 * Starting off by comparing the first two cards in the array and checking 
	 * if they have the same value.
	 */

	public static boolean hasPair(Card[] cards) {
		for(int i = 0; i < cards.length; i++) {
			for (int j =i+1; j < cards.length; j++) {
				if (cards[i].getValue()==cards[j].getValue()) {
					return true;
				}
			}

		}
		return false;
	}
	/* "hasTwoPair" method tests if the player has two cards of matching values.
	 * Checks first and second index for matching values. Then checks another
	 * two indexes for matching pairs.
	 */
	public static boolean hasTwoPair(Card[] cards) { 
		for(int i = 0; i < cards.length; i++) {
			for (int j =i+1; j < cards.length; j++) {
				if (cards[i].getValue()==cards[j].getValue()) {
					//checking for first pair
					int valueOfCard = cards[i].getValue();
					for (int k = 0; k < cards.length; k++) {
						for (int l=k+1; l < cards.length; l++) {
							if (cards[k].getValue()==cards[l].getValue() &&
									valueOfCard != cards[k].getValue()) {
								/*checking for 2nd pair by making sure the 
								 * two pairs do not match the first card ("i")
								 */
								return true;
							}
						}
					}
				}
			}

		}
		return false;
	}
	/* "hasThreeOfAKind" method tests if the player has two cards of matching 
	 * values. Checks first three indexes for matching values. If they all have
	 * the same index, then the statement is true!
	 */

	public static boolean hasThreeOfAKind(Card[] cards) { //works
		for(int i = 0; i < cards.length; i++) { //removed "-1"
			for (int j =i+1; j < cards.length; j++) {
				for (int k = j+1; k < cards.length; k++) {
					if (cards[i].getValue()==cards[j].getValue()&& 
							cards[j].getValue()==cards[k].getValue()) {
						return true;
					}

				}
			}

		}
		return false;
	}

	/* "hasStraight" method tests if all of the 5 cards are consecutive and 
	 * takes into account the Ace special case.
	 */


	public static boolean hasStraight(Card [] cards) { //works
		//sorting array using Bubble Sort Algorithm
		for (int i = 0; i < cards.length; i++) {
			for (int j = 1; j < cards.length-i; j++) {
				if (cards[j].getValue()< cards[j-1].getValue()) {
					Card temporary = cards[j]; 
					//I want the indexes to switch not the values!!
					cards[j]= cards[j-1]; //switching indexes
					cards[j-1]= temporary;
				}//fin (sorted list)
			}
		}
		boolean isStraight = true; 
		for (int i = 1; i < cards.length; i++) { //go through entire array
			if (cards[i].getValue() != cards[i-1].getValue()+1) { 
				/*if cards ARE sorted correctly and current index 
				 * is NOT 1 more than the card value to the left
				 */
				isStraight = false;
			}
		}
		if (isStraight == true) { //"if sorted correctly"
			return true;
		}else if(cards[0].getValue()== 1 && cards[1].getValue() == 10 && 
				cards[2].getValue() == 11&& cards[3].getValue() == 12 && 
				cards[4].getValue() == 13) {
		//if the sorted list looks like {A,10,J,Q,K}, which is correct, then...
			return true;
		}
		return false;
	}
	/* "hasFlush" method checks if all five cards in the array have the same
	 * suit.
	 */

	public static boolean hasFlush(Card[] cards) { //works
		for(int i = 0; i < cards.length; i++) {
			for (int j =i+1; j < cards.length; j++) {
				for (int k = j+1; k < cards.length; k++) {
					for (int l = k + 1; l < cards.length; l++) {
						for(int m = l+1; m < cards.length; m++){
							if (cards[i].getSuit()==cards[j].getSuit()&& 
									cards[j].getSuit()==cards[k].getSuit() && 
									cards[k].getSuit() == cards[l].getSuit()&& 
									cards[l].getSuit()== cards[m].getSuit()) {
					/*comparing all five cards to see if they have the same suit
								*/
								return true;
							}
						}

					}

				}
			}

		}
		return false;
	}
	/* Full House is a pair of cards share the same value, and the other three
	 *  cards share a second value
	 */
	public static boolean hasFullHouse(Card[] cards) {
		if (hasTwoPair(cards)&& hasThreeOfAKind(cards)) {
			return true;
		}else {		
			return false;
		}
	}
	/* "hasFourOFAKind" checks for four cards with the same value. */
	public static boolean hasFourOfAKind(Card[] cards) {//works
		for(int i = 0; i < cards.length; i++) {
			for (int j =i+1; j < cards.length; j++) {
				for (int k = j+1; k < cards.length; k++) {
					for (int l = k + 1; l < cards.length; l++) {
						if (cards[i].getValue()==cards[j].getValue()&& 
								cards[j].getValue()==cards[k].getValue() && 
								cards[k].getValue() == cards[l].getValue()) {
							return true;
						}

					}

				}
			}

		}
		return false;
	}
	/* "hasStraightFlush" methods tests if player is holding
	 * 5 cards that qualify both as a straight and as a flush.
	 */

	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards)&& hasFlush(cards)) {
			return true;
		}else {
			return false;
		}
	}
}

