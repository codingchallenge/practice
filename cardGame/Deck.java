package amazon.practise.cards;

import java.util.Arrays;
import java.util.Random;
public class Deck {
	private final Card[] cards;
	  
	public Deck(Card[] cards){
	    if (cards == null){
	      throw new RuntimeException("Exception Occurred");
	    }
	    this.cards = new Card[cards.length];
	    for (int i = 0; i<cards.length; i++){
	      this.cards[i] = cards[i];
	    }
	 }
	  
	 public void shuffle(){
	    Random rand = new Random();
	    for (int i = cards.length -1; i> 0 ; i--){
	        int j = rand.nextInt(i+1);
	        swap(cards, i, j);
	    }
	  }
	    
	  public void swap(Card[] cards, int i, int j){
	        Card card = cards[i];
	        cards[i] = cards[j];
	        cards[j] = card;
	  }
	  
	  public Card[] ShuffleAgain(){
		  Card[] ret = new Card[this.cards.length];
		  
		  Card[] temp = Arrays.copyOf(this.cards, this.cards.length);
		  int lastIndex = 0;
		  while (true){
			  if (temp.length == 1 || temp.length == 2){
				  break;
			  }
			  lastIndex = copyOddEntries(temp,ret,lastIndex);
			  Card[] temp2 = new Card[this.cards.length/2+1];
			  int lastIndexTwo = copyEvenEntries(temp, temp2,0);
			  temp = Arrays.copyOf(temp2, lastIndexTwo+1);
		  }
		  
		  return ret;
	  }
	  public static void main(String[] args){
		  
	  }
	
}
