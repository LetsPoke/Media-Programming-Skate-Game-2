import java.util.Set;

public class Game extends BaseEntity {

    private GameState state;
    private SkatTable table;
    private Card leftTrickCard;
    private Card middleTrickCard;
    private Card rightTrickCard;
    private Set<Card> hand;

    // Protected no-arg constructor
    protected Game() {
        super();
    }

    // Public constructor with arguments
    public Game(GameState state, SkatTable table) {
        this();
        this.state = state;
        this.table = table;
    }

    // Getter and Setter methods
    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public SkatTable getTable() {
        return table;
    }

    public void setTable(SkatTable table) {
        this.table = table;
    }

    public Card getLeftTrickCard() {
        return leftTrickCard;
    }

    public void setLeftTrickCard(Card leftTrickCard) {
        this.leftTrickCard = leftTrickCard;
    }

    public Card getMiddleTrickCard() {
        return middleTrickCard;
    }

    public void setMiddleTrickCard(Card middleTrickCard) {
        this.middleTrickCard = middleTrickCard;
    }

    public Card getRightTrickCard() {
        return rightTrickCard;
    }

    public void setRightTrickCard(Card rightTrickCard) {
        this.rightTrickCard = rightTrickCard;
    }

    public Set<Card> getHand() {
        return hand;
    }

    public void setHand(Set<Card> hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Game{" +
                "state=" + state +
                ", table=" + table +
                ", leftTrickCard=" + leftTrickCard +
                ", middleTrickCard=" + middleTrickCard +
                ", rightTrickCard=" + rightTrickCard +
                ", hand=" + hand +
                '}';
    }
}
