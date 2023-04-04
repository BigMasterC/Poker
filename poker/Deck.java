package poker;
/*
 * The Deck class represents a deck of cards.  It starts off with 52 cards, 
 * but as cards are dealt from the deck, the number of cards becomes smaller. 
 */

public class Deck {
	/*
	 * (below)"cards" is private instance variable that stores the Cards 
	 * that are currently in the Deck.
	 */

	private Card[] cards;

	/*
	 * (Below) "Deck" is a constructor that initializes the Deck with 
	 * 52 card objects, representing the 52 cards that are in a standard deck.
	 */

	public Deck() {
		cards = new Card[52]; //initializes the Deck with 52 card objects; null
		int index = 0; //starting at index "0" (first index of cards array)
		for(int suit = 0; suit <= 3; suit++) { //going through each suit
			for (int value = 1; value <= 13 ; value++) {
				cards[index]= new Card(value, suit);
				/*
				 * used "new" to create a new card object 
				 * for each index I'm putting in a card object
				 */
				index++;
			}
		}
	}

	// standard copy constructor (deep copy)
	public Deck(Deck other) {
		/*(below) current object "cards" is assigned the size of the 
		 * "other.cards" array.
		 */
		cards= new Card[other.cards.length];
		for (int i = 0; i < other.cards.length; i++) {
			cards[i] = other.cards[i];
			/*
			 * populating the elements of the current object "cards" array with
			 * the elements in "other.cards"
			 */
		}
	}
	/*
	 * "getCardAt" getter returns the card that is at the specified 
	 * position in the array (using the usual 0-based indexing).
	 */
	public Card getCardAt(int position) {
		return cards[position];
	}
	/*
	 * "getNumCards" getter returns the size/"length" of the array of Cards.  
	 * (starting off equal to 52, but becomes smaller as cards are 
	 * dealt from the deck.)
	 */
	public int getNumCards() {
		return cards.length;
	}
	/*
	 * "shuffle" method re-arranges the cards that are in the deck by dividing
	 * the deck into two halves--a topHalf and a bottomHalf.
	 * The new array of cards will consist of:  the first card from the topHalf,
	 * followed by the first card from the bottomHalf, 
	 * followed by the second card from the topHalf, followed by the 
	 * second card from the bottomHalf, etc. 
	 * For cases where the number of cards in a deck is odd,
	 * the topHalf has one more card than the bottomHalf.
	 */

	public void shuffle() { //WORKS!!!
		int halfTheSizeOfDeck = cards.length/2;
		int halfTheSizeOfDeckPlusOne= (cards.length/2)+1;
		if (cards.length %2==0) {
			/*(below) initializes the topHalf variable with half of the total 
			 * amount of cards in the array
			 */
			Card[] topHalf = new Card[halfTheSizeOfDeck];
			/* (below) initializes the bottomHalf variable with half of the 
			 * total amount of cards in the array
			 */
			Card[] bottomHalf = new Card [halfTheSizeOfDeck];
			/*(below)making a new deck equal to the # of elements in the current 
			 * object deck of cards
			 */
			Card[] newDeck= new Card[cards.length];

			/*"for" loops populating top and bottom half with half of the deck
			 * with the cards in the current object "cards" array 
			 */
			for(int i = 0; i < halfTheSizeOfDeck; i++) {
				topHalf[i] = cards[i];
			}
			//"for loop to populate the bottom with the 2nd half of the array
			for (int i = halfTheSizeOfDeck; i < cards.length; i++) {
				bottomHalf[i-halfTheSizeOfDeck] = cards [i];
			}

			/*"for" loop populating the new deck with the elements in the 
			 * topHalf and bottomHalf array*/
			//"i" goes all the way to half of the original array length 
			for(int i = 0; i < halfTheSizeOfDeck; i++) {
				newDeck[i*2]= topHalf[i]; //fills in the even indexes
				newDeck[i*2+1] = bottomHalf[i]; //fills in the odd indexes
			}
			cards = newDeck;

		}else {
			/* "topHalf" is initialized with half of the total 
			 * amount of cards in the array (plus one extra card)
			 */
			Card[] topHalf = new Card[halfTheSizeOfDeckPlusOne];
			/* "bottomHalf" is initialized with the half of the total amount 
			 * of cards in the array
			 */
			Card[] bottomHalf = new Card [halfTheSizeOfDeck];
			Card[] newDeck= new Card[cards.length];
			//populating top and bottom half with half of the deck
			for(int i = 0; i < halfTheSizeOfDeckPlusOne; i++) {
				topHalf[i] = cards[i];
			}
			for (int i = halfTheSizeOfDeckPlusOne; i < cards.length; i++) {
				bottomHalf[i-halfTheSizeOfDeckPlusOne] = cards [i];
			}
			for(int i = 0; i < halfTheSizeOfDeck; i++) {
				newDeck[i*2]= topHalf[i]; //fills in the even indexes
				newDeck[i*2+1] = bottomHalf[i]; //fills in the odd indexes

			}

			newDeck[newDeck.length-1]= topHalf[topHalf.length-1]; 
			// (above) used to add one more card to the top deck
			cards = newDeck;} 
		// (above) assigns the elements in newDeck to the current object "cards" 


	}
	/*"cut" method divides the deck into two sub-packets:  
	 * The part above the specified position, and the part that is at the 
	 * specified position or below. The two sub-packets are reversed 
	 * (the top packet is placed on the bottom and the bottom packet 
	 * is placed on the top). The position value uses 0-based indexing as usual,
	 * so the card at the top of the deck (to the left in the diagrams) 
	 * is at position 0.
	 */

	public void cut(int position) {
		Card[] newDeck= new Card[cards.length];
		for (int i = position; i < cards.length; i++) {
			// puts cards below the position in the front of the newDeck array
			newDeck[i-position] = cards[i];
		}
		for(int i = 0; i < position; i++) {
		//puts cards about specified position at the end of the newDeck array
			newDeck[(cards.length-position)+i] = cards[i];
		}
		cards = newDeck;

	}
	/*
	 * "deal" removes the specified number of cards from the top of the deck and 
	 * return them as an array.
	 */

	public Card[] deal(int numCards) {//works
		Card[] notDealt = new Card[cards.length- numCards];
		//number of cards not dealt
		Card[] dealt = new Card [numCards];
		//number of cards being dealt
		for (int i =0; i < numCards; i++ ) {
			dealt[i] = cards[i];
		}
		for (int i= numCards; i < cards.length; i++) {
			notDealt[i-numCards] = cards[i];
		}
		cards= notDealt;
		return dealt;
	}

}
