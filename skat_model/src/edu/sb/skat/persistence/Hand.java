package edu.sb.skat.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "hand", schema = "skat")
public class Hand extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Person player;

    @OneToMany(mappedBy = "hand")
    private List<Card> cards;

    @Column(name = "solo", nullable = false)
    private boolean solo;

    @Column(name = "points", nullable = false)
    private short points;

    @Column(name = "bid", nullable = false)
    private short bid;

    @Column(name = "bis", nullable = false)
    private short bis;

    public Hand(Game game, Person player, List<Card> cards) {
        this.game = game;
        this.player = player;
        this.cards = new ArrayList<>(cards);
    }

    public long getBet() {
         return bid;
    }

    public void setBet(long value) {
        this.bid = (short) value;
    }

    public Game getGame() {
        return game;
    }

    protected void setGame(Game value) {
     }

    public Person getPlayer() {
        return player;
    }

    protected void setPlayer(Person value) {
     }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    protected void setCards(List<Card> value) {
        this.cards.clear();
        this.cards.addAll(value);
    }

    public short getBid() {
        return bid;
    }

    public void setBid(short value) {
        this.bid = value;
    }

    public boolean getSolo() {
        return solo;
    }

    public void setSolo(boolean value) {
        this.solo = value;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short value) {
        this.points = value;
    }
}

