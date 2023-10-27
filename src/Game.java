import Enums.GameState;

import javax.validation.constraints.NotNull;

public class Game extends BaseEntity {

    @NotNull
    private GameState state;

    @NotNull
    private SkatTable table;

    private Hand hands; // Assuming that these are lists of cards

    private Card leftTickCard;
    private Card middleTickCard;
    private Card rightTickCard;

    // Default no-arg constructor
    public Game() {}

    // Constructor with arguments
    public Game(long identity, int version, long created, long modified, GameState state, Hand hands, Card leftTickCard, Card middleTickCard, Card rightTickCard, SkatTable table) {
        super(identity, version, created, modified);
        this.state = state;
        this.hands = hands;
        this.middleTickCard = middleTickCard;
        this.leftTickCard = leftTickCard;
        this.rightTickCard = rightTickCard;
        this.table = table;
    }

    // Getter methods
    public GameState getState() {
        return state;
    }

    public Hand getHands() {
        return hands;
    }

    public Card getMiddleTickCard() {
        return middleTickCard;
    }

    public Card getLeftTickCard() {
        return leftTickCard;
    }

    public Card getRightTickCard() {
        return rightTickCard;
    }

    public SkatTable getTable() {
        return table;
    }

    // Setter methods
    public void setState(GameState state) {
        this.state = state;
    }

    public void setHands(Hand hands) {
        this.hands = hands;
    }

    public void setMiddleTickCard(Card middleTickCard) {
        this.middleTickCard = middleTickCard;
    }

    public void setLeftTickCard(Card leftTickCard) {
        this.leftTickCard = leftTickCard;
    }

    public void setRightTickCard(Card rightTickCard) {
        this.rightTickCard = rightTickCard;
    }

    public void setTable(SkatTable table) {
        this.table = table;
    }
}
