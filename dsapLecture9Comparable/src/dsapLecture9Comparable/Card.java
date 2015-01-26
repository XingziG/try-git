package dsapLecture9Comparable;

public class Card implements Comparable<Card>{
	private String suit;
	private int rank;
	
	public Card(String suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public int getRank(){
		return rank;
	}
	
	public int compareTo(Card other){
		return (this.getRank() < other.getRank()) ? -1 : (this.getRank() > other.getRank() ? 1 : 0);
	}
	
	public String toString(){
		return suit + ", " +rank;
	}
}
