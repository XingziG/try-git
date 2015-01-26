package dsapLecture9Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class maindriver {

	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<Card>();
		
		Card card1 = new Card("heart", 2);
		Card card2 = new Card("diamond", 2);
		Card card3 = new Card("spade", 3);
		Card card4 = new Card("club", 4);
		Card card5 = new Card("heart", 5);
		
		cards.add(card1);cards.add(card5);cards.add(card3);cards.add(card4);cards.add(card2);
		
		Collections.sort(cards);
		for (Card c : cards)
			System.out.println(c);
	}

}
