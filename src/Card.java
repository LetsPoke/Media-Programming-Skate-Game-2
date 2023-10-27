import Enums.CardRank;
import Enums.CardSuit;

import javax.validation.constraints.NotNull;

public class Card {

    @NotNull
    private CardSuit suit;
    @NotNull
    private CardRank rank;

    // Protected no-arg constructor
    protected Card() {
        this(CardSuit.CLUBS, CardRank.ACE);
    }

    // Constructor
    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters and setters
    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }
}
