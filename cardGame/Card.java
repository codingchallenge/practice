package amazon.practise.cards;

public class Card {

	private final String cardId;
    private final Denomination cardDenomination;
	  
    public Card(Denomination cardDenomination, String cardId)   {
	    this.cardId = cardId;
	    this.cardDenomination = cardDenomination;
	  }
}
