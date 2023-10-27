import Enums.GameState;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class Game extends BaseEntity {

    @NotNull
    private GameState state = GameState.DEAL;
    @NotNull
    private SkatTable table;
    @NotNull
    private Set<Hand> hands; // Using Set<Hand> to store multiple hands. could also be List<>
    private Card leftTrickCard;
    private Card middleTrickCard;
    private Card rightTrickCard;

    // Protected no-arg constructor
    protected Game() {
        this(0, 0, 0, 0, GameState.DEAL, new SkatTable(), new HashSet<>(), null, null, null); // Assuming SkatTable has a no-arg constructor and using ArrayList to instantiate hands.
    }

    // Constructor with arguments
    public Game(long identity, int version, long created, long modified, GameState state, SkatTable table, Set<Hand> hands, Card leftTrickCard, Card middleTrickCard, Card rightTrickCard) {
        super(identity, version, created, modified);
        this.state = state;
        this.table = table;
        this.hands = hands;
        this.leftTrickCard = leftTrickCard;
        this.middleTrickCard = middleTrickCard;
        this.rightTrickCard = rightTrickCard;
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

    protected void setTable(SkatTable table) {
        this.table = table;
    }

    public Set<Hand> getHands() {
        return hands;
    }

    protected void setHands(Set<Hand> hands) {
        this.hands = hands;
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
}
