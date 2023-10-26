public class Card {

    private CardSuit suit;
    private CardRank rank;

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

    // Overriding the toString method to represent the Card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
