package edu.sb.skat.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "game", schema = "skat")
public class Game extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private GameState state;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private SkatTable table;

    @OneToMany(mappedBy = "game")
    private List<Hand> hands;

    @OneToOne
    @JoinColumn(name = "left_trick_card_id")
    private Card leftTrickCard;

    @OneToOne
    @JoinColumn(name = "middle_trick_card_id")
    private Card middleTrickCard;

    @OneToOne
    @JoinColumn(name = "right_trick_card_id")
    private Card rightTrickCard;

    public Game(SkatTable table, List<Hand> hands) {
        this.table = table;
        this.hands = new ArrayList<>(hands);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState value) {
        this.state = value;
    }

    public SkatTable getTable() {
        return table;
    }

    protected void setTable(SkatTable value) {
    }

    public List<Hand> getHands() {
        return new ArrayList<>(hands);
    }

    protected void setHands(List<Hand> value) {
        this.hands.clear();
        this.hands.addAll(value);
    }

    public Card getLeftTrickCard() {
        return leftTrickCard;
    }

    public void setLeftTrickCard(Card value) {
        this.leftTrickCard = value;
    }

    public Card getMiddleTrickCard() {
        return middleTrickCard;
    }

    public void setMiddleTrickCard(Card value) {
        this.middleTrickCard = value;
    }

    public Card getRightTrickCard() {
        return rightTrickCard;
    }

    public void setRightTrickCard(Card value) {
        this.rightTrickCard = value;
    }
}

