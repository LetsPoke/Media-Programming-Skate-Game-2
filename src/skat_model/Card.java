package skat_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



@Entity
@Table(name = "card", schema = "skat")
public class Card extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "suit", nullable = false)
    private CardSuit suit;

    @Enumerated(EnumType.STRING)
    @Column(name = "rank", nullable = false)
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

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

